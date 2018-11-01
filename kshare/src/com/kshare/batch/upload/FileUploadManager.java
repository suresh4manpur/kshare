package com.kshare.batch.upload;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kshare.batch.upload.model.Customer;

public class FileUploadManager {
	public static void main(String[] args) {
		System.out.println("File UPload started!");
		//read the file from incoming_area
		//Write into DB
		Connection con = ConnectionDispenser.getConnection();
		MyFileReader reader = new MyFileReader();
		File file = new File(FileConstants.INCOMING_AREA_PATH+args[0]);
		System.out.println("File is read from "+file.toString());
		long startTime = System.currentTimeMillis();
		List<Customer> customers = reader.readFromFile(file);
		long endsTime = System.currentTimeMillis();
		long totalReadingTime = (endsTime - startTime)/(1000);
		
		int count = 1;
		List<Customer> customerInCunk = new ArrayList<>();
		StudentUpload upload = new StudentUpload();
		startTime = System.currentTimeMillis();
		for(Customer customer : customers){
			customerInCunk.add(customer);
			if(count == FileConstants.DB_COMMIT_FREQUENCY){
				upload.writeToDB(customerInCunk, con);
				customerInCunk.clear();
				count = 0;
			}
			count++;
		}
		if(customerInCunk.size() > 0){
			upload.writeToDB(customerInCunk, con);
		}
		endsTime = System.currentTimeMillis();
		System.out.println("Time taken in file parsing is "+totalReadingTime+" seconds");
		System.out.println("Time taken in writting into DB is "+(endsTime - startTime)/(1000)+" seconds");

		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Initiated the file writting process...");


	}
}

/*
 * public static List<Customer> getCustomer(Connection con) { PreparedStatement
 * pstm = null; String sql_select =
 * "SELECT CUST_NO,NAME,AGE,GENDER,BIRTH_DT,EMAIL_ID,ADDRESS FROM KSHARE_CUSTOMER"
 * ; Customer cust = null; List<Customer> customerList = new ArrayList<>(); try
 * { pstm = con.prepareStatement(sql_select); ResultSet rsmd =
 * pstm.executeQuery(); while (null != rsmd && rsmd.next()) { cust = new
 * Customer(); cust.setCust_No(rsmd.getInt("CUST_NO"));
 * cust.setName(rsmd.getString("NAME")); cust.setAge(rsmd.getInt("AGE"));
 * cust.setGender(rsmd.getString("GENDER"));
 * cust.setDateOfBirth(rsmd.getDate("BIRTH_DT"));
 * cust.setEmail(rsmd.getString("EMAIL_ID"));
 * cust.setAddress(rsmd.getString("ADDRESS")); System.out.println(cust);
 * customerList.add(cust); } } catch (SQLException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } return customerList; }
 */
