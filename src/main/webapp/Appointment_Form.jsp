<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment</title>
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
          <div class="app-contact">Appointment Form</div>
        </div>
        <div class="screen-body-item">
          <div class="app-form">
          	<form action ="Appointment" method="post">
				<table>
					<tr>
					<td></td><td><input type="text" class="app-form-control" placeholder="Name"  name="Name"></td></tr>
					<tr>
					<td> </td><td><input type="text" class="app-form-control" placeholder="CNIC (12345-1234567-1)"name="CNIC"></td></tr>
					<tr>
					<td> </td><td><input type="text" class="app-form-control" placeholder="Appoitment with" name="WName"></td></tr>
					<tr><td></td><td><input class="app-form-control" type="date" name="Date"></td></tr>
					<tr><td></td><td><input class="app-form-control" type="time" name="Time"></td></tr>
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