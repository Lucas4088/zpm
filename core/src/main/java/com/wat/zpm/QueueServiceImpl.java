package com.wat.zpm;

import com.wat.model.*;
import com.wat.model.Queue;
import com.wat.model.dto.QueueParametersDTO;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.zpm.repository.medicalcentre.MedicalCentreRepositoryService;
import com.wat.zpm.repository.specialization.SpecializationRepositoryService;
import com.wat.zpm.service.DoctorService;
import com.wat.zpm.service.KafkaEmailSender;
import com.wat.zpm.service.QueueService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class QueueServiceImpl implements QueueService {

    private final SpecializationRepositoryService specializationRepositoryService;
    private final MedicalCentreRepositoryService medicalCentreRepositoryService;
    private final DoctorService doctorService;

    public QueueServiceImpl(SpecializationRepositoryService specializationRepositoryService, MedicalCentreRepositoryService medicalCentreRepositoryService, DoctorService doctorService) {
        this.specializationRepositoryService = specializationRepositoryService;
        this.medicalCentreRepositoryService = medicalCentreRepositoryService;
        this.doctorService = doctorService;
    }

    @Override
    public List<Queue> getQueues(QueueParametersDTO queueParametersDTO) throws ElementNotFoundException {
        Specialization specialization;
        Set<MedicalCentre> medicalCentresByVoievodeship;
        try {
            specialization = specializationRepositoryService.findById(queueParametersDTO.getSpecializationId());
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        medicalCentresByVoievodeship =
                medicalCentreRepositoryService.findAllByVoievodeship(queueParametersDTO.getVoievodeship());

        List<Queue> queues = new LinkedList<>();

        Specialization finalSpecialization = specialization;
        List<LocalDate> minAvailableDates = new ArrayList<>();
        Set<Doctor> doctorsSpecializations;
        Integer totalNumberOfVisits = 0;
        for (MedicalCentre medicalCentre1 : medicalCentresByVoievodeship) {
            doctorsSpecializations = medicalCentre1.getDoctors()
                    .stream()
                    .filter(doctor -> doctor.getSpecializations().contains(finalSpecialization))
                    .collect(Collectors.toSet());

            for (Doctor doctor : doctorsSpecializations) {
                {
                    minAvailableDates.add(doctorService.getMinAvailableDate(doctor.getId(), medicalCentre1.getId()));
                }

                totalNumberOfVisits += doctorService.numberOfVisits(medicalCentre1.getId(), doctor);
            }
            if (!doctorsSpecializations.isEmpty()) {
                queues.add(new Queue(
                        totalNumberOfVisits,
                        medicalCentre1,
                        minAvailableDates.stream()
                                .min(Comparator.comparing(LocalDate::toEpochDay))
                                .get()
                ));
            }
        }

        return queues;
    }
}
