package io.optimogroup.xracoon.xracoonnotification.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NotificationDTO {
    private String phoneNumber;
    private String mail;
    private List<String> parameters;
    private Long notificationId;
    private Long languageId;
}
