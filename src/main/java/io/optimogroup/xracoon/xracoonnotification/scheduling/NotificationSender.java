package io.optimogroup.xracoon.xracoonnotification.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationSender {

    @Scheduled(cron = "*/5 * * * * *")
    public void sendNotification() {

    }
}
