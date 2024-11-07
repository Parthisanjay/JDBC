package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) {
		try {
		   //1.load or register driver(Class is a class,forName is a static method in Class)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		   //2.establish connection(Creates obj for ConnectionImpl subclass(implementation class) of Connection Interface)
		  //DriverManager is a Class and getConnection is a static method in DriverManager
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root", "root");
			
		  //3.Create Statement(Creates obj for StatementImpl subclass(implementation class) of Statement Interface)
		 //Carry static Sql query from Java to database
		 	Statement s=c.createStatement();
			
		//4.Execute Query(executeUpdate abstract method is present in Statement interface but impl method present in StatementImpl class)
		 //executeUpdate(Insert,Update,Delete)
		 //executeQuery(Select)
		  int affected=s.executeUpdate("insert into moviedt values('master','vijay','malavika','ani','lokesh',1000)");
		  
		  System.out.println("Data Inserted");
		  System.out.println(affected);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
