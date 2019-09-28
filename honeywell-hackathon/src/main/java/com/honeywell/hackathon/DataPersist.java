package com.honeywell.hackathon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.honeywell.hackathon.dto.Device;
import com.honeywell.hackathon.exception.SensorException;

@Repository
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
	public void dataInsert(List<Device> objArrDevice) {
		// TODO Auto-generated method stub
		
		synchronized(this){
			if(null != objArrDevice){
				Iterator<Device> objItr = objArrDevice.iterator();
				while(objItr.hasNext()){
					Device objDev = objItr.next();			
					//String sql = "Insert into Device values((Select (MAX(ID)+1) from DEVICE),"+objDev.getStrDeviceType()+","+objDev.getStrDeviceID()+","+objDev.getStrName()+","+objDev.getdValue()+","+objDev.getDate()+")";
					//String sql = "Insert into Device values((Select (MAX(ID)+1) from DEVICE),"+objDev.getStrDeviceType()+","+objDev.getStrDeviceID()+","+objDev.getStrName()+","+objDev.getdValue()+","+objDev.getDate()+")";
					String strSQL = "Insert into Device (DeviceType,Name,Value,deviceUnit,createTime)values(?,?,?,?,?)";
					//String query = "INSERT INTO Device ("(Select (MAX(ID)+1) from DEVICE),"+" DeviceType," + " DeviceID," + " Name," + " Value," + " Date") VALUES (?, ?, ?, ?, ?, ?)";						
					try {
						stmt = con.prepareStatement(strSQL);
						stmt.setString(1, objDev.getDeviceType());
						stmt.setString(2, objDev.getName());
						stmt.setDouble(3, objDev.getValue());
						stmt.setString(4, objDev.getDataUnit());
						stmt.setTimestamp(5, objDev.getCreationTime());
						
						stmt.executeQuery(strSQL);
						con.commit();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new SensorException("Unable to insert data into database!");
					}finally {
						if(null != stmt ){
							try {
								stmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								throw new SensorException("Unable to close the connection!");

							};
						}
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
