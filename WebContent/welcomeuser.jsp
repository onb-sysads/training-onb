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
				
				<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
				Duis malesuada, libero non iaculis fermentum, justo tellus 
				facilisis metus, eget ullamcorper erat purus id neque. 
				Nullam quis velit nulla. Ut placerat velit et leo viverra 
				facilisis. Aenean pharetra urna quis nibh mollis rhoncus. 
				Duis lobortis tortor at dolor tempor nec elementum leo ullamcorper. 
				Donec et risus ut tellus tempus congue eget mollis leo. 
				Suspendisse dictum dolor id justo lacinia quis ornare leo ullamcorper. 
				Duis vehicula, arcu id venenatis dapibus, nisl sem porttitor purus, eget bibendum leo nunc et erat. 
				Fusce rhoncus eleifend suscipit. Integer nec felis vitae erat varius tincidunt. 
				Praesent mollis rutrum erat, sit amet porta velit ultrices sed. 
				Mauris et neque nulla, et feugiat lorem. 
				Praesent congue porta metus, sit amet pharetra dui gravida sed. 
				Pellentesque accumsan nulla sed ligula tempor facilisis. 
				Etiam a massa diam. Suspendisse hendrerit aliquam tincidunt. 
				Duis laoreet, mi quis imperdiet pulvinar, justo dui faucibus lectus, eget iaculis enim nibh id neque. Nulla dignissim faucibus quam, id scelerisque ipsum tristique vitae. Ut urna enim, varius eu semper non, tincidunt ultrices ligula. Maecenas condimentum convallis condimentum.

				Aenean sed nunc sit amet sem dignissim placerat. Nulla laoreet, ipsum sit amet sagittis mattis, massa nunc ullamcorper nibh, sed ornare odio tortor id mauris. Pellentesque et enim lacus. Nullam massa dolor, adipiscing eu fringilla vestibulum, congue vel dolor. Ut et sapien augue, vitae varius enim. Cras facilisis lectus quis leo tempus malesuada. Morbi tincidunt condimentum mi at sodales. Vivamus ut ante odio. Integer vel diam ligula. Integer nec lectus purus. Mauris semper tristique enim, nec adipiscing quam ornare et. Cras orci nulla, pellentesque a hendrerit vitae, tempor a sem. Etiam eget odio ac augue scelerisque hendrerit nec non sem. Nam lobortis, sem id porta scelerisque, turpis odio venenatis nunc, sed interdum purus tellus id sem.

				
				</p>
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