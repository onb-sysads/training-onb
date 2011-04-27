package com.schoolregistration.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;


import com.schoolregistration.dao.DataAccessException;
import com.schoolregistration.dao.StudentDao;
import com.schoolregistration.domain.SchoolClass;
import com.schoolregistration.domain.Student;
import com.schoolregistration.jdbc.JDBCConnection;

public class JDBCStudentImpl implements StudentDao{
	
	JDBCConnection jdbcConnection = new JDBCConnection();
	Connection conn = null;
	ResultSet rs = null;


	@Override
	public Student getStudent(int studentId) throws DataAccessException {
		
		Student s = null;
		try {
			Class.forName(jdbcConnection.getDriver());
			Connection conn = DriverManager.getConnection(
                    jdbcConnection.getUrl()+jdbcConnection.getDbName(), jdbcConnection.getUsername(), jdbcConnection.getPassword());
			
			String sqlStatement = "SELECT * FROM student where studentid = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
			preparedStatement.setInt(1, studentId);
			rs = preparedStatement.executeQuery();
			
			String firstName;
			String lastName;
			String address;
			String contact;
			while(rs.next())
			{
				firstName = rs.getString("studentfirstname");
				lastName = rs.getString("studentlastname");
				address = rs.getString("studentaddress");
				contact = rs.getString("studentcontact");
				s = new Student(studentId,firstName,lastName,address,contact);
			}	
			
		}
		catch(ClassNotFoundException e)
		{
			throw new DataAccessException("JDBC Driver was not found",e);
		}
		catch(SQLException e)
		{
			throw new DataAccessException("SQL connection error",e);
		}

		return s;
		

	}

	@Override
	public void addClassToStudent() throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<SchoolClass> getEnrolledClass() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String [] args) throws DataAccessException
	{
		JDBCStudentImpl jdbcStudentImpl = new JDBCStudentImpl();
		System.out.println(jdbcStudentImpl.getStudent(1));
	}

}
