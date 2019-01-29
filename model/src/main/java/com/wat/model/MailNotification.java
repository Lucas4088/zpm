package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailNotification {
    private String recipient;
    private String subject;
    private String sender;
    private String content;
}
