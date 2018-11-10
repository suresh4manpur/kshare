package com.kshare.batch.multithreading;

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

import com.kshare.batch.upload.CustomerResponse;
import com.kshare.batch.upload.FileConstants;
import com.kshare.batch.upload.model.Customer;

public class MultiThreadedFileUploader {
public static void main(String[] args) {
	//read the file in chucnk 
	//make runnable task
	//submit the task in thread pool
	int nThreads = 4;
	File file = new File(FileConstants.INCOMING_AREA_PATH+"CustomerFile1.txt");
	System.out.println("File is read from "+file.toString());
	ExecutorService service = Executors.newFixedThreadPool(nThreads);
	long startTime = System.currentTimeMillis();
	FileUploadJobExecutor executor = new FileUploadJobExecutor();
	List<Future<CustomerResponse>> customerFutureList = executor.execute(file,service);
	//MyFileReader reader = new MyFileReader();
	//List<Customer> customers = reader.readFromFile(file);

/*	List<Future<CustomerResponse>> customerFutureList = new ArrayList<>();
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
	}*/
	
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
	long endsTime = System.currentTimeMillis();

	service.shutdown();
	endsTime = System.currentTimeMillis();
	System.out.println("Time taken in writting into DB is "+(endsTime - startTime)/(1000)+" seconds");
	
}
}

