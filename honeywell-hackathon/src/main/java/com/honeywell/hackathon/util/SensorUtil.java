package com.honeywell.hackathon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SensorUtil {
	public final static String JDBC_DRIVERS = "com.mysql.jdbc.Driver";
	public final static String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
	final static public String USER_NAME = "root";
	final static public String PASSWORD = "root";
	public static Connection con = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
			// stmt = con.p;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
