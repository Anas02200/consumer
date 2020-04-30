package com.test.Kadmin.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


public class NotificationEntity {
	@Id
	private String to;
	private String title;
	private String body;
	private String priority = "high";

	public NotificationEntity(String to, String title, String body, String priority) {
		super();
		this.to = to;
		this.title = title;
		this.body = body;
		this.priority = priority;
	}

	public NotificationEntity() {
		super();
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
