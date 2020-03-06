package com.test.Kadmin.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.test.Kadmin.entities.NotificationEntity;
import com.test.Kadmin.services.NotificationService;

@Component
public class RabbitReciever {
	
	@Autowired
	NotificationService notificationservice;
	@Bean
	public Consumer<String> recieve() {
		
		return data -> {
			
			NotificationEntity notification=new NotificationEntity("ExponentPushToken[AfSrJVLDtfSH_deXfrr4M5]", "first notification", data, "high");
			notificationservice.SendNotification(notification);	
		};
		//System.out.println("Data received..." + data);
	}

}
