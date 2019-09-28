package com.honeywell.hackathon.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import com.honeywell.hackathon.DataPersist;
import com.honeywell.hackathon.dto.Device;
import com.honeywell.hackathon.exception.SensorException;

public class TemperatureDataConsumer implements Runnable{
	 BlockingQueue<Device> queue = null;
	 @Autowired
	 DataPersist dataPersist = null;
	 private final int COMMIT_FREQUENCY = 10;

	public TemperatureDataConsumer(BlockingQueue<Device> queue) {
		super();
		this.queue = queue;
	}



	@Override
	public void run() {
		Device device = null;
		List<Device> devices = new ArrayList<Device>();
		int count = 0 ;
		while(true) {
			try {
				if(count == 0) {
					devices = new ArrayList<Device>();
				}

				device = queue.take();
				devices.add(device);
				count++;
				if(count == COMMIT_FREQUENCY) {
					count = 0;
					dataPersist.dataInsert(devices);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			double value = getRandomDoubleBetweenRange(10,50);
			device = new Device("TemperatureSensor", "Thermameter", value, new Timestamp(new Date().getTime()));
			try {
				queue.put(device);
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
