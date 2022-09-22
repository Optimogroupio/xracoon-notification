package io.optimogroup.xracoon.xracoonnotification.controller;

import io.optimogroup.xracoon.xracoonnotification.dto.TemplateDTO;
import io.optimogroup.xracoon.xracoonnotification.exception.NotificationExceptionResponse;
import io.optimogroup.xracoon.xracoonnotification.exception.NotifierException;
import io.optimogroup.xracoon.xracoonnotification.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@RestController
@RequestMapping("templates")
@RequiredArgsConstructor
@Slf4j
public class TemplateController {

    private final TemplateService templateService;


    @PostMapping
    public ResponseEntity<?> createTemplate(@RequestBody TemplateDTO templateDTO) {
        try {
            templateService.validateTemplateDto(templateDTO);
            return new ResponseEntity<>(templateService.create(templateDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in TemplateController.class while creating template!");
            return new ResponseEntity<>(e instanceof NotifierException ?
                    NotificationExceptionResponse.builder().message(e.getMessage()) : "Error in TemplateController.class while creating template!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTemplates() {
        try {
            return new ResponseEntity<>(templateService.getAllTemplates(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in TemplateController.class while retrieve templates!");
            return new ResponseEntity<>(e instanceof NotifierException ?
                    NotificationExceptionResponse.builder().message(e.getMessage()) : "Error in TemplateController.class while retrieve templates!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deactivateTemplate(@PathVariable long id) {
        try {
            templateService.deactivateTemplate(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in TemplateController.class while deactivate template with id %s!".formatted(id));
            return new ResponseEntity<>(e instanceof NotifierException ?
                    NotificationExceptionResponse.builder().message(e.getMessage()) : "Error in TemplateController.class while deactivate template with id %s!".formatted(id),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
