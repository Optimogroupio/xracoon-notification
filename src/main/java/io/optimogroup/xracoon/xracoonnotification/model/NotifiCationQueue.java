package io.optimogroup.xracoon.xracoonnotification.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(schema = "NOTIFIER", name = "NOTIFICATION_QUEUE")
@Getter
@Setter
@SequenceGenerator(name = "notificationQueueSeq", schema = "NOTIFIER", sequenceName = "NOTIFIER.SEQ_NOTIFICATION_QUEUE", allocationSize = 1)
public class NotifiCationQueue {

    @Id
    @GeneratedValue(generator = "notificationQueueSeq", strategy = GenerationType.SEQUENCE)
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
    private byte[] notificationText;

    @Column(name = "FAILED_COUNTER")
    private Long failedCounter;

    @Column(name = "FAILED_REASON")
    private byte[] failedReason;
}
