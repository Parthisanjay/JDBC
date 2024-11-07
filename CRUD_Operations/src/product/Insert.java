package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) {
		try {
			//1.load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establish connection()
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db","root", "root");
			
			//3.Create Statement
			Statement s=c.createStatement();
			
			//4.Execute Query
		 s.executeUpdate("insert into product values(1,'pendrive','sandisk',1000,2,9.8,'black')");
		 s.executeUpdate("insert into product values(4,'laptop','asus',50000,1,9.9,'silver')");
		 s.executeUpdate("insert into product values(5,'keyboard','logitech',1200,1,9.5,'black')");
		 s.executeUpdate("insert into product values(3,'mouse','logitech',800,2,9.7,'grey')");
		 s.executeUpdate("insert into product values(2,'speaker','creative',5000,2,9.0,'blackgrey')");
		  
		 System.out.println("Data Inserted");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
