package io.optimogroup.xracoon.xracoonnotification.repository;

import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotifiCationQueue, Long>,
        PagingAndSortingRepository<NotifiCationQueue, Long> {

    List<NotifiCationQueue> findAllByStateIs(Long state, Pageable pageable);

    @Query("""
            
            """)
    List<NotifiCationQueue> getNotifications();
}
