package io.optimogroup.xracoon.xracoonnotification.scheduling;

import com.sendgrid.Email;
import com.sendgrid.Mail;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import io.optimogroup.xracoon.xracoonnotification.model.Template;
import io.optimogroup.xracoon.xracoonnotification.service.NotificationSenderService;
import io.optimogroup.xracoon.xracoonnotification.service.NotificationService;
import io.optimogroup.xracoon.xracoonnotification.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationSender {

    private final NotificationService notificationService;
    private final TemplateService templateService;
    public final NotificationSenderService notificationSenderService;

    public List<NotifiCationQueue> getNotifications() {
        return notificationService
                .getNotifications();
    }

    public void sentEmails() {
        for (NotifiCationQueue notification : getNotifications()) {  // In future take only those records whose fail count is less than 5
            if(notification.getFailedCounter() >= 5) {
                log.info("Notification {} has already failed {} times + ", notification.getId(), notification.getFailedCounter());
                continue;
            }
            Template template = templateService.get(notification.getTemplateId());
            if(notification.getEmailAddress()  != null) {
                Email emailFrom = new Email(template.getSmsFrom());
                Email emailTo = new Email(notification.getEmailAddress());
                notificationSenderService.sendEmail(emailFrom, template.getMailSubject(), emailTo, notification.getNotificationText(), notification.getId());
            }
            if(notification.getPhoneNumber() != null) {
                notificationSenderService.sendSms(template.getMailSubject(), notification);
            }
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void sendNotification() {
        sentEmails();
    }
}
