package com.honewell.hackathon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class DataPersist {

	/**
	 * @param args
	 */
	final public String JDBC_DRIVERS = "com.mysql.jdbc.Drivers";
	final public String JDBC_URL = "jdbc:mysql://localhost//DataBaseName";
	final public static String USER_NAME = "USERNAME";
	final public static String PASSWORD = "PASSWORD";
	public static Connection con = null;
	public static PreparedStatement stmt = null;
	
	public DataPersist() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Drivers");
			con = DriverManager.getConnection("oracle:mysql://localhost//Databasename",USER_NAME,PASSWORD);
			//stmt = con.p;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void DataInsert(ArrayList<Device> objArrDevice) {
		// TODO Auto-generated method stub
		
		if(null != objArrDevice){
			Iterator<Device> objItr = objArrDevice.iterator();
			while(objItr.hasNext()){
				Device objDev = objItr.next();			
				String sql = "Insert into Device values((Select (MAX(ID)+1) from DEVICE),"+objDev.getStrDeviceType()+","+objDev.getStrDeviceID()+","+objDev.getStrName()+","+objDev.getdValue()+","+objDev.getDate()+")";
				//String query = "INSERT INTO Device ("(Select (MAX(ID)+1) from DEVICE),"+" DeviceType," + " DeviceID," + " Name," + " Value," + " Date") VALUES (?, ?, ?, ?, ?, ?)";						
				try {
					stmt = con.prepareStatement(sql);
					stmt.executeQuery(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void TerminateCon() {
		if(null != con){
			con = null;
		}
		if(null != stmt){
			stmt = null;
		}
	}

}
