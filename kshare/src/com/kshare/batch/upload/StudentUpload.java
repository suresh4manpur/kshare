package com.kshare.batch.upload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kshare.batch.upload.model.Customer;

public class StudentUpload {
	public static void writeToDB(Customer cust, Connection con) {
		String sql_insert = "INSERT INTO KSHARE_CUSTOMER (CUST_NO,NAME,AGE,GENDER,BIRTH_DT,EMAIL_ID,ADDRESS) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		System.out.println("Adding customer records in DB..");
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql_insert);
			ps.setInt(1, cust.getCustId());
			ps.setString(2, cust.getName());
			ps.setInt(3, cust.getAge());
			ps.setString(4, cust.getGender());
			ps.setDate(5, cust.getDateOfBirth());
			ps.setString(6, cust.getEmail());
			ps.setString(7, cust.getAddress());
			ps.execute();
			con.commit();
			System.out.println("Insertion completed !!!");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			/*
			 * if(null != con){ try { con.commit(); } catch (SQLException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); } }
			 */
			if (null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public  CustomerResponse writeToDB(List<Customer> customers, Connection con) {
		System.out.println("Writting to DB starts..");
		String sql_insert = "INSERT INTO CUSTOMER (CUST_NO,NAME,AGE,GENDER,BIRTH_DT,EMAIL_ID,ADDRESS) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		System.out.println("Adding customer records in DB..");
		int count = 0;
		CustomerResponse customerRes = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql_insert);
			for(Customer cust : customers){
				ps.setInt(1, cust.getCustId());
				ps.setString(2, cust.getName());
				ps.setInt(3, cust.getAge());
				ps.setString(4, cust.getGender());
				ps.setDate(5, cust.getDateOfBirth());
				ps.setString(6, cust.getEmail());
				ps.setString(7, cust.getAddress());
				ps.addBatch();
			}

			int[] recordsUpdated = ps.executeBatch();
			con.commit();
			System.out.println("Writting to DB ends!");
			customerRes =  new CustomerResponse(recordsUpdated.length);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
		return customerRes;
	}

}
