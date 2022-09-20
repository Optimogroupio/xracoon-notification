package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.TemplateDTO;

import java.util.List;

public interface TemplateService {
    TemplateDTO create(TemplateDTO templateDTO);

    void validateTemplateDto(TemplateDTO templateDTO);

    List<TemplateDTO> getAllTemplates();
}
