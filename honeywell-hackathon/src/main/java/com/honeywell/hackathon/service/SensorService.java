package com.honeywell.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.hackathon.dao.SensorDao;
import com.honeywell.hackathon.dto.Device;

@Service
public class SensorService {

@Autowired
private SensorDao sensorDao;

public List<Device> getAllDeviceInfo(){
	sensorDao.getDeviceInfoLis
}

}
