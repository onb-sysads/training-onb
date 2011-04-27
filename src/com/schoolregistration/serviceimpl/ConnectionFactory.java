package com.schoolregistration.serviceimpl;
import java.sql.*;

public class ConnectionFactory {
		
	//Properties
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "StudentRegistration";
	private String driver = "com.mysql.jdbc.Driver";
	private String username = "root"; 
	private String password = "";
	
	
	private static ConnectionFactory connectionFactory = null;
		
	  private ConnectionFactory() {
		  try {
			  
				Class.forName(driver);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("JDBC Driver Error!");
			}
	  }
	  
	  public Connection getConnection() {
		   Connection conn = null;
		   try {
			conn = DriverManager.getConnection(url+dbName,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return conn;
	  }
	  
	  public static ConnectionFactory getInstance() {
		  if(connectionFactory==null) {
			  return connectionFactory = new ConnectionFactory();
		  }
		  
		  return connectionFactory;
	  }
	  

	  public static void main(String[] args) {
		 ConnectionFactory ms = getInstance();
		 Connection conn = ms.getConnection();
		 
		 if(conn!=null) {
			 System.out.println("Conenction Successful");
		 }
		  try {	
			conn.close();
			System.out.println("Conenction Terminated"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
