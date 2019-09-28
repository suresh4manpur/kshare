package com.honeywell.hackathon.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

import com.honeywell.hackathon.dto.Device;
import com.honeywell.hackathon.exception.SensorException;

public class TemperatureDataProducer implements Runnable{
	 BlockingQueue<Device> queue = null;

	public TemperatureDataProducer(BlockingQueue<Device> queue) {
		super();
		this.queue = queue;
	}



	@Override
	public void run() {
		Device device = null;
		while(true) {
			double value = getRandomDoubleBetweenRange(10,50);
			device = new Device("TemperatureSensor", "Thermameter", value, new Timestamp(new Date().getTime()));
			try {
				queue.put(device);
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new SensorException("Data generation failed!");
			}
		}
		
	}
	public static double getRandomDoubleBetweenRange(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}

}
