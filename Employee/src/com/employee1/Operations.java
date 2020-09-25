package com.employee1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Operations {
	static Main_method_Employee ob=new Main_method_Employee();
	static Scanner sc=new Scanner(System.in);
	static String ename, eadd, DOB,DOJ;
	static int eid,exp,res,rowsInserted;;
	static Connection con;
	
	//insertion
	public static int insertion() throws ClassNotFoundException, SQLException {
		
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/test","root","Kishore1142..");
			System.out.println("enter employee name");
			ename=sc.next();
			System.out.println("enter employee address");
			eadd=sc.next();
			System.out.println("enter employee DOB");
			DOB=sc.next();
			System.out.println("enter employee experience");
			exp=sc.nextInt();
			System.out.println("enter employee DOJ");
			DOJ=sc.next();
			
			String query="INSERT INTO employee (ename,eadd,dob,exp,DOJ) VALUES(?, ?, ?,?,?)";
		PreparedStatement statement=con.prepareStatement(query);
		statement.setString(1, ename);
		statement.setString(2, eadd);
		statement.setString(3, DOB);
		statement.setInt(4, exp);
		statement.setString(5, DOJ);
		 rowsInserted=statement.executeUpdate();
		}
		
		catch (SQLException e) 
		{
			   e.printStackTrace();
		 }
		System.out.println(rowsInserted);
		
		
		return rowsInserted;
	}

	
	//display
	public static void display() throws SQLException {
		System.out.println("enter employee id");
		eid=sc.nextInt();
		System.out.println("Displaying Employee details");
		
		String sql="SELECT * FROM employee where empid=?";
		PreparedStatement statement=ob.con.prepareStatement(sql);
		statement.setInt(1, eid);
	
		 ResultSet rs = statement.executeQuery();
		 while(rs.next()){
	   
			 //Retrieve by column name
	         
	         String ename = rs.getString("ename");
	         String eadd = rs.getString("eadd");
	         String DOB  = rs.getString("dob");
	         String DOJ  = rs.getString("DOJ");
	         int exp = rs.getInt("exp");
	         int eid = rs.getInt("empid");

	         //Display values
	         System.out.print("Name: " + ename);
	         System.out.print(", Address: " + eadd);
	         System.out.print(", DOB: " + DOB);
	         System.out.println(", DOJ: " + DOJ);
	         System.out.println("Experience :"+exp);
	         System.out.println("EmpID :"+eid);
	      }
	      rs.close();
	}
//update
	public static void update() throws SQLException {
		System.out.println("Enter Employee ID");
		int eid=sc.nextInt();
		String tempq="SELECT * FROM employee where empid=?";
		PreparedStatement statement=ob.con.prepareStatement(tempq);
		statement.setInt(1, eid);
		ResultSet n=statement.executeQuery();
		boolean b=n.next();
		if(b==false)
		{
			System.out.println("Data not present");
		}
		else
		{
			System.out.println("enter employee name");
			ename=sc.next();
			System.out.println("enter employee address");
			eadd=sc.next();
			System.out.println("enter employee DOB");
			DOB=sc.next();
			System.out.println("enter employee DOJ");
			DOJ=sc.next();
			System.out.println("enter employee experience");
			exp=sc.nextInt();
		String query="UPDATE employee set ename=?,eadd=?,dob=?,exp=?,DOJ=?  WHERE empid=?";
		PreparedStatement statement1=ob.con.prepareStatement(query);
		statement1.setString(1, ename);
		statement1.setString(2, eadd);
		statement1.setString(3, DOB);
		statement1.setInt(4, exp);
		statement1.setString(5, DOJ);
		statement1.setInt(6, eid);
		
		int rowsInserted=statement1.executeUpdate();
		if(rowsInserted>0)
		{
			System.out.println("Updated");
		}
		}
	}
	
	//delete
	public static void delete() throws SQLException {
		System.out.println("enter employee id");
		eid=sc.nextInt();
		System.out.println("Deleting Employee details");
		String sql="DELETE FROM employee WHERE empid=?";
		PreparedStatement statement=ob.con.prepareStatement(sql);
		statement.setInt(1, eid);
	int rowsDeleted=statement.executeUpdate();
	if(rowsDeleted>0)
	{
		System.out.println("Successfully deleted");
	}
	else
		System.out.println("Deletion unsuccessful");
		
	}
	
}
