package com.mysql;

import java.io.IOException;
import java.io.PrintWriter;
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




public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ConnectionFactory cm =  com.mysql.ConnectionFactory.getInstance();
		
		Connection conn = cm.getConnection();
		
		if(conn!=null) {
			
			PreparedStatement ptmt = null;
			ResultSet resultSet = null;
			
			String usernameInput = request.getParameter("username");
			String passwordInput = request.getParameter("password");
		
				try {
					
					String queryStringUserName = "SELECT * from useraccount where username='" + usernameInput + "'";
					
					ptmt = conn.prepareStatement(queryStringUserName);
					
					resultSet = ptmt.executeQuery();
					
					boolean validUsername = false;
					
						while(resultSet.next()) {
							
							String dataUsername = resultSet.getString("username");
							String dataPassword = resultSet.getString("password");
							String dataUsertype = resultSet.getString("usertypeid");
							
							if(usernameInput.equals(dataUsername)) {
								if(passwordInput.equals(dataPassword)) {
									//Create Session
									validUsername=true;
								    request.setAttribute("Status","Correct Username and Password!");
								    
								    // TODO Make a session when user and pass is correct
								    
								    if("1".equals(dataUsertype)) {
								    	// admin
								    }
								    else if("2".equals(dataUsertype)) {
								    	
								    	HttpSession session = request.getSession();
								    	session.setAttribute("Username",usernameInput);
								    	RequestDispatcher view = request.getRequestDispatcher("welcomeuser.jsp");
										
										view.forward(request, response);
								    	
								    }
									
								}
								else {
									
									validUsername=true;
									request.setAttribute("Status","Wrong password!!!");
									
									RequestDispatcher view = request.getRequestDispatcher("login.jsp");
									
									view.forward(request, response);
									
								}	
								
							}
							
						}
						if(!validUsername) {
							
							request.setAttribute("Status","Wrong username or password!!!");
						
							RequestDispatcher view = request.getRequestDispatcher("login.jsp");
							
							view.forward(request, response);
						}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
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
			else {
				
			System.out.println("No Connection");
			
			}
		

		 
		
	}

}
