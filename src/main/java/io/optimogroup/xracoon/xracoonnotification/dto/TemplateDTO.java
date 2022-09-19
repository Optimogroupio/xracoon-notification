package io.optimogroup.xracoon.xracoonnotification.dto;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class TemplateDTO {
    private Long id;
    private Timestamp registrationDate;
    private Timestamp registerUserId;
    private Long status;
    private String descriptionGeo;
    private String descriptionEng;
    private String descriptionRu;
    private String smsFrom;
    private String mailSubject;
}
