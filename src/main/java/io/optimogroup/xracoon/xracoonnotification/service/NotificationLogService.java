package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.EmailResDTO;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import io.optimogroup.xracoon.xracoonnotification.model.NotificationLog;

public interface NotificationLogService {

    void createNotificationLog(NotifiCationQueue deleteById, EmailResDTO emailResDTO);
}
