package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.CreatedNotificationResponseDTO;
import io.optimogroup.xracoon.xracoonnotification.dto.Language;
import io.optimogroup.xracoon.xracoonnotification.dto.NotificationDTO;
import io.optimogroup.xracoon.xracoonnotification.exception.NotifierException;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import io.optimogroup.xracoon.xracoonnotification.model.Template;
import io.optimogroup.xracoon.xracoonnotification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.webjars.NotFoundException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final TemplateService templateService;

    @Override
    public CreatedNotificationResponseDTO createNotification(NotificationDTO notificationDTO) {
        try {
            NotifiCationQueue notifiCationQueue = notificationRepository.save(mapDtoToEntity(notificationDTO));
            return mapNotificationEntityToDto(notifiCationQueue);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in NotificationServiceImpl.class in method createNotification while creating notification");
            throw new NotifierException("Error in NotificationServiceImpl.class in method createNotification while creating notification");
        }
    }

    @Override
    public void validateNotification(NotificationDTO notificationDTO) {
        if (notificationDTO.getNotificationId() == null) {
            throw new NotifierException("Invalid notification id provided!");
        }
        if (!StringUtils.hasText(notificationDTO.getMail()) && !StringUtils.hasText(notificationDTO.getPhoneNumber()))
            throw new NotifierException("Email or Mobile fields are required!");
    }

    @Override
    public List<NotifiCationQueue> getNotifications() {
        return notificationRepository.getNotifications();
    }

    @Override
    public NotifiCationQueue deleteById(Long notificationId) {
        try {
            NotifiCationQueue notifiCationQueue = get(notificationId);
            notificationRepository.deleteById(notificationId);
            return notifiCationQueue;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Unknown error while delete notification with id %s".formatted(notificationId));
            return null;
        }
    }

    @Override
    public NotifiCationQueue get(Long notificationId) {
        return notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotFoundException("Notification not found with id %s".formatted(notificationId)));
    }

    public NotifiCationQueue mapDtoToEntity(NotificationDTO notificationDTO) {
        NotifiCationQueue notifiCationQueue = new NotifiCationQueue();
        Template template = templateService.get(notificationDTO.getNotificationId());
        if (Objects.equals(notificationDTO.getLanguageId(), Language.LANGUAGE_ENG))
            notifiCationQueue.setNotificationText(generateNotificationText(template.getDescriptionEng(),
                    notificationDTO.getParameters()));
        if (Objects.equals(notificationDTO.getLanguageId(), Language.LANGUAGE_GEO))
            notifiCationQueue.setNotificationText(generateNotificationText(template.getDescriptionGeo(),
                    notificationDTO.getParameters()));
        if (Objects.equals(notificationDTO.getLanguageId(), Language.LANGUAGE_RU))
            notifiCationQueue.setNotificationText(generateNotificationText(template.getDescriptionRu(),
                    notificationDTO.getParameters()));
        if (notificationDTO.getParameters() != null)
            notifiCationQueue.setParameters(notificationDTO.getParameters().toString());
        notifiCationQueue.setEmailAddress(notificationDTO.getMail());
        notifiCationQueue.setPhoneNumber(notificationDTO.getPhoneNumber());
        notifiCationQueue.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
//        notifiCationQueue.setState(0L);
        return notifiCationQueue;
    }

    public CreatedNotificationResponseDTO mapNotificationEntityToDto(NotifiCationQueue notifiCationQueue) {
        return CreatedNotificationResponseDTO
                .builder()
                .id(notifiCationQueue.getId())
                .notificationText(notifiCationQueue.getNotificationText())
                .emailAddress(notifiCationQueue.getEmailAddress())
                .phoneNumber(notifiCationQueue.getPhoneNumber())
                .parameters(notifiCationQueue.getParameters())
                .failedCounter(notifiCationQueue.getFailedCounter())
                .failedReason(notifiCationQueue.getFailedReason())
                .templateId(notifiCationQueue.getTemplateId())
                .messageId(notifiCationQueue.getMessageId())
                .build();
    }

    public String generateNotificationText(String description, List<String> parameters) {
        if (parameters == null) return description;
        return description.formatted(parameters);
    }
}
