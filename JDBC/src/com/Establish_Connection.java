package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Establish_Connection {
     public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection  c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
			
			System.out.println(c);
		
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
