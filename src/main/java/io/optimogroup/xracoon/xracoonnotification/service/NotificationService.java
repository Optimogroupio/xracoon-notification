package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.CreatedNotificationResponseDTO;
import io.optimogroup.xracoon.xracoonnotification.dto.NotificationDTO;

public interface NotificationService {
    CreatedNotificationResponseDTO createNotification(NotificationDTO notificationDTO);

    void validateNotification(NotificationDTO notificationDTO);
}
