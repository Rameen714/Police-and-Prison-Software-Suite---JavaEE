<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Police Menu</title>
<link rel="stylesheet" type="text/css" href="CSS/Menu.css" />
</head>
<body>
<div class="container">
<div class="brand-logo"></div>
<div class="brand-title">~SPO MENU~ </div>
<!-- <form action =" " method="">  -->
<table>
<tr>
	<td><input type="button" class ='one' onclick="window.location.href = 'http://localhost:8080/Team2_Login/AddPoliceOfficer.jsp';"  value ="Add Officer"></td>
	<td><input type="button" class ='two' onclick="window.location.href = 'http://localhost:8080/Team2_Login/EditPoliceOfficer.jsp';"  value ="Edit Officer"></td>
	<td><input type="button" class='three' onclick="window.location.href = 'http://localhost:8080/Team2_Login/SPO_Patrol_Form.jsp';"  value ="View Patrols"></td>
</tr>

<tr>
	<td><input type="button" class='four' onclick="window.location.href = 'http://localhost:8080/Team2_Login/AddPrisoner.jsp';"  value ="Add Prisoner"></td>
	<td><input type="button" class='five' onclick="window.location.href = 'http://localhost:8080/Team2_Login/DeletePoliceOfficer.jsp';"  value ="Delete Officer"></td>
	<td><input type="button" class ='one'onclick="window.location.href = 'http://localhost:8080/Team2_Login/AssignPatrols.jsp';"  value ="Assign Patrols"></td>
</tr>

<tr>
	<td><input type="button" class ='two' onclick="window.location.href = 'http://localhost:8080/Team2_Login/Appoint_PO_FIR.jsp';"  value ="Appoint Officer"></td>
	<td>
		<form action ="Report" method="post">	
			<input type="submit" class='three' value ="Generate Report">
		</form>
	</td>
	<td>
		<form action ="CellRelease" method="get">
			<input type="submit" class='four'  value ="Display Prisoner List">
		</form>
	</td> 
</tr>

<tr>
	<td><input type="button" class='five' onclick="window.location.href = 'http://localhost:8080/Team2_Login/PoliceOfficers.jsp';"  value ="View All Officers"></td>
	<td><input type="button" class ='one' onclick="window.location.href = 'http://localhost:8080/Team2_Login/SPO_AssignResource.jsp';"  value ="Assign Resources"></td>
	<td>
		<form action ="ResolveComplaint" method="get">
			<input type="submit" class='two' value= "Manage Complaints">
		</form>
	</td>
</tr>

<tr>
	<td>
		<form action ="Resolve" method="get"> 
			<input type = "submit" class='three' value= "View FIRs List">
		</form>
	</td>
	<td><input type="button" class='four' onclick="window.location.href = 'http://localhost:8080/Team2_Login/AddResource.jsp';"  value ="Add Resources"></td>
	<td><input type="button" class='five' onclick="window.location.href = 'http://localhost:8080/Team2_Login/DeleteResource.jsp';"  value ="Delete Resources"></td>
	
</tr>
</table>
<!-- </form> -->
</div>
</body>
</html>