package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.ConnectionFactory;

public class JDBCUserTypeDAO {
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public JDBCUserTypeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public int getUserTypeIdByName(String name) {
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
	
	public static void main(String[] args) {
		
		JDBCUserTypeDAO u = new JDBCUserTypeDAO();
		
		System.out.println(u.getUserTypeIdByName("student"));
	}
	

}
