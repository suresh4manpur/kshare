package com.kshare.batch.multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.kshare.batch.upload.CustomerResponse;
import com.kshare.batch.upload.FileConstants;
import com.kshare.batch.upload.FileUtil;
import com.kshare.batch.upload.model.Customer;

public class FileUploadJobExecutor {
	public List<Future<CustomerResponse>> execute(File fileName,ExecutorService service){
		//read the file

		BufferedReader fileReader = null;
		List<Customer> custList = null;
		String customerInfo = "";

		int CUSTOMER_NAME = 0;
		int CUSTOMER_AGE = 1;
		int CUSTOMER_GENDER = 2;
		int CUSTOMER_DOB = 3;
		int CUSTOMER_EMAIL = 4;
		int CUSTOMER_ADDRESS = 5;
		int count = 1;
		CustomerTask customerTask = null;
		List<Future<CustomerResponse>> customerFutureList = new ArrayList<>();
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			// Skips line one for header : it is happy scenario
			fileReader.readLine();
			custList = new ArrayList<>();
			
			while ((customerInfo = fileReader.readLine()) != null) {
				String customerArray[] = customerInfo.split(FileConstants.COMMA_DELIMITER);
				if (customerArray.length > 0) {
					Customer customer = new Customer(customerArray[CUSTOMER_NAME],
							Integer.parseInt(customerArray[CUSTOMER_AGE]), customerArray[CUSTOMER_GENDER],
							FileUtil.parseIntoDate(customerArray[CUSTOMER_DOB]), customerArray[CUSTOMER_EMAIL],
							customerArray[CUSTOMER_ADDRESS]);
					custList.add(customer);
					if(count == FileConstants.DB_COMMIT_FREQUENCY){

						customerTask = new CustomerTask(custList);
						customerFutureList.add(service.submit(customerTask));

						custList = new ArrayList<>();
						count = 0;
					}
					count++;
					System.out.println(customer);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customerFutureList;

		//prepare the chunk
		//create the task 
		//submit the task
	}
}
/*public List<Customer> readFromFile(File fileName) {}

}*/
