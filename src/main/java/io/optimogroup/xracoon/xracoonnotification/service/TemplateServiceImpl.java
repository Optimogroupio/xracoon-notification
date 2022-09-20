package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.dto.TemplateDTO;
import io.optimogroup.xracoon.xracoonnotification.exception.NotifierException;
import io.optimogroup.xracoon.xracoonnotification.model.Template;
import io.optimogroup.xracoon.xracoonnotification.repository.TemplateRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Server
@RequiredArgsConstructor
@Slf4j
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    @Override
    @Transactional
    public TemplateDTO create(TemplateDTO templateDTO) {
        try {
            templateRepository.save(mapDtoToEntity(templateDTO));
            return templateDTO;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in TemplateServiceImpl.class in method create while store template in database");
            throw new NotifierException("Unknown error while store template in to the database!");
        }
    }

    @Override
    public List<TemplateDTO> getAllTemplates() {
        try {
            return templateRepository.findAll()
                    .stream().map(this::mapEntityToDto).toList();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in TemplateServiceImpl.class in method getAllTemplates while retrieve templates");
            throw new NotifierException("Unknown error while retrieve templates");
        }
    }

    @Override
    public void validateTemplateDto(TemplateDTO templateDTO) {
        if (!StringUtils.hasText(templateDTO.getDescriptionEng()) &&
                !StringUtils.hasText(templateDTO.getDescriptionGeo()) &&
                !StringUtils.hasText(templateDTO.getDescriptionRu())
        ) {
            throw new NotifierException("Description fields are required!");
        }
        if (!StringUtils.hasText(templateDTO.getSmsFrom())) {
            throw new NotifierException("SmsFrom field is required!");
        }
    }

    public Template mapDtoToEntity(TemplateDTO templateDTO) {
        Template template = new Template();
        template.setDescriptionEng(templateDTO.getDescriptionEng());
        template.setDescriptionRu(templateDTO.getDescriptionRu());
        template.setDescriptionGeo(templateDTO.getDescriptionGeo());
        template.setStatus(template.getStatus());
        template.setMailSubject(templateDTO.getMailSubject());
        template.setSmsFrom(templateDTO.getSmsFrom());
        //will be changed
        template.setRegisterUserId(templateDTO.getRegisterUserId());
        template.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));
        return template;
    }

    public TemplateDTO mapEntityToDto(Template template) {
        return TemplateDTO.builder()
                .id(template.getId())
                .descriptionGeo(template.getDescriptionGeo())
                .descriptionRu(template.getDescriptionRu())
                .descriptionEng(template.getDescriptionEng())
                .status(template.getStatus())
                .smsFrom(template.getSmsFrom())
                .registerUserId(template.getRegisterUserId())
                .mailSubject(template.getMailSubject())
                .registrationDate(template.getRegistrationDate()).build();
    }

}
