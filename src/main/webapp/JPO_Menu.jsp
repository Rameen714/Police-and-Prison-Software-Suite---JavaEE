<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Menu.css" />
</head>
<body>
<div class="containers">
<div class="brand-logo"></div>
<div class="brand-title">~JPO MENU~ </div>
<table>
<tr>
	
	<td>
	<form action ="Patrol" method="post"> 
		<input type="submit" class ='one' name ="JPOViewPatrols" value ="View Patrols">
	</form>
	</td>

	
</tr>
<tr>
	<td><input type="button" class ='two' onclick="window.location.href = 'http://localhost:8080/Team2_Login/AddPrisoner.jsp';"  value ="Add Prisoner"></td>
</tr>
<tr>
	<td>
		<form action ="CellRelease" method="get">
			<input type="submit" class ='three'  value ="Prisoners List">
		</form>
	</td>
</tr>
</table>
</div>
</body>
</html>