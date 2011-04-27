package com.schoolregistration.serviceimpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.schoolregistration.dao.DataAccessException;
import com.schoolregistration.dao.impl.JDBCUserTypeImpl;




public class Authentication extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PreparedStatement ptmt = null;
	private ResultSet resultSet = null; 
	public final static String SELECTSQL = "SELECT * from useraccount where username= ? AND  usertypeid= ?";
       
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnectionFactory cm =  com.schoolregistration.serviceimpl.ConnectionFactory.getInstance();
		
		Connection conn = cm.getConnection();
		
		//Successful Connection
		if(conn!=null) {
			
			String usernameInput = request.getParameter("username");
			
			String passwordInput = request.getParameter("password");
			
			String userTypeInput = request.getParameter("usertype");
			JDBCUserTypeImpl userTypeDAO = new JDBCUserTypeImpl();
			int userTypeID = 1;
			try {
				userTypeID = userTypeDAO.getUserTypeIdByName(userTypeInput);
			} catch (DataAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				try {
					
					ptmt = conn.prepareStatement(SELECTSQL);
					ptmt.setString(1, usernameInput.toString());
					ptmt.setInt(2, userTypeID);
					
					resultSet = ptmt.executeQuery();
					
						boolean resultSetHasNoResults = true;
						
						while(resultSet.next()) {
							
							resultSetHasNoResults = false;
							String dataUsername = resultSet.getString("username");
							String dataPassword = resultSet.getString("password");
							int dataUsertype = resultSet.getInt("usertypeid");
							int userId = resultSet.getInt("userid");
							
							if(usernameInput.equals(dataUsername)) {
								
								if(passwordInput.equals(dataPassword)) {
									
								    switch(dataUsertype) {
									    case 1: {
									    	validStudentRedirection(request,response, usernameInput, userId);
									    }
									    case 2: {
									    }
									    default:
								    }
								}
								else {
									invalidPasswordRedirection(request,
											response);
								}	
								
							}
							else {
								invalidUsernameAndPasswordRedirection(request,
									response);
							}
						}
						if(resultSetHasNoResults) {
						invalidUsernameAndPasswordRedirection(request,
								response);
						}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
		            closeResources(conn, ptmt, resultSet);
				}
				
			}
			else {
				try {
					throw new SQLException();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	private void invalidPasswordRedirection(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Status","Wrong password!!!");
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
	}

	private void validStudentRedirection(HttpServletRequest request,
			HttpServletResponse response, String usernameInput, int userid)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("Username",usernameInput);
		session.setAttribute("userid",userid);
		RequestDispatcher view = request.getRequestDispatcher("welcomeuser.jsp");
		view.forward(request, response);
	}

	private void invalidUsernameAndPasswordRedirection(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("Status","Invalid username or password!!!");

		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		
		view.forward(request, response);
		
	}

	private void closeResources(Connection conn, PreparedStatement ptmt,
			ResultSet resultSet) {
		try {
		    if (resultSet != null)
		            resultSet.close();
		    if (ptmt != null)
		            ptmt.close();
		    if (conn != null)
		            conn.close();
		} catch (SQLException e) {
		        e.printStackTrace();
		} catch (Exception e) {
		        e.printStackTrace();
		}
	}
	

	

}

