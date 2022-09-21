package io.optimogroup.xracoon.xracoonnotification.service;

import com.sendgrid.Email;

public interface NotificationSenderService {

    void sendEmail(Email from, String subject, Email to, String description, Long notificationId);
}
