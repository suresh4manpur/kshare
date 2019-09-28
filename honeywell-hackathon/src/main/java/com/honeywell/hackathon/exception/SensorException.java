package com.honeywell.hackathon.exception;

public class SensorException extends RuntimeException {

	private String message;

	public SensorException(String message) {
		super();
		this.message = message;
	}

	public SensorException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SensorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
