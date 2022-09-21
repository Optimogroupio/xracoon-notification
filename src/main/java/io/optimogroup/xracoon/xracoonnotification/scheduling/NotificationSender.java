package io.optimogroup.xracoon.xracoonnotification.scheduling;

import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import io.optimogroup.xracoon.xracoonnotification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationSender {

    private final NotificationService notificationService;

    public List<NotifiCationQueue> getNotifications() {
        return notificationService
                .getNotifications();
    }

    @Scheduled(fixedDelay = 5000)
    public void sendNotification() {

    }
}
