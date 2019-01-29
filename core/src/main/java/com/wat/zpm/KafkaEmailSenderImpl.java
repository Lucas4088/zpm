package com.wat.zpm;

import com.wat.model.DayVisits;
import com.wat.model.MailNotification;
import com.wat.model.Patient;
import com.wat.model.Visit;
import com.wat.zpm.repository.dayvisits.DayVisitsRepositoryService;
import com.wat.zpm.service.KafkaEmailSender;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class KafkaEmailSenderImpl implements KafkaEmailSender {
    private final KafkaTemplate<String, MailNotification> kafkaTemplate;
    private final DayVisitsRepositoryService dayVisitsRepositoryService;
    private static final String TOPIC = "email";

    public KafkaEmailSenderImpl(KafkaTemplate<String, MailNotification> kafkaTemplate, DayVisitsRepositoryService dayVisitsRepositoryService) {
        this.kafkaTemplate = kafkaTemplate;
        this.dayVisitsRepositoryService = dayVisitsRepositoryService;
    }

    @Override
    @Async
    public void sendEmail(MailNotification mailNotification) {
        kafkaTemplate.send(TOPIC, mailNotification);
    }

    @Scheduled(cron="0 0 0 * * ?")
    public void incomingVisitSender() {
        LocalDate dateInThreeDays = LocalDate.now().plusDays(3);

        Set<Visit> visits = dayVisitsRepositoryService.findAllByDate(dateInThreeDays)
                .stream()
                .map(DayVisits::getVisits)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        String message = "Masz nadchodzącą wizytę: \n" +
                "dnia: %s o godzinie: %s";

        for (Visit visit : visits) {

            sendEmail(
                    new MailNotification(
                            visit.getPatient().getEmail(),
                            "Nadchodząca wizyta",
                            null,
                            String.format(message,dateInThreeDays,visit.getStartOfTheVisit())
                    )
            );
        }
    }


}
