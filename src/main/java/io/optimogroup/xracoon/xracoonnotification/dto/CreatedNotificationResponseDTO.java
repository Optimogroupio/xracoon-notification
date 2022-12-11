package io.optimogroup.xracoon.xracoonnotification.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@Data
@Builder
public class CreatedNotificationResponseDTO {

    private Long id;
    private Long templateId;
    private String phoneNumber;
    private String emailAddress;
    private Long state;
    private Timestamp sendDate;
    private Timestamp deliveryDate;
    private String messageId;
    private String parameters;
    private Timestamp regDate;
    private String notificationText;
    private Long failedCounter;
    private String failedReason;
}
