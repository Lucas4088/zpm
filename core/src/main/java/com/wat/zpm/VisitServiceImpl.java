package com.wat.zpm;

import com.wat.model.*;
import com.wat.model.dto.*;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.model.exception.OperationForbiddenException;
import com.wat.zpm.repository.dayvisits.DayVisitsRepositoryService;
import com.wat.zpm.repository.doctor.DoctorRepositoryService;
import com.wat.zpm.repository.equipment.EquipmentRepositoryService;
import com.wat.zpm.repository.medicalcentre.MedicalCentreRepositoryService;
import com.wat.zpm.repository.medicalprocedure.MedicalProcedureRepositoryService;
import com.wat.zpm.repository.patient.PatientRepositoryService;
import com.wat.zpm.repository.visit.VisitRepositoryService;
import com.wat.zpm.service.KafkaEmailSender;
import com.wat.zpm.service.MedicalCentreService;
import com.wat.zpm.service.VisitService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepositoryService visitRepositoryService;
    private final DoctorRepositoryService doctorRepositoryService;
    private final MedicalCentreRepositoryService medicalCentreRepositoryService;
    private final MedicalCentreService medicalCentreService;
    private final PatientRepositoryService patientRepositoryService;
    private final DayVisitsRepositoryService dayVisitsRepositoryService;
    private final MedicalProcedureRepositoryService medicalProcedureRepositoryService;
    private final EquipmentRepositoryService equipmentRepositoryService;
    private final KafkaEmailSender kafkaEmailSender;

    public VisitServiceImpl(VisitRepositoryService visitRepositoryService, DoctorRepositoryService doctorRepositoryService, MedicalCentreRepositoryService medicalCentreRepositoryService, MedicalCentreService medicalCentreService, PatientRepositoryService patientRepositoryService, DayVisitsRepositoryService dayVisitsRepositoryService, MedicalProcedureRepositoryService medicalProcedureRepositoryService, EquipmentRepositoryService equipmentRepositoryService, KafkaEmailSender kafkaEmailSender) {
        this.visitRepositoryService = visitRepositoryService;
        this.doctorRepositoryService = doctorRepositoryService;
        this.medicalCentreRepositoryService = medicalCentreRepositoryService;
        this.medicalCentreService = medicalCentreService;
        this.patientRepositoryService = patientRepositoryService;
        this.dayVisitsRepositoryService = dayVisitsRepositoryService;
        this.medicalProcedureRepositoryService = medicalProcedureRepositoryService;
        this.equipmentRepositoryService = equipmentRepositoryService;
        this.kafkaEmailSender = kafkaEmailSender;
    }

    @Override
    public List<Visit> list() {
        return null;
    }

    @Override
    public Visit findById(int id) throws ElementNotFoundException {
        Visit visit;

        try {
            visit = visitRepositoryService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        return visit;
    }

    @Override
    public Visit save(AddVisitDTO addVisitDTO) throws ElementNotFoundException, OperationForbiddenException {
        MedicalCentre medicalCentre;
        Doctor doctor;
        Patient patient;
        try {
            medicalCentre = medicalCentreRepositoryService.findById(addVisitDTO.getMedicalCentreId());
            doctor = doctorRepositoryService.findById(addVisitDTO.getDoctorId());
            patient = patientRepositoryService.findById(addVisitDTO.getPatientId());
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }
        //ustal koniec wizyty
        LocalTime endOfVisit = addVisitDTO.getStartOfTheVisit().plus(doctor.getLengthOfVisit(), ChronoUnit.MINUTES);

        Set<Integer> equipmentIds = medicalProcedureRepositoryService.findById(addVisitDTO.getMedicalProcedureId())
                .getEquipment()
                .stream()
                .map(Equipment::getId)
                .collect(Collectors.toSet());

        Set<Equipment> equipmentSet = equipmentRepositoryService.findByIds(equipmentIds);
        //stwóz nową wizytę
        Visit visit = new Visit(null,
                addVisitDTO.getDateOfTheVisit(),
                addVisitDTO.getStartOfTheVisit(),
                endOfVisit,
                LocalDateTime.now(),
                medicalCentre.getId(),
                equipmentSet,
                patient,
                doctor.getId(),
                VisitState.NEW,
                null,
                null,
                null,
                null,
                null);

        Set<DayVisits> dayVisits = doctor.getDayVisits();

        DayVisits dayVisitOfDate = null;

        if (dayVisits.isEmpty()) {
            doctor.setDayVisits(new HashSet<>());
        } else {
            dayVisitOfDate = dayVisits.stream()
                    .filter(dayVisits1 -> dayVisits1.getDate().equals(addVisitDTO.getDateOfTheVisit()))
                    .findFirst()
                    .orElse(null);
        }
        if (dayVisitOfDate == null) {
            throw new ElementNotFoundException("Nie znaleziono dostepnego terminu");
        } else {
            dayVisitOfDate.setNumberOfVisits(dayVisitOfDate.getNumberOfVisits() + 1);
            if (dayVisitOfDate.getNumberOfVisits().equals(dayVisitOfDate.getTotalNumberOfVisits())) {
                dayVisitOfDate.setIsAvailable(false);
            }
            dayVisitOfDate.getVisits().add(visit);

            checkEquipment(visit);
            dayVisitsRepositoryService.save(dayVisitOfDate);

            kafkaEmailSender.sendEmail(new MailNotification(
                    patient.getEmail(),
                    "Nowa wizyta",
                    "",
                    "Nowa wizyta: dnia " + visit.getDayOfTheVisit() + " " + visit.getStartOfTheVisit() + " " + "\n" +
                            "\nLekarz: " + doctor.getFirstName() + " " + doctor.getLastName() + " " +
                            "\nPlacówka medyczna: " + medicalCentre.getName()
            ));
        }
        return visit;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<LocalTime> getVisitsForDateAndMedicalCentre(Integer medicalCentreId, Integer doctorId, LocalDate date) throws ElementNotFoundException {
        MedicalCentre medicalCentre;
        Doctor doctor;
        try {
            medicalCentre = medicalCentreRepositoryService.findById(medicalCentreId);
            doctor = doctorRepositoryService.findById(doctorId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        //TODO nie w kazde dni pracuje jakiś wyjątek by się przydał

        Schedule scheduleByMedicalCentre = doctor.getSchedules().stream()
                .filter(schedule -> schedule.getMedicalCentreId().equals(medicalCentre.getId()))
                .findFirst()
                .orElse(null);

        if (scheduleByMedicalCentre == null) {
            throw new ElementNotFoundException("Lekarz nie pracuje w tej placówce");
        }

        Surgery surgery = scheduleByMedicalCentre.getSurgeries()
                .stream()
                .filter(surgery1 -> surgery1.getDayOfWeek().equals(date.getDayOfWeek()))
                .findFirst()
                .orElse(null);
        if (surgery == null) {
            throw new ElementNotFoundException("Tego dnia lekarz nie przyjmuje");
        }

        Set<DayVisits> dayVisits = doctor.getDayVisits();
        List<Visit> visits = new LinkedList<>();
        DayVisits dayVisitsOfDate = null;
        if (!dayVisits.isEmpty()) {
            dayVisitsOfDate = doctor.getDayVisits().stream()
                    .filter(dayVisits1 -> dayVisits1.getDate().equals(date))
                    .findFirst()
                    .orElse(null);
        }

        if (dayVisitsOfDate != null) {
            visits = dayVisitsOfDate.getVisits();
        }
        Map<LocalTime, Visit> timeToVisitMap = new HashMap<>();

        for (Visit visit : visits) {
            timeToVisitMap.put(visit.getStartOfTheVisit(), visit);
        }

        List<LocalTime> potentialVisitHours = new LinkedList<>();

        for (LocalTime i = surgery.getStartingTime(); i.isBefore(surgery.getFinishingTime()
                .minusMinutes(doctor.getLengthOfVisit() + 1));
             i = i.plusMinutes(doctor.getLengthOfVisit())) {
            if (timeToVisitMap.get(i) == null) {
                potentialVisitHours.add(i);
            }
        }
        return potentialVisitHours;
    }

    @Override
    public Set<PatientVisitDTO> getPatientVisits(Integer patientId)
            throws ElementNotFoundException {
        Patient patient;

        try {
            patient = patientRepositoryService.findById(patientId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }
        Set<Visit> patientVisits = visitRepositoryService.findByPatientId(patientId);

        return patientVisits.stream()
                .map(visit -> new PatientVisitDTO(
                                visit.getId(),
                                visit.getDayOfTheVisit(),
                                medicalCentreRepositoryService.findById(visit.getMedicalCentreId()),
                                patient,
                                doctorRepositoryService.findById(visit.getDoctorId()),
                                visit.getStartOfTheVisit(),
                                visit.getEndOfTheVisit(),
                                visit.getDateOfCreation(),
                                visit.getEquipment(),
                                visit.getVisitState(),
                                visit.getStateNote()
                        )
                ).collect(Collectors.toSet());
    }

    @Override
    public Visit requestCancelVisit(Integer visitId, RequestCancelVisitDTO request) throws ElementNotFoundException, OperationForbiddenException {
        Visit visit;

        try {
            visit = visitRepositoryService.findById(visitId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }
        if (visit.getDayOfTheVisit().isBefore(LocalDate.now())) {
            throw new OperationForbiddenException("Nie można zminić wizyty która już minęła");
        }

        if (visit.getVisitState() == VisitState.CANCEL) {
            throw new OperationForbiddenException("Ta wizyta już oczekuje na anulowanie");
        }

        if (visit.getVisitState() == VisitState.DECLINE || visit.getVisitState() == VisitState.DELETED) {
            throw new OperationForbiddenException("Ta wizyta została już rozpatrzona");
        }

        visit.setVisitState(VisitState.CANCEL);
        visit.setStateNote(visit.getStateNote());
        return visitRepositoryService.save(visit);
    }

    @Override
    public Visit requestRescheduleVisit(RequestRescheduleVisitDTO requestRescheduleVisitDTO) throws ElementNotFoundException, OperationForbiddenException {
        Visit visit;
        try {
            visit = visitRepositoryService.findById(requestRescheduleVisitDTO.getVisitId());
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }
        if (visit.getDayOfTheVisit().isBefore(LocalDate.now())) {
            throw new OperationForbiddenException("Nie można zminić wizyty która już minęła");
        }

        if (visit.getVisitState() == VisitState.CHANGE_DATE) {
            throw new OperationForbiddenException("Ta wizyta już oczekuje na zmianę daty");
        }

        if (visit.getVisitState() == VisitState.DECLINE || visit.getVisitState() == VisitState.DATE_CHANGED
                || visit.getVisitState() == VisitState.DELETED) {
            throw new OperationForbiddenException("Ta wizyta została już rozpatrzona");
        }

        LocalDateTime newDate = LocalDateTime
                .of(requestRescheduleVisitDTO.getNewDay(), requestRescheduleVisitDTO.getNewTime());

        Doctor doctor;

        try {
            doctor = doctorRepositoryService.findById(requestRescheduleVisitDTO.getNewDoctorId());
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        visit.setNewDoctorId(doctor.getId());
        visit.setNewRequestedDate(newDate);
        visit.setVisitState(VisitState.CHANGE_DATE);
        visit.setStateNote(requestRescheduleVisitDTO.getNote());

        return visitRepositoryService.save(visit);
    }

    @Override
    public Set<Visit> getAllToProcess(Integer medicalCentreId) {
        Set<Visit> visitsForMedicalCentre = visitRepositoryService.getAllByMedicalCentre(medicalCentreId);

        return visitsForMedicalCentre.stream()
                .filter(visit -> visit.getVisitState().equals(VisitState.CHANGE_DATE)
                        || visit.getVisitState().equals(VisitState.CANCEL))
                .filter(visit -> visit.getDayOfTheVisit().isAfter(LocalDate.now().minusDays(1)))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Visit> getAllByMedicalCentre(Integer medicalCentreId) {
        return visitRepositoryService.getAllByMedicalCentre(medicalCentreId);
    }

    @Override
    public Visit process(ProcessVisitDTO processVisitDTO) throws ElementNotFoundException, OperationForbiddenException {
        Visit visit;
        Doctor newDoctor;
        MedicalCentre medicalCentre;
        try {
            visit = visitRepositoryService.findById(processVisitDTO.getVisitId());
            newDoctor = doctorRepositoryService.findById(visit.getDoctorId());
            medicalCentre = medicalCentreRepositoryService.findById(visit.getMedicalCentreId());
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        String newNote = visit.getStateNote() + "\n" + "Receptionist: " + processVisitDTO.getNote();

        visit.setStateNote(newNote);

        validateStateFlow(visit.getVisitState(), processVisitDTO.getNewState());

        if (processVisitDTO.getNewState().equals(VisitState.DATE_CHANGED)) {
            kafkaEmailSender.sendEmail(new MailNotification(
                    visit.getPatient().getEmail(),
                    "Zmiana terminu wizyty",
                    "",
                    "Twoja wizyta z dnia " + visit.getDayOfTheVisit() + " " + visit.getStartOfTheVisit() + "\n" +
                            " zmieniła datę na: " + visit.getNewDayOfTheVisit() + " " + visit.getNewStartOfTheVisit() + "\n" +
                            "Nowy Lekarz: " + newDoctor.getFirstName() + " " + newDoctor.getLastName() + " " + "\n" +
                            "Placówka medyczna: " + medicalCentre.getName() + "" + "\n" +
                            "Notatka: " + visit.getStateNote()
            ));

            visit.setDayOfTheVisit(visit.getNewDayOfTheVisit());
            visit.setStartOfTheVisit(visit.getNewStartOfTheVisit());
            visit.setEndOfTheVisit(visit.getNewStartOfTheVisit().plusMinutes(newDoctor.getLengthOfVisit()));
            visit.setVisitState(VisitState.DATE_CHANGED);
            visit.setNewDayOfTheVisit(null);
            visit.setNewStartOfTheVisit(null);
            visit.setNewDoctorId(null);
        } else if (processVisitDTO.getNewState().equals(VisitState.DELETED)) {
            kafkaEmailSender.sendEmail(new MailNotification(
                    visit.getPatient().getEmail(),
                    "Anulowanie wizyty",
                    "",
                    "Twoja wizyta z dnia  została anulowana" + visit.getDayOfTheVisit() + " " + visit.getStartOfTheVisit() + "\n" +
                            "\nPlacówka medyczna: " + medicalCentre.getName() + "\n" +
                            "Notatka: " + visit.getStateNote()
            ));

            visit.setVisitState(VisitState.DELETED);
            visit.setNewDayOfTheVisit(null);
            visit.setNewStartOfTheVisit(null);
            visit.setNewDoctorId(null);
        } else if (processVisitDTO.getNewState().equals(VisitState.DECLINE)) {
            kafkaEmailSender.sendEmail(new MailNotification(
                    visit.getPatient().getEmail(),
                    "Anulwanie prośby",
                    "",
                    "Twoja prośba odnośnie wizyty z dnia  została odrzucona" + visit.getDayOfTheVisit() + " " + visit.getStartOfTheVisit() + "\n" +
                            "\nPlacówka medyczna: " + medicalCentre.getName() + "\n" +
                            "Notatka: " + visit.getStateNote()
            ));
            visit.setNewDayOfTheVisit(null);
            visit.setNewStartOfTheVisit(null);
            visit.setNewDoctorId(null);
            visit.setVisitState(VisitState.DECLINE);
        }

        checkEquipment(visit);

        return visitRepositoryService.save(visit);
    }


    private void validateStateFlow(VisitState visitState, VisitState newState) throws OperationForbiddenException {
        List<VisitState> cancelVisit = new ArrayList<>();
        cancelVisit.add(VisitState.DELETED);
        cancelVisit.add(VisitState.DECLINE);

        List<VisitState> rescheduleVisit = new ArrayList<>();
        rescheduleVisit.add(VisitState.DATE_CHANGED);
        rescheduleVisit.add(VisitState.DECLINE);

        if (visitState == VisitState.CANCEL) {
            if (!cancelVisit.contains(newState)) {
                throw new OperationForbiddenException("Niewłaściwy status wizyty");
            }
        } else if (visitState == VisitState.CHANGE_DATE) {
            if (!rescheduleVisit.contains(newState)) {
                throw new OperationForbiddenException("Niewłaściwy status wizyty");
            }
        }
    }

    private void checkEquipment(Visit visit) throws ElementNotFoundException, OperationForbiddenException {
        Set<String> neededEquipment = visit.getEquipment().stream()
                .map(Equipment::getName)
                .collect(Collectors.toSet());
        Set<String> availableEquipment = medicalCentreService.getAllAvailableEquipmentForDay(
                visit.getMedicalCentreId(),
                visit.getDayOfTheVisit())
                .stream()
                .map(Equipment::getName)
                .collect(Collectors.toSet());

        if (!availableEquipment.containsAll(neededEquipment)) {
            throw new OperationForbiddenException("Brak wystarczającej liczby sprzętu tego dnia ");
        }
    }
}
