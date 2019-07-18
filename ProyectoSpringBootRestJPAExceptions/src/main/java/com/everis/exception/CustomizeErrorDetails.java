package com.everis.exception;

import java.util.Date;

public class CustomizeErrorDetails {

	private Date timeStamp;
	private String message;
	private String details;
	
	public CustomizeErrorDetails(Date timeStamp, String message, String details) {
		// TODO Auto-generated constructor stub
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
