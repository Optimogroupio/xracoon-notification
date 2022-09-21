package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.EmailResDTO;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import io.optimogroup.xracoon.xracoonnotification.model.NotificationLog;
import io.optimogroup.xracoon.xracoonnotification.repository.NotificationLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationLogServiceImpl implements NotificationLogService {

    private final NotificationLogRepository notificationLogRepository;

    @Override
    public void createNotificationLog(NotifiCationQueue notificationQueue, EmailResDTO emailResDTO) {
        try {
            NotificationLog notificationLog = new NotificationLog();
            notificationLog.setMessageId(emailResDTO.getX_Message_Id());
            notificationLog.setParameters(notificationQueue.getParameters());
            notificationLog.setNotificationText(notificationLog.getNotificationText());
            notificationLog.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
            notificationLog.setEmailAddress(notificationLog.getEmailAddress());
            notificationLog.setPhoneNumber(notificationLog.getPhoneNumber());
            notificationLog.setDeliveryDate(null);
            notificationLog.setTemplateId(notificationQueue.getTemplateId());
            notificationLogRepository.save(notificationLog);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error while store NotificationLog with template id %s and with notification id %s".formatted(notificationQueue.getTemplateId(), notificationQueue.getId()));
        }
    }
}
