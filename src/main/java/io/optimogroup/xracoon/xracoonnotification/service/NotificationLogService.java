package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.EmailResDTO;
import io.optimogroup.xracoon.xracoonnotification.dto.SmsOfficeResponse;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
public interface NotificationLogService {

    void createNotificationLog(NotifiCationQueue deleteById, EmailResDTO emailResDTO);

    void createNotificationLog(NotifiCationQueue deleteById, SmsOfficeResponse body);
}
