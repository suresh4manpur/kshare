package com.honeywell.hackathon.service;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import com.honeywell.hackathon.dto.Device;

public class TemperatureSensorService implements SensorService{
	
	@Autowired
	DataIngestService dataIngestService = null;
	
	 BlockingQueue<Device> queue = new ArrayBlockingQueue<Device>(1000000);
	 
	@Override
	public void generateData() {
		new Thread(new TemperatureDataProducer(queue)).start();
		
	}

	@Override
	public void pushDate(List<Device> devices) {
		new Thread( new TemperatureDataConsumer(queue)).start();
		
	}

}
