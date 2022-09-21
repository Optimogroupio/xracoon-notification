package io.optimogroup.xracoon.xracoonnotification.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(schema = "NOTIFIER", name = "NOTIFICATION_LOG")
@Getter
@Setter
@SequenceGenerator(name = "notificationLogSeq", schema = "NOTIFIER", sequenceName = "NOTIFIER.SEQ_NOTIFICATION_LOG", allocationSize = 1)
public class NotificationLog {


    @Id
    @GeneratedValue(generator = "notificationLogSeq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "TEMPLATE_ID")
    private Long templateId;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "STATE")
    private Long state;

    @Column(name = "SENT_DATE")
    private Timestamp sendDate;

    @Column(name = "DELIVERY_DATE")
    private Timestamp deliveryDate;

    @Column(name = "MESSAGE_ID")
    private String messageId;

    @Column(name = "PARAMETERS")
    private String parameters;

    @Column(name = "REG_DATE")
    private Timestamp regDate;

    @Column(name = "NOTIFICATION_TEXT")
    @Lob
    private String notificationText;
}
