package com.employee1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

 class Main_method_Employee {
	static Connection con=null;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		int num;
		try {
		Class.forName("com.mysql.jdbc.Driver");

		//driverconnection
		
		   con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/test","root","Kishore1142..");
		if(con!=null)
		{
			System.out.println("Connected");
		}
		    do {
				
				System.out.println("Enter your choice");
				System.out.println("Enter 1 if you want to insert data");
				System.out.println("Enter 2 if you want to select data");
				System.out.println("Enter 3 if you want to update data");
				System.out.println("Enter 4 if you want to delete data");
				System.out.println("Enter 0 to exit");
				num=sc.nextInt();
				
				switch(num) 
				{
				case 1:
					Operations.insertion();
				
				break;
				case 2:
					Operations.display();
					break;
					
				case 3:
					Operations.update();
					break;
				case 4:					
					Operations.delete();
					break;
				
				}
				}while(num!=0);
		}
		catch (SQLException e) 
		{
		   e.printStackTrace();
	   	}
		catch (ClassNotFoundException c)
		{
		c.printStackTrace();
	    }
		
	}
	
}
