package com.voteitup.DAO;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDAO {
	
	public Connection openconnection()
	{
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {

				final String serverURL="jdbc:mysql://127.5.67.130:3306/voteplus";
				final String ServerUserName="";
				final String serverpass="";	
				Connection con=DriverManager.getConnection(serverURL,ServerUserName,serverpass); 
				
				/*final String url="jdbc:mysql://localhost/Voteitup";
				final String username="root";
				final String password="";
				Connection con=DriverManager.getConnection(url,username,password);
				System.out.print("Connection successful!"); */
				return con;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
