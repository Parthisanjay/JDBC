package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Close {
	static Connection c;
	public static void main(String[] args) {
//		Connection c=null;
		try {
			//1.load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establish connection
			 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root", "root");
			
			//3.Create Statement
			Statement s=c.createStatement();
			
			//4.ExecuteQuery(ResultSet is an Interface,and execute query will create an implementation class obj(ResultSetImpl)for Resultset)
			ResultSet r=s.executeQuery("select * from moviedt");
			System.out.println(r);
			while(r.next()) {
				System.out.println(r.getString(1));
				System.out.println(r.getString(2));
				System.out.println(r.getString(3));
				System.out.println(r.getString(4));
				System.out.println(r.getString(5));
				System.out.println(r.getDouble(6));
				System.out.println(r.getInt("collection"));//(its a overloaded method with string formal arg)
				System.out.println("-----------------------");
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				c.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
