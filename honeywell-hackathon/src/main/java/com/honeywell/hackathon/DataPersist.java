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
import com.honeywell.hackathon.util.SensorUtil;


public class DataPersist {


	public static Connection con = null;
	public static PreparedStatement stmt = null;
	
	
	public DataPersist() {
		// TODO Auto-generated constructor stub
		

		
	}
	public void dataInsert(List<Device> objArrDevice) {
		// TODO Auto-generated method stub
		con = SensorUtil.getConnection();
		synchronized(this){
			if(null != objArrDevice){
				Iterator<Device> objItr = objArrDevice.iterator();
				while(objItr.hasNext()){
					Device objDev = objItr.next();			
					String strSQL = "insert into device (devicetype, name, value, dataunit, creationtime) values (?,?,?,?,?)";
					//String query = "INSERT INTO Device ("(Select (MAX(ID)+1) from DEVICE),"+" DeviceType," + " DeviceID," + " Name," + " Value," + " Date") VALUES (?, ?, ?, ?, ?, ?)";						
					try {
						stmt = con.prepareStatement(strSQL);
						
						stmt.setString(1, objDev.getDeviceType());
						stmt.setString(2, objDev.getName());
						stmt.setDouble(3, objDev.getValue());
						stmt.setString(4, objDev.getDataUnit());
						stmt.setTimestamp(5, objDev.getCreationTime());
						
						stmt.executeUpdate();
						//con.commit();
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
