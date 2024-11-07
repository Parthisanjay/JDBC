package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteTest {
	static Connection c;
	public static void main(String[] args) {
		try {
			//1.load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establish connection
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root", "root");
			
			//3.Create Statement
			Statement s=c.createStatement();
			
			//4.ExecuteQuery(ResultSet is an Interface,and execute query will create an implementation class obj(ResultSetImpl)for Resultset)
			
			//execute() is present in statement its returntype is boolean
			//it returns false when data is from Java to Database
			//it returns true when data is from Database to Java
			//select is the only way to fetch data from database
			
			boolean b=s.execute("select * from moviedt");
//			boolean b=s.execute("insert into moviedt values('Thuppaki','vijay','kajal','harris','ARM','800')");
			System.out.println("Database result: "+b);
			System.out.println();
			
			//If execute() returns true we need to fetch data from the result table
			//Resultset is the only way to fetch data from the result table so we need to create obj for the Resultsetimpl
			//getResult() is present in Statement it is used to create obj of ResultSetImpl for current result table
			if(b) {
				ResultSet r=s.getResultSet();
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
			else {
				System.out.println("Data Notfound");
			}
			System.out.println("Second Execution");
			boolean b1=s.execute("select * from moviedt where hero='vijay'");
			ResultSet rs=s.getResultSet();
			System.out.println(rs);
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getDouble(6));
				System.out.println(rs.getInt("collection"));//(its a overloaded method with string formal arg)
				System.out.println("-----------------------");
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
