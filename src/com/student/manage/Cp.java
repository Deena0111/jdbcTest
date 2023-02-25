package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cp {
	static Connection con;
	public static Connection createC() {
		
		try {
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create the connection..
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3308/student";
			con=DriverManager.getConnection(url,user,password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
