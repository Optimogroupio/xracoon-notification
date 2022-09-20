package io.optimogroup.xracoon.xracoonnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class XracoonNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(XracoonNotificationApplication.class, args);
	}

}
