<%@page import="com.schoolregistration.serviceimpl.StudentAdministrationImpl"%>
<%@page import="com.com.schoolregistration.services.StudentAdministration"%>
<%@page import="com.schoolregistration.dao.impl.JDBCStudentImpl"%>
<%@page import="com.schoolregistration.domain.Student;" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

</head>
	<body>
		<br/>	
			<div class="container">
				<div class="header">
			
					<table align="center" id="headercontainer">
						<tr>
							<td>
								<img src="http://i283.photobucket.com/albums/kk284/podferio15/globe_red.png"></img>
							</td>
							
							<td>
								<p id="title"> O&B University</p>
							</td>
						</tr>
					</table>
					<!--  Welcome message for user -->
					<%
						String username =(String) session.getAttribute("Username");
						out.print("<p id=\"welcometag\">" + " Welcome " + username + "" + "(<a href=\"logout.jsp\">Logout</a>)</p>");
					%>
					
				</div>
					<div class="nav" align="center">
						<ul id="usernavmenu">
							<li><a href="welcomeuser.jsp">HOME</a></li>
							<li><a href="http://www.google.com">STUDENT ADMINISTRATION</a></li>
							<li><a href="wordpress/travel/">CHORVALU</a></li>
							<li><a href="http://www.wordpress.org">ASSESS TUITION</a></li>
							<li><a href="logout.jsp">LOGOUT</a></li>
						</ul>
					</div>
		
			<div class="body">
				
				<%
						Integer userid = (Integer)session.getAttribute("userid");	
						StudentAdministrationImpl sa = new StudentAdministrationImpl();
						Student stud = sa.getStudent(userid);
						out.print("<p> PROFILE: </p>");
						out.print("<p> ID No.: " + stud.getStudentId() + "</p>");
						out.print("<p> First Name: " + stud.getStudentFirstName() + "</p>");
						out.print("<p> Last Name: " + stud.getStudentLastName() + "</p>");
						out.print("<p> Address: " + stud.getStudentAddress() + "</p>");
						out.print("<p> Contact No: " + stud.getStudentContact() + "</p>");
				%>
				
			</div>
	 
			<div class="footer">
				<a href='http://creativecommons.org/licenses/by-nc-sa/3.0/' rel='license'>
						<img src='Creative Commons License' src='http://creativecommons.org/images/public/somerights20.png'
					 	style='border-width:0'/></img></a><br/> <a href='http://creativecommons.org/licenses/by-nc-sa/3.0/' 
					 	rel='license'/></a>
					 	<p id="footertext"> O&B Registration System 
					 	By: <a href="http://blogpowered.blogspot.com">James</a>, Richie and Hans.
					 						                                          ©Copyright 2011		</p>
			</div>
	</div>
</body>
</html>