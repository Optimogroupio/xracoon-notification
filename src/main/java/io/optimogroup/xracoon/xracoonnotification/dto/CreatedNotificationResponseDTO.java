package io.optimogroup.xracoon.xracoonnotification.dto;

import lombok.Builder;

import javax.persistence.*;
import java.sql.Timestamp;

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
    @Lob
    private byte[] notificationText;
    private Long failedCounter;
    private byte[] failedReason;
}
