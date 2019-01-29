package com.zpm.wat

import com.wat.model.Doctor
import com.wat.model.MedicalCentre
import com.wat.model.Visit
import com.wat.model.VisitState
import com.wat.model.dto.ProcessVisitDTO
import com.wat.model.dto.RequestCancelVisitDTO
import com.wat.model.dto.RequestRescheduleVisitDTO
import com.wat.model.exception.ElementNotFoundException
import com.wat.model.exception.OperationForbiddenException
import com.wat.zpm.VisitServiceImpl
import com.wat.zpm.repository.dayvisits.DayVisitsRepositoryService
import com.wat.zpm.repository.doctor.DoctorRepositoryService
import com.wat.zpm.repository.equipment.EquipmentRepositoryService
import com.wat.zpm.repository.medicalcentre.MedicalCentreRepositoryService
import com.wat.zpm.repository.medicalprocedure.MedicalProcedureRepositoryService
import com.wat.zpm.repository.patient.PatientRepositoryService
import com.wat.zpm.repository.visit.VisitRepositoryService
import com.wat.zpm.service.KafkaEmailSender
import com.wat.zpm.service.MedicalCentreService
import com.wat.zpm.service.VisitService
import com.zpm.wat.configuration.TestConfig
import com.zpm.wat.configuration.TestModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import javax.persistence.EntityNotFoundException
import java.time.LocalDate
import java.time.LocalTime

@ContextConfiguration(classes = [VisitServiceImpl, TestConfig])
class VisitServiceTest extends Specification {

    @Autowired
    private VisitService visitService

    @Autowired
    private VisitRepositoryService visitRepositoryService

    @Autowired
    private DoctorRepositoryService doctorRepositoryService

    @Autowired
    private MedicalCentreRepositoryService medicalCentreRepositoryService

    @Autowired
    private MedicalCentreService medicalCentreService

    @Autowired
    private PatientRepositoryService patientRepositoryService

    @Autowired
    private DayVisitsRepositoryService dayVisitsRepositoryService

    @Autowired
    private MedicalProcedureRepositoryService medicalProcedureRepositoryService

    @Autowired
    private EquipmentRepositoryService equipmentRepositoryService

    @Autowired
    private KafkaEmailSender kafkaEmailSender

    def "If there's no found visit then the ElementNotFoundException is thrown"() {
        given:
        def id = 1
        visitRepositoryService.findById(id) >> { throw new EntityNotFoundException() }
        when:
        visitService.findById(id)
        then:
        thrown(ElementNotFoundException)
    }

    def "If there is found visit then no ElementNotFoundException is thrown"() {
        given:
        def id = 1
        visitRepositoryService.findById(id) >> TestModel.defaultVisit
        when:
        visitService.findById(id)
        then:
        notThrown(ElementNotFoundException)
    }

    def "If visit is in state NEW or CHANGE_DATE it is possible to request visit cancel"() {
        given:
        RequestCancelVisitDTO request = new RequestCancelVisitDTO("Note")
        def visitId = 1
        def newVisit = TestModel.defaultVisit
        newVisit.visitState = VisitState.NEW
        visitRepositoryService.findById(visitId) >> newVisit

        when:
        visitService.requestCancelVisit(visitId, request)

        then:
        newVisit.visitState == VisitState.CANCEL
        newVisit.stateNote != null
    }

    @Unroll
    def "When visit is in state #forbiddenVisitState then it is not possible to change its state"() {
        given:
        RequestCancelVisitDTO request = new RequestCancelVisitDTO("Note")
        def visitId = 1
        def newVisit = TestModel.defaultVisit
        newVisit.visitState = forbiddenVisitState
        visitRepositoryService.findById(visitId) >> newVisit

        when:
        visitService.requestCancelVisit(visitId, request)

        then:
        thrown(OperationForbiddenException)
        newVisit.visitState == forbiddenVisitState

        where:
        forbiddenVisitState << [VisitState.DECLINE, VisitState.DELETED, VisitState.CANCEL]
    }

    def "If visit is in state NEW it is possible to request visit reschedule"() {
        given:
        def newDate = LocalDate.now().plusDays(30)
        def newTime = LocalTime.now()
        def visitId = 1
        RequestRescheduleVisitDTO request = new RequestRescheduleVisitDTO(1,
                visitId,
                newDate,
                newTime,
                "Note")
        def newVisit = TestModel.defaultVisit
        newVisit.visitState = VisitState.NEW

        visitRepositoryService.findById(visitId) >> newVisit

        def newDoctor = TestModel.defaultDoctor
        doctorRepositoryService.findById(newVisit.doctorId) >> newDoctor

        when:
        visitService.requestRescheduleVisit(request)

        then:
        newVisit.visitState == VisitState.CHANGE_DATE
        newVisit.stateNote != null
    }

