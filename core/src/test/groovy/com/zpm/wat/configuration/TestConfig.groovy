package com.zpm.wat.configuration


import com.wat.zpm.repository.dayvisits.DayVisitsRepositoryService
import com.wat.zpm.repository.doctor.DoctorRepositoryService
import com.wat.zpm.repository.equipment.EquipmentRepositoryService
import com.wat.zpm.repository.medicalcentre.MedicalCentreRepositoryService
import com.wat.zpm.repository.medicalprocedure.MedicalProcedureRepositoryService
import com.wat.zpm.repository.patient.PatientRepositoryService
import com.wat.zpm.repository.visit.VisitRepositoryService
import com.wat.zpm.service.KafkaEmailSender
import com.wat.zpm.service.MedicalCentreService
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import spock.mock.DetachedMockFactory

@TestConfiguration
class TestConfig {
    def mockFactory = new DetachedMockFactory()

    @Bean
    VisitRepositoryService visitRepositoryService() {
        return mockFactory.Mock(VisitRepositoryService)
    }

    @Bean
    DoctorRepositoryService doctorRepositoryService() {
        return mockFactory.Mock(DoctorRepositoryService)
    }

    @Bean
    MedicalCentreRepositoryService medicalCentreRepositoryService() {
        return mockFactory.Mock(MedicalCentreRepositoryService)
    }

    @Bean
    PatientRepositoryService patientRepositoryService() {
        return mockFactory.Mock(PatientRepositoryService)
    }

    @Bean
    DayVisitsRepositoryService dayVisitsRepositoryService() {
        return mockFactory.Mock(DayVisitsRepositoryService)
    }

    @Bean
    MedicalProcedureRepositoryService medicalProcedureRepositoryService() {
        return mockFactory.Mock(MedicalProcedureRepositoryService)
    }

    @Bean
    MedicalCentreService medicalCentreService() {
        return mockFactory.Mock(MedicalCentreService)
    }

    @Bean
    EquipmentRepositoryService equipmentRepositoryService() {
        return mockFactory.Mock(EquipmentRepositoryService)
    }

    @Bean
    KafkaEmailSender kafkaEmailSender() {
        return mockFactory.Mock(KafkaEmailSender)
    }
}
