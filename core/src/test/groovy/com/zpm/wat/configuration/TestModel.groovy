package com.zpm.wat.configuration

import com.wat.model.Address
import com.wat.model.ContactDetails
import com.wat.model.DayVisits
import com.wat.model.Doctor
import com.wat.model.Equipment
import com.wat.model.Gender
import com.wat.model.HealthInsurance
import com.wat.model.HealthService
import com.wat.model.MedicalCentre
import com.wat.model.MedicalProcedure
import com.wat.model.Patient
import com.wat.model.Receptionist
import com.wat.model.Role
import com.wat.model.Schedule
import com.wat.model.Specialization
import com.wat.model.Surgery
import com.wat.model.Visit
import com.wat.model.VisitState

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class TestModel {
    static Visit getDefaultVisit() {
        return new Visit(
                1,
                LocalDate.now(),
                LocalTime.now(),
                LocalTime.now().plusMinutes(20),
                LocalDateTime.now(),
                1,
                getDefaultEquipment(),
                getDefaultPatient(),
                1,
                VisitState.NEW,
                null,
                null,
                null,
                null,
                "note"
        );
    }

    public static Set<Equipment> getDefaultEquipment() {
        Set<Equipment> equipment = new HashSet<>()
        equipment.add(new Equipment(1,
                "equipment1",
                "wtsw"))
        return equipment;
    }

    public static Patient getDefaultPatient() {
        return new Patient(
                1,
                "Patient1",
                "Password",
                "Firstname1",
                "lastnam1",
                "1111111111",
                getDefaultAddress(),
                getDefaultContactDetails(),
                Gender.FEMALE,
                "4324",
                LocalDate.now().minusYears(40),
                "PlaceOfBirth",
                null,
                "FathersFirstName",
                "MothersFirstName",
                1,
                false,
                new HashSet<Role>([new Role(1,"Patient",null)]),
                1,
                new HealthInsurance(1),
                "description"
        )
    }

    static Doctor getDefaultDoctor() {
        return new Doctor(
                1,
                "Patient1",
                "Password",
                "Firstname1",
                "lastnam1",
                "1111111111",
                getDefaultAddress(),
                getDefaultContactDetails(),
                Gender.FEMALE,
                "4324",
                LocalDate.now().minusYears(40),
                "PlaceOfBirth",
                null,
                "FathersFirstName",
                "MothersFirstName",
                1,
                false,
                new HashSet<Role>([new Role(1,"Doctor",null)]),
                new HashSet<Specialization>([getDefaultSpecialization()]),
                "description",
                132,
                new HashSet<Schedule>([getDefaultSchedule()]),
                10,
                new HashSet<DayVisits>([getDefaultDayVisits()])
        )
    }

    static Receptionist getDefaultReceptionist() {
        return new Receptionist(
                1,
                "Patient1",
                "Password",
                "Firstname1",
                "lastnam1",
                "1111111111",
                getDefaultAddress(),
                getDefaultContactDetails(),
                Gender.FEMALE,
                "4324",
                LocalDate.now().minusYears(40),
                "PlaceOfBirth",
                null,
                "FathersFirstName",
                "MothersFirstName",
                1,
                false,
                new HashSet<Role>([new Role(1,"Receptionist",null)]),
                "description"
        )
    }

    static MedicalCentre getDefaulMedicalCentre() {
        return new MedicalCentre(
                1,
                "MedicalCentre",
                "NIP",
                "REGON",
                "BANKACCOUNT",
                null,
                getDefaultAddress(),
                new HashSet<HealthService>(),
                new HashSet<Doctor>([getDefaultDoctor()]),
                new HashSet<Patient>([getDefaultPatient()]),
                new HashSet<Receptionist>([getDefaultReceptionist()]),
                "description",
                new HashSet<MedicalProcedure>([getDefaultMedicalProcedure()])
        )
    }

    static HealthService getDefaultHealthService() {
        return new HealthService(
                "HealthService"
        )
    }
    static DayVisits getDefaultDayVisits() {
        return new DayVisits(
                1,
                LocalDate.now(),
                new LinkedList<Visit>([getDefaultVisit()]),
                1,
                true,
                2,
                10
        )
    }

    static Schedule getDefaultSchedule() {
        return new Schedule(
                1,
                new HashSet<Surgery>([getDefaultSurgery()]),
                1
        )
    }

    static Surgery getDefaultSurgery() {
        return new Surgery(
                1,
                DayOfWeek.MONDAY,
                "tilte",
                LocalTime.now(),
                LocalTime.now().plusMinutes(10),
                "black"
        )
    }

    static Specialization getDefaultSpecialization() {
        return new Specialization(
                1,
                "Specialization",
                new HashSet<MedicalProcedure>([getDefaultMedicalProcedure()])
        )
    }

    static MedicalProcedure getDefaultMedicalProcedure() {
        return new MedicalProcedure(
                1,
                "Procedure",
                new HashSet<Equipment>(getDefaultEquipment())
        )
    }

    static Address getDefaultAddress() {
        return new Address(
                1,
                11,
                11,
                "01-101",
                "Locality",
                "Voievodeship",
                "Country"
        )
    }

    public static ContactDetails getDefaultContactDetails() {
        return new ContactDetails(
                "452311232",
                getDefaultAddress()
        )
    }

}


