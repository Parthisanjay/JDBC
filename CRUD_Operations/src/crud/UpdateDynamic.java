package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDynamic {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter movie name");
		String movie=s.next();
		System.out.println("Enter movie hero");
		String hero=s.next();
		System.out.println("Enter movie musicdir");
		String musicdir=s.next();
		System.out.println("Enter collection");
		double collection=s.nextDouble();
		
		try {
			//1.load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establish connection
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root", "root");
			
			//3.Create Statement
			//Statement s=c.createStatement();
			
			//4.prepare statement
			PreparedStatement p=c.prepareStatement("update moviedt set music_dir=?,movie=?,hero=? where collection=?");
			
			//5.Execute Query
			p.setString(1,musicdir);
			p.setString(2,movie);
			p.setString(3,hero);
			p.setDouble(4,collection);
			
		 // int affected=s.executeUpdate("update moviedt set collection=2000,music_dir='Anirudh' where movie='leo'");
			p.executeUpdate();
		  
		  System.out.println("Data Updated Successfully");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
