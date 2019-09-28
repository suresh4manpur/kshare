package com.honewell.hackathon;

import java.sql.Connection;
import java.sql.Date;
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
	final public String JDBC_URL = "jdbc:mysql://localhost//TEST";
	final public static String USER_NAME = "root";
	final public static String PASSWORD = "root";
	public static Connection con = null;
	public static PreparedStatement stmt = null;
	
	public DataPersist() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Drivers");
			con = DriverManager.getConnection("oracle:mysql://localhost:8080//TEST",USER_NAME,PASSWORD);
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
		
		synchronized(this){
			if(null != objArrDevice){
				Iterator<Device> objItr = objArrDevice.iterator();
				while(objItr.hasNext()){
					Device objDev = objItr.next();			
					//String sql = "Insert into Device values((Select (MAX(ID)+1) from DEVICE),"+objDev.getStrDeviceType()+","+objDev.getStrDeviceID()+","+objDev.getStrName()+","+objDev.getdValue()+","+objDev.getDate()+")";
					String sql = "Insert into Device values((Select (MAX(ID)+1) from DEVICE),"+objDev.getStrDeviceType()+","+objDev.getStrDeviceID()+","+objDev.getStrName()+","+objDev.getdValue()+","+objDev.getDate()+")";
					String strSQL = "Insert into Device (DeviceType,DeviceID,Name,Value,Date)values(?,?,?,?)";
					//String query = "INSERT INTO Device ("(Select (MAX(ID)+1) from DEVICE),"+" DeviceType," + " DeviceID," + " Name," + " Value," + " Date") VALUES (?, ?, ?, ?, ?, ?)";						
					try {
						stmt = con.prepareStatement(strSQL);
						stmt.setString(1, objDev.getStrDeviceType());
						stmt.setString(2, objDev.getStrDeviceID());
						stmt.setString(3, objDev.getStrName());
						stmt.setDouble(4, objDev.getdValue());
						stmt.setDate(4, (Date) objDev.getDate());
						
						stmt.executeQuery(sql);
						con.commit();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
