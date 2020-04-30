package com.test.Kadmin.servicesImp;

import java.net.URI;
import java.net.URISyntaxException;

import com.test.Kadmin.services.SendNotificationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.Kadmin.entities.NotificationEntity;

@Service
public class SendNotificationServiceImp implements SendNotificationService {

	private final String expoUrl = "https://exp.host/--/api/v2/push/send";
	private URI uri;
	private HttpHeaders headers;

	public SendNotificationServiceImp() throws URISyntaxException {
		super();
		// TODO Auto-generated constructor stub
		this.uri = new URI(this.expoUrl);
		this.headers=new HttpHeaders();
		headers.set("host","exp.host");
		headers.set("accept","application/json");
		headers.set("accept-encoding","gzip, deflate");
		headers.set("content-type","application/json");
	}


	@Override
	public String SendNotification(@RequestBody NotificationEntity notification) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<NotificationEntity> request = new HttpEntity<>(notification,this.headers);
		
		
		return  restTemplate.exchange(this.uri, HttpMethod.POST, request, String.class).getBody();
	}

}
