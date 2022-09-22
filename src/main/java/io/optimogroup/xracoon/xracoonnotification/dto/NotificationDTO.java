package io.optimogroup.xracoon.xracoonnotification.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@Data
@Builder
public class NotificationDTO {
    private String phoneNumber;
    private String mail;
    private List<String> parameters;
    private Long notificationId;
    private Long languageId;
}
