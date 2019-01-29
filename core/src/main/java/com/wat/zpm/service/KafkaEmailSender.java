package com.wat.zpm.service;

import com.wat.model.MailNotification;

public interface KafkaEmailSender {
    void sendEmail(MailNotification mailNotification);
}
