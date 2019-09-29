package com.honeywell.hackathon.dto;

import java.sql.Timestamp;

public class Device {
	
private long deviceId;
private String deviceType;
private String name;
private double value;
private String dataUnit;
private Timestamp creationTime;

public Device(String deviceType, String name, double value, Timestamp creationTime,String dataUnit) {
	super();
	this.deviceType = deviceType;
	this.name = name;
	this.value = value;
	this.creationTime = creationTime;
	this.dataUnit = dataUnit;
}

public Device() {
	super();
	// TODO Auto-generated constructor stub
}


public long getDeviceId() {
	return deviceId;
}

public void setDeviceId(long deviceId) {
	this.deviceId = deviceId;
}

public String getDeviceType() {
	return deviceType;
}

public void setDeviceType(String deviceType) {
	this.deviceType = deviceType;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getValue() {
	return value;
}

public void setValue(double value) {
	this.value = value;
}

public String getDataUnit() {
	return dataUnit;
}

public void setDataUnit(String dataUnit) {
	this.dataUnit = dataUnit;
}

public Timestamp getCreationTime() {
	return creationTime;
}

public void setCreationTime(Timestamp creationTime) {
	this.creationTime = creationTime;
}


}
