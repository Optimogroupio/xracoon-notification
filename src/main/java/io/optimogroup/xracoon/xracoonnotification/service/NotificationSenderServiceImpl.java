package io.optimogroup.xracoon.xracoonnotification.service;

import com.sendgrid.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationSenderServiceImpl implements NotificationSenderService {

    @Value("${sendgrid.apikey}")
    private String emailApiKey;

    @Override
    public void sendEmail(Email from, String subject, Email to, String description, Long notificationId) {
        Content content = new Content("text/plain", description);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(emailApiKey);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        try {
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
