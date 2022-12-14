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
public class TemplateDTO {
    private Long id;
    private Timestamp registrationDate;
    private Long registerUserId;
    private Long status;
    private String descriptionGeo;
    private String descriptionEng;
    private String descriptionRu;
    private String smsFrom;
    private String mailSubject;
}
