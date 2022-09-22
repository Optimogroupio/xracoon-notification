package io.optimogroup.xracoon.xracoonnotification.repository;

import io.optimogroup.xracoon.xracoonnotification.model.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
