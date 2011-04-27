package com.schoolregistration.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.schoolregistration.dao.DataAccessException;
import com.schoolregistration.dao.UserTypeDao;
import com.schoolregistration.serviceimpl.ConnectionFactory;

public class JDBCUserTypeImpl implements UserTypeDao{
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public JDBCUserTypeImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public Set<String> getUserTypes() throws DataAccessException {
		Set<String> userTypes = new HashSet<String>();
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			String stringQuery = "SELECT * from usertype";
			PreparedStatement pstmt = conn.prepareStatement(stringQuery);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userTypes.add(rs.getString("usertype"));
			}
		} catch (SQLException e) {
			//log
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return userTypes;
	}
	
	@Override
	public int getUserTypeIdByName(String name) throws DataAccessException {
		int id = 0;
		try {
			Connection conn = getConnection();
			String stringQuery = "SELECT * from usertype";
			pstmt = conn.prepareStatement(stringQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String userTypeName = rs.getString("usertype");
				id = rs.getInt("usertypeid");
				if(name.equals(userTypeName)) {
					return id;
				}
			}
			
		} catch (SQLException e) {
			//log
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return id;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws DataAccessException {
		
		JDBCUserTypeImpl u = new JDBCUserTypeImpl();
		Set<String> t = u.getUserTypes();
		for(String x : t) {
			System.out.println(x);
		}
		
		
		
		System.out.println(u.getUserTypeIdByName("student"));
	}

	

}
