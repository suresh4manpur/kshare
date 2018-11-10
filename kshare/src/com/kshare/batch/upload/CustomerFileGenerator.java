package com.kshare.batch.upload;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kshare.batch.upload.model.Customer;

public class CustomerFileGenerator {
	public static void main(String[] args) {
		FileGeneratorManager fileMgr = new FileGeneratorManager();
		fileMgr.createFile();
	}

}

class FileGeneratorManager {

	public final String HEADER_ENTRIES = "Name,Age,Gender,Date_Of_Birth,Email_Id,Address";
	public static final String INCOMING_AREA_PATH = "E:\\skillhouse\\kshare\\kshare\\incoming_area\\";
	private final int VOLUME_SIZE = 100000;
	private final int COMMIT_FREQUENCY = 500;

	public void createFile() {
		int fileSize = 5;
		File[] files = new File[fileSize];
		// String[] fileNames = new String[fileSize];

		String fileName = null;

		/*
		 * for(int i=0; i < files.length ; i++){ fileName = INCOMING_AREA_PATH
		 * +"File"+i+".txt" ; files[i] = new File(fileName); }
		 */

		Customer cust = null;
		List<Customer> customers = null;
		int count = 1;
		for (int i = 0; i < files.length; i++) {
			fileName = INCOMING_AREA_PATH + "File" + i + ".txt";
			files[i] = new File(fileName);
			customers = new ArrayList<>();
			for (int j = 0; j < VOLUME_SIZE; j++) {
				cust = new Customer("Suresh", 34, "M", new Date(System.currentTimeMillis()), count + "sk@gmail.com",
						"MyAddress");
				customers.add(cust);
				count++;
			}
			writeToFile(files[i], customers);

		}

	}

	private void addHeaderToFile(File file) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.append(HEADER_ENTRIES.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void writeToFile(File file, List<Customer> custList) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.append(FileConstants.NEW_LINE_SEPARATOR);
			int count = 1;
			for (Customer customer : custList) {
				fileWriter.append(String.valueOf(customer.getName()));
				fileWriter.append(FileConstants.COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getAge()));
				fileWriter.append(FileConstants.COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getGender()));
				fileWriter.append(FileConstants.COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getDateOfBirth()));
				fileWriter.append(FileConstants.COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getEmail()));
				fileWriter.append(FileConstants.COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getAddress()));
				fileWriter.append(FileConstants.NEW_LINE_SEPARATOR);

				if (count == COMMIT_FREQUENCY) {
					fileWriter.flush();
				}

				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
