package com.schoolregistration.jdbc;

public class JDBCConnection {	
	
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "StudentRegistration";
	private String driver = "com.mysql.jdbc.Driver";
	private String username = "root"; 
	private String password = "";
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
