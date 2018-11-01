package com.kshare.batch.upload;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.kshare.batch.upload.model.Customer;

public class MultiThreadedFileUploader {
public static void main(String[] args) {
	//read the file in chucnk 
	//make runnable task
	//submit the task in thread pool
	int nThreads = 5;
	ExecutorService service = Executors.newFixedThreadPool(nThreads);
	
	MyFileReader reader = new MyFileReader();
	File file = new File(FileConstants.INCOMING_AREA_PATH+args[0]);
	System.out.println("File is read from "+file.toString());
	long startTime = System.currentTimeMillis();
	List<Customer> customers = reader.readFromFile(file);
	long endsTime = System.currentTimeMillis();
	long totalReadingTime = (endsTime - startTime)/(1000);
	
	int count = 1;
	List<Customer> customerInCunk = new ArrayList<>();
	startTime = System.currentTimeMillis();
	CustomerTask customerTask = null;
	List<Future<CustomerResponse>> customerFutureList = new ArrayList<>();
	for(Customer customer : customers){
		customerInCunk.add(customer);
		if(count == FileConstants.DB_COMMIT_FREQUENCY){
			
			customerTask = new CustomerTask(customerInCunk);
			customerFutureList.add(service.submit(customerTask));
			
			//customerInCunk.clear();//
			customerInCunk = new ArrayList<>();
			count = 0;
		}
		count++;
	}
	if(customerInCunk.size() > 0){
		
		customerTask = new CustomerTask(customerInCunk);
		customerFutureList.add(service.submit(customerTask)); //Asynchronous
	}
	//service.shutdown();
	for(Future<CustomerResponse> customerFuture : customerFutureList){
		try {
			System.out.println("size updated "+customerFuture.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	endsTime = System.currentTimeMillis();
	System.out.println("Time taken in file parsing is "+totalReadingTime+" seconds");
	System.out.println("Time taken in writting into DB is "+(endsTime - startTime)/(1000)+" seconds");
	
}
}

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
		con = localConnection.get();
		CustomerResponse customerRes = null;
		customerRes =  new StudentUpload().writeToDB(customers, con);
		return customerRes;
	}
	
}

