package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.model.Student;
import com.mysql.ConnectionFactory;
import com.dao.DataAccessException;
import com.dao.StudentDAO;

public class StudentJDBCDAO implements StudentDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public  StudentJDBCDAO() {}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
//	
//	@Override
//	public Set<Student> getAllStudents() throws DataAccessException {
//		
//		Set<Student> setOfStudent = new HashSet<Student>();
//		
//		try {
//			
//			Connection conn = getConnection();
//			String stringQuery = "SELECT * from student";
//			pstmt = conn.prepareStatement(stringQuery);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				setOfStudent.add(new Student(rs.getInt("studentid"),rs.getString("studentfirstname"),rs.getString("studentlastname")
//						,rs.getString("studentaddress"),rs.getString("studentcontact")));
//			}
//			
//			
//		} catch (SQLException e) {
//			//log
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn != null) {
//					conn.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(rs != null) {
//					rs.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return setOfStudent;
//	}

	@Override
	public void addClassToStudent() throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Class> getAvailableClasses() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Class> getEnrolledClasses() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}



	

}