    def "If visit is in #forbiddeVisitState it is possible to request visit reschedule"() {
        given:
        def newDate = LocalDate.now().plusDays(30)
        def newTime = LocalTime.now()
        def visitId = 1
        RequestRescheduleVisitDTO request = new RequestRescheduleVisitDTO(1,
                visitId,
                newDate,
                newTime,
                "Note")
        def newVisit = TestModel.defaultVisit
        newVisit.visitState = forbiddeVisitState

        visitRepositoryService.findById(visitId) >> newVisit

        def newDoctor = TestModel.defaultDoctor
        doctorRepositoryService.findById(newVisit.doctorId) >> newDoctor

        when:
        visitService.requestRescheduleVisit(request)

        then:
        newVisit.visitState == forbiddeVisitState
        thrown(OperationForbiddenException)

        where:
        forbiddeVisitState << [VisitState.CHANGE_DATE, VisitState.DELETED, VisitState.DECLINE, VisitState.DATE_CHANGED]
    }

    @Unroll
    def "When visit is state #oldState and wants changes status to allowed #newState it is possible to process it"() {
        given:
        Visit visit = TestModel.defaultVisit
        Doctor doctor = TestModel.defaultDoctor
        MedicalCentre medicalCentre = TestModel.defaulMedicalCentre
        visit.visitState = oldState
        if (oldState == VisitState.CHANGE_DATE) {
            visit.newDoctorId
            visit.newStartOfTheVisit = LocalTime.now().plusMinutes(10)
            visit.newDayOfTheVisit = LocalDate.now().plusDays(30)
        }
        ProcessVisitDTO processVisitDTO = new ProcessVisitDTO(visit.id, newState, "note")
        visit.visitState = oldState

        visitRepositoryService.findById(processVisitDTO.visitId) >> visit
        doctorRepositoryService.findById(visit.doctorId) >> doctor
        medicalCentreRepositoryService.findById(visit.medicalCentreId) >> medicalCentre
        medicalCentreService.getAllAvailableEquipmentForDay(_, _) >> visit.getEquipment()
        when:
        visitService.process(processVisitDTO)

        then:
        notThrown(OperationForbiddenException)
        visit.stateNote != null
        visit.visitState == newState
        visit.newDayOfTheVisit == null
        visit.newStartOfTheVisit == null
        visit.newDoctorId == null

        where:
        oldState               | newState
        VisitState.CANCEL      | VisitState.DELETED
        VisitState.CHANGE_DATE | VisitState.DATE_CHANGED
        VisitState.CANCEL      | VisitState.DECLINE
        VisitState.CHANGE_DATE | VisitState.DECLINE
    }

    @Unroll
    def "When visit is in state #oldState and wants to switch to not allowed one #newState it is not possible to process it"() {
        given:
        Visit visit = TestModel.defaultVisit
        Doctor doctor = TestModel.defaultDoctor
        MedicalCentre medicalCentre = TestModel.defaulMedicalCentre
        visit.visitState = oldState
        if (oldState == VisitState.CHANGE_DATE) {
            visit.newDoctorId
            visit.newStartOfTheVisit = LocalTime.now().plusMinutes(10)
            visit.newDayOfTheVisit = LocalDate.now().plusDays(30)
        }
        ProcessVisitDTO processVisitDTO = new ProcessVisitDTO(visit.id, newState, "note")
        visit.visitState = oldState

        visitRepositoryService.findById(processVisitDTO.visitId) >> visit
        doctorRepositoryService.findById(visit.doctorId) >> doctor
        medicalCentreRepositoryService.findById(visit.medicalCentreId) >> medicalCentre
        medicalCentreService.getAllAvailableEquipmentForDay(_, _) >> visit.getEquipment()
        when:
        visitService.process(processVisitDTO)

        then:
        thrown(OperationForbiddenException)
        visit.stateNote != null
        visit.visitState != newState

        where:
        oldState               | newState
        VisitState.CANCEL      | VisitState.DATE_CHANGED
        VisitState.CANCEL      | VisitState.NEW
        VisitState.CANCEL      | VisitState.CHANGE_DATE
        VisitState.CHANGE_DATE | VisitState.DELETED
        VisitState.CHANGE_DATE | VisitState.NEW
    }

    def "If there is not enough medical equipment it is not possible to save a new visit"() {
        given:
        Visit visit = TestModel.defaultVisit
        Doctor doctor = TestModel.defaultDoctor
        MedicalCentre medicalCentre = TestModel.defaulMedicalCentre
        visit.visitState = VisitState.CHANGE_DATE
        if (visit.visitState == VisitState.CHANGE_DATE) {
            visit.newDoctorId
            visit.newStartOfTheVisit = LocalTime.now().plusMinutes(10)
            visit.newDayOfTheVisit = LocalDate.now().plusDays(30)
        }
        ProcessVisitDTO processVisitDTO = new ProcessVisitDTO(visit.id, VisitState.DATE_CHANGED, "note")
        visit.visitState = VisitState.DATE_CHANGED

        visitRepositoryService.findById(processVisitDTO.visitId) >> visit
        doctorRepositoryService.findById(visit.doctorId) >> doctor
        medicalCentreRepositoryService.findById(visit.medicalCentreId) >> medicalCentre
        medicalCentreService.getAllAvailableEquipmentForDay(_, _) >> []
        when:
        visitService.process(processVisitDTO)

        then:
        thrown(OperationForbiddenException)
    }
}
