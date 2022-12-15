package io.optimogroup.xracoon.xracoonnotification.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.*;
import io.optimogroup.xracoon.xracoonnotification.dto.EmailResDTO;
import io.optimogroup.xracoon.xracoonnotification.model.NotifiCationQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationSenderServiceImpl implements NotificationSenderService {

    @Value("${sendgrid.apikey}")
    private String emailApiKey;
    private final NotificationService notificationService;
    private final NotificationLogService notificationLogService;
    private final ObjectMapper objectMapper;

    @Override
    public void sendEmail(Email from, String subject, Email to, String description, Long notificationId) {
        try {
            Content content = new Content("text/plain", description);
            Mail mail = new Mail(from, subject, new Email("irakli@optimogroup.io"), content);

            SendGrid sg = new SendGrid(emailApiKey);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            if (response != null) {
                int statusCode = response.getStatusCode();
                if (statusCode == 200 || statusCode == 201 || statusCode==202) {
                    log.info(String.valueOf(statusCode));
                    log.info(String.valueOf(response.getBody()));
                    log.info(String.valueOf(response.getHeaders()));
                    EmailResDTO emailResDTO = objectMapper.readValue(response.getBody(), EmailResDTO.class);
                    notificationLogService.createNotificationLog(notificationService.deleteById(notificationId), emailResDTO);
                } else {
                    log.error("Error" + response.getStatusCode());
                    log.error("Error body " + response.getBody());
                    log.error("Error headers " + response.getHeaders());
                    NotifiCationQueue notifiCationQueue = notificationService.get(notificationId);
                    String failReasonText = "";
                    Long FailReasonCounter = notifiCationQueue.getFailedCounter();
                    switch (statusCode) {
                        case 401 -> failReasonText = "Requires authentication!";
                        case 403 ->
                                failReasonText = "From address doesn't match Verified Sender Identity. To learn how to resolve this error, see our Sender Identity requirements.";
                        case 406 -> failReasonText = "Missing Accept header!";
                        case 426 -> failReasonText = "Too many requests/Rate limit exceeded";
                        case 500 -> failReasonText = "Internal server error";
                    }
                    notifiCationQueue.setFailedReason(failReasonText);
                    notifiCationQueue.setFailedCounter(FailReasonCounter + 1);
                    log.error(failReasonText);
                }

            } else
                log.error("Unknown error Response is null! for emails %s   %s".formatted(from, to));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("=== Error while sending email from %s with notification notificationId %s to address %s".formatted(from, notificationId, to));
        }
    }
}
