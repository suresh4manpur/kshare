package com.honeywell.hackathon.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.honeywell.hackathon.dto.Device;

public class TemperatureSensorService {
	
	public static void main(String[] args) {
		TemperatureSensorService service = new TemperatureSensorService();
		service.generateData();
		service.pushDate();
	}
	
	DataIngestService dataIngestService = new DataIngestService();
	
	 BlockingQueue<Device> queue = new ArrayBlockingQueue<Device>(1000000);
	 
	//@Override
	public void generateData() {
		new Thread(new TemperatureDataProducer(queue)).start();
		
	}

	//@Override
	public void pushDate() {
		new Thread( new TemperatureDataConsumer(queue)).start();
		
	}

}
