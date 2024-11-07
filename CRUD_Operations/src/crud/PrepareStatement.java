package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatement {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter Movie name");
		String movie=s.next();
		System.out.println("Enter Movie hero");
		String hero=s.next();
		System.out.println("Enter Movie heroine");
		String heroine=s.next();
		System.out.println("Enter Movie musicdir");
		String musicdir=s.next();
		System.out.println("Enter Movie director name");
		String director=s.next();
		System.out.println("Enter Movie collection");
		double collection=s.nextDouble();
		
		try {
			//1.load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establish connection
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root", "root");
			
			//3.Create Statement
		//	Statement s=c.createStatement();
			
			//4.prepare statement(for Dynamic query)
			PreparedStatement p=c.prepareStatement("insert into moviedt values(?,?,?,?,?,?)");
			
			//5.Execute Query
		   p.setString(2,movie);
		   p.setString(1,hero);
		   p.setString(3,heroine);
		   p.setString(4,musicdir);
		   p.setString(5,director);
		   p.setDouble(6,collection);
		   
		 int affected = p.executeUpdate();
		  System.out.println(affected+" Data saved successfully");
		  
		}
		catch(ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}
	}
}
