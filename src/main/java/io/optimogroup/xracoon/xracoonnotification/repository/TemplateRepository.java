package io.optimogroup.xracoon.xracoonnotification.repository;

import io.optimogroup.xracoon.xracoonnotification.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
public interface TemplateRepository extends JpaRepository<Template, Long> {

    List<Template> findAllByStatusIs(Long statusId);
}
