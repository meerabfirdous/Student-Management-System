package com.package_manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {

	
	public static Boolean  InsertStudenttoDB( Student s ) {
		
		
		Boolean  f= false;
		// jdbc code 
		
		try {
			Connection con = CP.createC();
			
			// dynamic query (parameterized query)
			String q =" Insert into students(sname,sphone,scity)  values(?,?,?)";
			
			// Prepared Statement 
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			
			//set the values of parameter
			
			pstmt.setString(1, s.getStudentName());
			pstmt.setString(2, s.getStudentPhone());
			pstmt.setString(3, s.getStudentCity());
			
			
			// execute 
			
			pstmt.executeUpdate();
			
			
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	
	
	public static boolean deleteStudent(int userId) {
		
		Boolean f= false;
		
		 try {
			Connection con=CP.createC();
			
			// write query
			String q="delete  from students where sid=?";
			
			// prepared statement for dynamic query
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// set the values of parameter
			
			pstmt.setInt(1, userId);
			
			// execute
			
			pstmt.executeUpdate();
			
			f= true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
		
	}



	public static void displayStudents(Student st) {
		
		try {
			Connection con = CP.createC();
			
			// write query
			
			String q="Select* from students;";  // static or non-paramatrized query
			
			// Statement 
			
			Statement stmt = con.createStatement();
			
			// execute 
			
			ResultSet rs= stmt.executeQuery(q); // executequery jb data la kar a raha hota hain
			
			
			/*
			  In Java, resultSet.next() moves the data cursor to the next row and returns true
			   if a row exists, making it perfect for a while loop.
			 */
			
			while(rs.next()) {
				int id = rs.getInt(1);           // 1 because id is first coulumn
				String name = rs.getString(2);
				String phone =rs.getString(3);
				String city = rs.getString(4);
				
				System.out.println("ID "+ id);
				System.out.println("Name " + name);
				System.out.println("Phone_No. " + phone);
				System.out.println("City " +  city);
				
				System.out.println("+++++++++++++++++++++++");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public static Boolean updateStudent() throws IOException {
		// TODO Auto-generated method stub
		
		Boolean f= false;
		
		try {
			Connection con = CP.createC();
			
			String q="Update students set sname=? , scity =? ,sphone = ? where sid=?";
			
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter name :");
			String name = br.readLine();
			
			System.out.println("Enter city:");
			String city = br.readLine();
			
			System.out.println("Enter phone :");
			String phone = br.readLine();
			
			System.out.println("Enter ide :");
			int id= Integer.parseInt(br.readLine());
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1,name);
			pstmt.setString(2, city);
			pstmt.setString(3, phone);
			pstmt.setInt(4, id);
			
			
			pstmt.executeUpdate();
			
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
		
	}



	
	
	
	
	
	
}

 