<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizen Menu</title>
<link rel="stylesheet" type="text/css" href="CSS/Menu.css" />
</head>
<body>
<div class="containerss">
<div class="brand-logo"></div>
<div class="brand-title">~Citizen Menu~</div>
<form action ="Token" method="post"> 
<table>
<tr><td><input type="button" class='one' onclick="window.location.href = 'http://localhost:8080/Team2_Login/FIR_Form.jsp';"  value ="File FIR"></td></tr>
<tr><td><input type="button" class='two' onclick="window.location.href = 'http://localhost:8080/Team2_Login/Complaint_Form.jsp';"  value ="File Complaint"></td></tr>
<tr><td><input type="button" class='three' onclick="window.location.href = 'http://localhost:8080/Team2_Login/Appointment_Form.jsp';"  value ="Set Appointment"></td></tr>
<tr><td><input type="submit" class ='four'  value ="Get Visiting Token"></td></tr>
</table>
</form>
</div>
</body>
</html>