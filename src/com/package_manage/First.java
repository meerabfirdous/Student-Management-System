package com.package_manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class First {

	public static void main(String[] args)   throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Welcome  to Student Management App");
		
		 
		
		    while(true) {
			System.out.println("Press 1 to add students");
			System.out.println("Press 2  to delete students");
			System.out.println("Press 3 to display students");
			System.out.println("Press 4 to update student record");
			System.out.println("Press 5 to exit app");
			
			BufferedReader  br = new  BufferedReader( new InputStreamReader(System.in));
			
			int c= Integer.parseInt(br.readLine());
			
			
			if(c==1) {
				// add student
				
				System.out.println("Enter Student name");
				String name = br.readLine();
				
				
				System.out.println("Enter Student phone");
				String  phone = br.readLine();
				
				System.out.println("Enter Student city");
				String city=br.readLine();
				
			
				
				Student st = new Student(name,phone,city);
				
				 boolean answer = StudentDao.InsertStudenttoDB(st);
				
				if(answer) {
					System.out.println(" Student added successfully");
					
				}else {
					System.out.println(" Something went wrong ! Try again ......");
				}
				
				System.out.println(st );
				
			}
			else if (c==2) {
	            // delete students
				
				System.out.println("Enter user id");
				int UserId =Integer.parseInt(br.readLine());
				
				boolean answer = StudentDao.deleteStudent(UserId);
				
				if(answer) {
					System.out.println("Student deleted successfuly");
				}else {
					System.out.println(" Something went going on wrong !  Try again........");
				}
				
	     	}
			else if(c==3) {
				// display students
				
				Student st =new Student();
				StudentDao.displayStudents(st);
			}
			
			else if(c==4) {
				//  update 
				
				
				Boolean answer =StudentDao.updateStudent();
				
				if(answer) {
					System.out.println("Successfully updated....");
				}else {
					
					System.out.println("Something went going on wrong ! Try again........");
				}
				
			}
			else if(c==5) {
				// exit
				break;
			}
			else {
				//
			}
		
		
		
		}
		    
		    System.out.println("Thanku for using my application");
		    System.out.println("See you soon... BYE BYE");
	
	}
	
}
