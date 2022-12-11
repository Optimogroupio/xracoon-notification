package io.optimogroup.xracoon.xracoonnotification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@Data
@NoArgsConstructor
public class NotificationDTO {
    private String phoneNumber;
    private String mail;
    private List<String> parameters;
    private Long templateId;
    private Long languageId;
}
