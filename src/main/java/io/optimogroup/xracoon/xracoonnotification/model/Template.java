package io.optimogroup.xracoon.xracoonnotification.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(schema = "NOTIFIER", name = "TEMPLATES")
@Getter
@Setter
@SequenceGenerator(name = "templatesSeq", schema = "NOTIFIER", sequenceName = "NOTIFIER.SEQ_TEMPLATES", allocationSize = 1)
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "templatesSeq")
    private Long id;

    @Column(name = "REGISTER_DATE")
    private Timestamp registrationDate;

    @Column(name = "REGISTER_USER_ID")
    private Timestamp registerUserId;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "DESCRIPTION_GEO")
    private String descriptionGeo;

    @Column(name = "DESCRIPTION_ENG")
    private String descriptionEng;

    @Column(name = "DESCRIPTION_RU")
    private String descriptionRu;

    @Column(name = "SMS_FROM")
    private String smsFrom;

    @Column(name = "MAIL_SUBJECT")
    private String mailSubject;

}
