package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		try {
			//1.load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establish connection
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root", "root");
			
			//3.Create Statement
			Statement s=c.createStatement();
			
			//4.Execute Query
		  int affected=s.executeUpdate("update moviedt set collection=2000,music_dir='Anirudh' where movie='leo'");
		  
		  System.out.println("Data Updated");
		  System.out.println(affected);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
