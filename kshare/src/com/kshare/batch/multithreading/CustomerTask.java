package com.kshare.batch.multithreading;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.Callable;

import com.kshare.batch.upload.ConnectionDispenser;
import com.kshare.batch.upload.CustomerResponse;
import com.kshare.batch.upload.StudentUpload;
import com.kshare.batch.upload.model.Customer;

class CustomerTask implements Callable<CustomerResponse>{
	private List<Customer> customers = null;
	private Connection con = null;
	@SuppressWarnings("unchecked")
	private ThreadLocal<Connection> localConnection = new ThreadLocal<Connection>(){
		protected Connection initialValue() {
			return ConnectionDispenser.getConnection();
		}
	};
	public CustomerTask(List<Customer> customers) {
		super();
		this.customers = customers;
	}

	@Override
	public CustomerResponse call() throws Exception {
		//Read the records from file
		//Preapare java object
		//persist into DB
		long startTime = System.currentTimeMillis();
		long currentTime = 0;
		long diffTime = 0;
		// Below logic will busy in loop till 1 second
		System.out.println(Thread.currentThread().getName() + " - Processing the task..");
		for (;;) {
			currentTime = System.currentTimeMillis();
			diffTime = (currentTime - startTime); // converted

			if (diffTime > 400) {
				break;
			}
		}
		con = localConnection.get();
		CustomerResponse customerRes = null;
		customerRes =  new StudentUpload().writeToDB(customers, con);
		return customerRes;
	}
	
}

