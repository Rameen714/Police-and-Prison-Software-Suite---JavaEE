
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Police System LogIn</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css" />
</head>
<body>
<div class="container">
	<div class="brand-logo"></div>
	<div class="brand-title">LogIn</div>
	<div class="inputs">
		<form action ="login" method="post">
			<table>
				<tr><td></td> <td>ID:</td></tr>
				<tr><td></td> <td><input type="text" name="Name"></td></tr>
				<tr><td></td> <td>Password:</td></tr>
				<tr><td></td> <td><input type="password" name="Password"></td></tr>
				<tr><td></td> <td><input type="submit" value="LogIn" class = "button"></td></tr>
			</table>
		</form>
	<!-- <div class="alert">
	  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
	  Warning! Incorrect Password
	</div> -->
	</div>
</div>
</body>
</html>