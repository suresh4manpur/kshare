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
	static  final String COMMA_DELIMITER = ",";
	static  final String NEW_LINE_SEPARATOR = "\n";
	public  final String HEADER_ENTRIES = "Name,Age,Gender,Date_Of_Birth,Email_Id,Address";
	public static final String INCOMING_AREA_PATH = "E:\\skillhouse\\kshare\\kshare\\incoming_area\\";
	private final int VOLUME_SIZE = 50000 *10;
	private final int COMMIT_FREQUENCY = 100;

	public File createFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the fileName: ");
		String fileName = INCOMING_AREA_PATH + sc.next() + ".txt";
		File file = new File(fileName);
		try {
			if (file.createNewFile()) {
				System.out.println("File is created !!");
				// addHeaderToFile(file);
			} else {
				System.out.println("File already exists !!");
			}
			Customer cust = null;
			List<Customer> customers = new ArrayList<>();
			for (int i = 0; i < VOLUME_SIZE; i++) {
				cust = new Customer("Suresh", 34, "M", new Date(System.currentTimeMillis()), i + "sk@gmail.com",
						"MyAddress");
				customers.add(cust);
			}
			writeToFile(file, customers);
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != sc) {
				sc.close();
			}
		}
		return file;
	}

	private  void addHeaderToFile(File file) {
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
			fileWriter.append(NEW_LINE_SEPARATOR);
			int count = 1;
			for (Customer customer : custList) {
				fileWriter.append(String.valueOf(customer.getName()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getAge()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getGender()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getDateOfBirth()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getEmail()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(customer.getAddress()));
				fileWriter.append(NEW_LINE_SEPARATOR);

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
