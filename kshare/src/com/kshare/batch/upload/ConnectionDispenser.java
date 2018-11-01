package com.kshare.batch.upload;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDispenser {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
