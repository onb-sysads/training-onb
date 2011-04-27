package com.schoolregistration.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.schoolregistration.dao.DataAccessException;
import com.schoolregistration.dao.StudentDao;
import com.schoolregistration.domain.SchoolClass;
import com.schoolregistration.domain.Student;
import com.schoolregistration.serviceimpl.ConnectionFactory;


public class JDBCStudentImpl implements StudentDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public  JDBCStudentImpl() {}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
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
	

	@Override
	public Student getStudent(int studentID) throws DataAccessException {
		// TODO Auto-generated method stub
		Student student = null;
		try{
			Connection conn = getConnection();
			String stringQuery = "SELECT * from student where studentID=" + studentID;
			pstmt = conn.prepareStatement(stringQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				student = new Student(studentID, rs.getString("studentfirstname") , rs.getString("studentlastname")
						, rs.getString("studentaddress"), rs.getString("studentcontact"));
			}
		}
		catch(SQLException e) {
			// throw new ServiceException("",e);
		} finally {
			closeResources();
		}
		return student;
	}

	private void closeResources() {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			//log4j
			e.printStackTrace();
		}
	}



	public static void main(String[] args) throws DataAccessException {
		JDBCStudentImpl s = new JDBCStudentImpl();
		Student st = s.getStudent(1);
		System.out.println(st.toString());
	}

	

}
