package com.test.Kadmin.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.Kadmin.entities.NotificationEntity;

public interface SendNotificationI {

	String SendNotification(NotificationEntity notification);

}