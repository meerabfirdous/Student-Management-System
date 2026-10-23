package com.package_manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
	
	 static Connection con;
	
	public static Connection createC() throws SQLException {
		
		
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create the connection 
			
			String url="jdbc:mysql://localhost:3306/student_manage"; // student_manage is database name
			String user = "root";
			String password ="What@2*kalps";
			
			con=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	

	
}
