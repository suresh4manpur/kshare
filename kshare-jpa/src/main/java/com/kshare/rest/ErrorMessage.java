package com.kshare.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="errormessage")
public class ErrorMessage {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
