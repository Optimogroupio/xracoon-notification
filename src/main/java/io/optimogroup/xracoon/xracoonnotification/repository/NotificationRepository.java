package io.optimogroup.xracoon.xracoonnotification.repository;

import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
public interface NotificationRepository extends JpaRepository<NotifiCationQueue, Long>,
        PagingAndSortingRepository<NotifiCationQueue, Long> {

//    List<NotifiCationQueue> findAllByStateIs(Long state, Pageable pageable);

    @Query(value = "SELECT * FROM NOTIFIER.NOTIFICATION_QUEUE WHERE FAILED_COUNTER < 5 ", nativeQuery = true)
    List<NotifiCationQueue> getNotifications();
}
