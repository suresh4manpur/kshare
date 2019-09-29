package com.honeywell.hackathon.dao;

import java.sql.Connection;
import java.util.List;

import com.honeywell.hackathon.dto.Device;
import com.honeywell.hackathon.util.SensorUtil;

public class SensorDao {
	public List<Device> getAllDeviceInfo(){
		Connection con = SensorUtil.getConnection();
		
	String sql = "select avg(value), devicetype from device group by deviceType";	
	}
}
