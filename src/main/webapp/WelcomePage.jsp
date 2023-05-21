<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PPSS Welcome Page</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css" />
</head>
<body>
<div align ="center" class = "container">
<div class="brand-logo"></div>
<div class="brand-title">Police and Prison Software Suite</div>
<div class="brand-title">~Welcome~</div>
<p>Kindly Specify your User Type to Proceed Furthur</p> 
<form action ="" method="post">
<table>
<tr><td><input type="button" class="button" onclick="window.location.href = 'http://localhost:8080/Team2_Login/login.jsp';"  value = "  Police Officer  "></td></tr>
<tr><td><input type="button" class="button" onclick="window.location.href = 'http://localhost:8080/Team2_Login/CitizenMenu.jsp';"  value = "Citizen"></td></tr>
</table>
</form>
</div>
</body>
</html>