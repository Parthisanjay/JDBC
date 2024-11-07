package com;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public class Load_or_Register {
	public static void main(String[] args) {
		try {
			//1st way
//			Driver d=new com.mysql.cj.jdbc.Driver();
//			DriverManager.registerDriver(d);
			//2nd way
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
