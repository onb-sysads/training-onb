<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
					
		</div>
		
		<div class="body">
			<div id="loginform">
				<form method="POST" action="UserAuthentication.do">
						<p id="loginformtitle"> Log In</p>
						<hr id="loginformline"></hr>
						<p id="loginforminfo"> Welcome! Please Enter your username and password.</p>
						
						<table  align="center" id="loginTable">
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
										out.println("<p id=\"status\">" + stat + "</p>");
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