package io.optimogroup.xracoon.xracoonnotification.controller;

import io.optimogroup.xracoon.xracoonnotification.dto.CreatedNotificationResponseDTO;
import io.optimogroup.xracoon.xracoonnotification.dto.NotificationDTO;
import io.optimogroup.xracoon.xracoonnotification.exception.NotificationExceptionResponse;
import io.optimogroup.xracoon.xracoonnotification.exception.NotifierException;
import io.optimogroup.xracoon.xracoonnotification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@RestController
@RequestMapping("notifications")
@Slf4j
@RequiredArgsConstructor
public class NotifierController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<?> createNotification(@RequestBody NotificationDTO notificationDTO) {
        try {
            notificationService.validateNotification(notificationDTO);
            return new ResponseEntity<>(notificationService.createNotification(notificationDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in NotifierController.class while creating notification!");
            return new ResponseEntity<>(e instanceof NotifierException ?
                    NotificationExceptionResponse.builder().message(e.getMessage()) : "Error in NotifierController.class while creating notification!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
