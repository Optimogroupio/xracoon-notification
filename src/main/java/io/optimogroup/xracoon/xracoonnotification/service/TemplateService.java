package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.TemplateDTO;
import io.optimogroup.xracoon.xracoonnotification.model.Template;

import java.util.List;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
public interface TemplateService {
    Template get(Long id);

    TemplateDTO create(TemplateDTO templateDTO);

    void validateTemplateDto(TemplateDTO templateDTO);

    List<TemplateDTO> getAllTemplates();

    void deactivateTemplate(long id);
}
