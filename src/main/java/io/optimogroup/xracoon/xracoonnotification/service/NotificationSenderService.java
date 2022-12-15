package io.optimogroup.xracoon.xracoonnotification.service;

import com.sendgrid.Email;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
public interface NotificationSenderService {

    void sendEmail(Email from, String subject, Email to, String description, Long notificationId);

    void sendSms(String subject, NotifiCationQueue notification);
}
