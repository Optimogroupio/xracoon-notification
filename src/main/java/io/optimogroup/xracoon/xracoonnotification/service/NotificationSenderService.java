package io.optimogroup.xracoon.xracoonnotification.service;

import com.sendgrid.Email;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
public interface NotificationSenderService {

    void sendEmail(Email from, String subject, Email to, String description, Long notificationId);
}
