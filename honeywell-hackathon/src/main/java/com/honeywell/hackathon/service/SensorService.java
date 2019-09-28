package com.honeywell.hackathon.service;

import java.util.List;

import com.honeywell.hackathon.dto.Device;

public interface SensorService {
	public void generateData();

	public void pushDate(List<Device> devices);
}
