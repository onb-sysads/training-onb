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
		
			<div  class="header" align="center">
				<p id="title"> Orange and Bronze University</p>
			</div>
			
			<div class="blank"> <p></p></div>
		
			<div class="body" align="center">
				
				<%
					String sessionStat = (String)request.getAttribute("Userstatus");
					if(sessionStat!=null) {
					out.println("<p align=\"center\"> class=\"status\">" + sessionStat +"asd." + "</p>");
					}
				%>	
				<p id="titlebody"></p>
				<div class="loginimage">
					<img src="http://www.vectorstock.com/assets/preview/76917/orange-vector.jpg"></img>
				</div>
				<div class="loginform">
					<form method="POST" action="UserAuthentication.do">
							<p id="titleb"> Log In</p>
							<hr id="titlebodyline"></hr>
							<p id="titlebinfo"> Welcome! Please Enter your username and password.</p>	
							<table id="loginTable">
								<tr>
									
									<td><strong><font size="2px" face="arial" color=#686868>Username:</font></strong></td>
									<td><input type="text" maxlength="20" name="username"></input></td>
								</tr>
								<tr>
									<td><strong><font size="2px" face="arial" color=#686868>Password:</font></strong></td>
									<td><input type="password" maxlength="20" name="password"></input></td>
								</tr>
								<tr>
									<td>
									</td>
									<td align="right">
										<%
											String stat = (String)request.getAttribute("Status");
											if(stat!=null) {
											out.println("<p class=\"status\">" + stat + "</p>");
											}
										%>
									</td>
								</tr>
								<tr>
									<td></td>
									<td align="right" ><input id="submitButton" type="submit" value="Submit"/></td>
								</tr>
							</table>
					</form>
				</div>
			 </div>
	 
			 <div class="bottom" align="center">
					<a href='http://creativecommons.org/licenses/by-nc-sa/3.0/' rel='license'>
					<img alt='Creative Commons License' src='http://creativecommons.org/images/public/somerights20.png'
				 	style='border-width:0'/></a><br/> <a href='http://creativecommons.org/licenses/by-nc-sa/3.0/' 
				 	rel='license'/></a>
				 	<p id="bottomText">By: <a href="http://blogpowered.blogspot.com">James</a> and Richie :
				 						                                          Copyright 2011		</p>
			 </div>
</body>
</html>