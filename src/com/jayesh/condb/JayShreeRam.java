package com.jayesh.condb;
import java.sql.*;
public class JayShreeRam {
	
	static java.sql.Connection con=null;;
	public static Connection connect() 
	{
		
		if(con==null) 
		{	
			try 
			{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/imp_db","root","");
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong..");
				e.printStackTrace();
			}

		}
		return (Connection) con;
	}
}