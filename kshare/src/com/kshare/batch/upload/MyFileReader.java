package com.kshare.batch.upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kshare.batch.upload.model.Customer;

public class MyFileReader {
	public void readFromFile(File fileName) {
		BufferedReader fileReader = null;
		String customerInfo = "";

		int CUSTOMER_NAME = 0;
		int CUSTOMER_AGE = 1;
		int CUSTOMER_GENDER = 2;
		int CUSTOMER_DOB = 3;
		int CUSTOMER_EMAIL = 4;
		int CUSTOMER_ADDRESS = 5;
		Connection con = ConnectionDispenser.getConnection();

		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			// Skips line one for header : it is happy scenario
			fileReader.readLine();
			int count = 1;
			StudentUpload upload = new StudentUpload();
			List<Customer> customerInCunk = new ArrayList<>();
			while ((customerInfo = fileReader.readLine()) != null) {
				String customerArray[] = customerInfo.split(FileConstants.COMMA_DELIMITER);
				if (customerArray.length > 0) {

					Customer customer = new Customer(customerArray[CUSTOMER_NAME],
							Integer.parseInt(customerArray[CUSTOMER_AGE]), customerArray[CUSTOMER_GENDER],
							FileUtil.parseIntoDate(customerArray[CUSTOMER_DOB]), customerArray[CUSTOMER_EMAIL],
							customerArray[CUSTOMER_ADDRESS]);
					customerInCunk.add(customer);

						if (count == FileConstants.DB_COMMIT_FREQUENCY) {
							
							long startTime = System.currentTimeMillis();
							long currentTime = 0;
							long diffTime = 0;
							// Below logic will busy in loop till 1 second
							System.out.println(Thread.currentThread().getName() + " - Processing the task..");
							for (;;) {
								currentTime = System.currentTimeMillis();
								diffTime = (currentTime - startTime); // converted

								if (diffTime > 200) {
									break;
								}
							}
							
							upload.writeToDB(customerInCunk, con);
							customerInCunk.clear();
							count = 0;
							customerInCunk = new ArrayList<>();
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
	}

	private static int getCustomerIdx(Connection con) {
		String sql_index = "SELECT MAX(CUST_NO) CUST_IDX FROM KSHARE_CUSTOMER";
		PreparedStatement ps = null;
		int cust_index = 0;
		try {
			ps = con.prepareStatement(sql_index);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			if (null != rs && rs.next()) {
				cust_index = rs.getInt("CUST_IDX");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cust_index;
	}

}
