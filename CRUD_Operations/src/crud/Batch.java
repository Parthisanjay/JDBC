package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Batch {
	static Connection c;
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the number of rows to add");
		int count=s.nextInt();
		
		try {
			//1.load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establish connection
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root", "root");
			
			//3.Create Statement
			//Statement s=c.createStatement();
			
			//4.prepare statement
			PreparedStatement p=c.prepareStatement("insert into moviedt values(?,?,?,?,?,?)");
			
			//5.Execute Query
			for(int i=1;i<=count;i++) {
				System.out.println("Enter movie name");
				String movie=s.next();
				System.out.println("Enter movie hero");
				String hero=s.next();
				System.out.println("Enter movie heroine");
				String heroine=s.next();
				System.out.println("Enter movie musicdir");
				String musicdir=s.next();
				System.out.println("Enter movie director");
				String director=s.next();
				System.out.println("Enter collection");
				double collection=s.nextDouble();
				p.setString(1,movie);
				p.setString(2,hero);
				p.setString(3,heroine);
				p.setString(4,musicdir);
				p.setString(5,director);
				p.setDouble(6,collection);
				
				//it will add the queries data into a temporary space called batch 
				p.addBatch();
			}
			
			
		 // int affected=s.executeUpdate("update moviedt set collection=2000,music_dir='Anirudh' where movie='leo'");
//			p.executeUpdate();
			
			//Once all the query datas are added to batch,executeBatch will execute entire batch
			p.executeBatch();
		  
		  System.out.println("Data Updated Successfully");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				System.out.println(count+" Rows are affected");
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
