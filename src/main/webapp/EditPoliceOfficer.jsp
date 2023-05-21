<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Police Officer</title>
<link rel="stylesheet" type="text/css" href="CSS/Forms.css" />
</head>
<body>
<div class="background">
  <div class="container">
    <div class="screen">
      <div class="screen-header">
        <div class="screen-header-left">
          <div class="screen-header-button close"></div>
          <div class="screen-header-button maximize"></div>
          <div class="screen-header-button minimize"></div>
        </div>
        <div class="screen-header-right">
          <div class="screen-header-ellipsis"></div>
          <div class="screen-header-ellipsis"></div>
          <div class="screen-header-ellipsis"></div>
        </div>
      </div>
      <div class="screen-body">
        <div class="screen-body-item left">
            <div class="brand-logo"></div>
          <div class="app-contact">Edit Police Officer Form</div>
        </div>
        <div class="screen-body-item">
          <div class="app-form">
          	<form action ="EditPoliceOfficer" method="post">
				<table>
					<tr>
					<td></td><td><input type="text" class="app-form-control" placeholder="12345-1234567-1"  name="ID"></td></tr>
					<tr>
					<td> </td><td></tr>
					<tr>
					<td> </td><td>
						Click on what you want to edit:
						<select  class="app-form-control"  name="item">
								<option value = "Name">Name</option>
								<option value = "ID">ID</option>
								<option value = "Password">Password</option>
								
						</select></td></tr>
					<tr>
					<td></td><td><input type="text"   class="app-form-control" name="choice" placeholder="add/select a value" ></td></tr>
					<tr>
						<td></td>
						<td>
							<div class="app-form-group buttons">
								<input type="submit" class="app-form-button" value="Submit">
				             </div>
						</td>
					</tr>
				</table>
			</form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>