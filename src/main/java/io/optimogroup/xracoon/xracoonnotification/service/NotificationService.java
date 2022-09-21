package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.CreatedNotificationResponseDTO;
import io.optimogroup.xracoon.xracoonnotification.dto.NotificationDTO;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;

import java.util.List;

public interface NotificationService {
    CreatedNotificationResponseDTO createNotification(NotificationDTO notificationDTO);

    void validateNotification(NotificationDTO notificationDTO);

    List<NotifiCationQueue> getNotifications();

    NotifiCationQueue deleteById(Long notificationId);

    NotifiCationQueue get(Long notificationId);
}
