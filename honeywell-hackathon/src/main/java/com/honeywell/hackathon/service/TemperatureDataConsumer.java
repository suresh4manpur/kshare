package com.honeywell.hackathon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.honeywell.hackathon.DataPersist;
import com.honeywell.hackathon.dto.Device;

public class TemperatureDataConsumer implements Runnable{
	 BlockingQueue<Device> queue = null;
	 DataPersist dataPersist = new DataPersist();
	 private final int COMMIT_FREQUENCY = 10;

	public TemperatureDataConsumer(BlockingQueue<Device> queue) {
		super();
		this.queue = queue;
	}



	@Override
	public void run() {
		Device device = null;
		List<Device> devices = null;
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
		}
		
	}
	public static double getRandomDoubleBetweenRange(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}

}
