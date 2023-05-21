<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Police System Patrol Form</title>
</head>
<body>
<div align ="center">
<h1>~Police and Prison Software Suite~</h1>
<p> ~Patrol Form~ </p>
<form action ="Patrol" method="post">
<table>
<tr><td>Enter Junior Police Officer ID: </td><td><input type="text" name="ID"></td></tr>
<br>
<tr><td><input type="submit" name="submitJPOID" value="Submit"></td><tr>
<td></td>
<br>
<tr><td><input type="button" onclick="window.location.href = 'http://localhost:8080/Team2_Login/DisplayAllPatrols.jsp';"  value="View Schedule"></td></tr>
</table>
</form>
</div>
</body>
</html>