<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Patrols to Junior Police Officer</title>
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
          <div class="app-contact">Assign Patrols Form</div>
        </div>
        <div class="screen-body-item">
          <div class="app-form">
          	<form action ="Complaint" method="post">
				<table>
					<tr>
					<td></td><td><input type="text" class="app-form-control" placeholder="Officer ID"  name="ID"></td></tr>
					<tr>
					<td> </td><td><input type="text" class="app-form-control" placeholder="Officer Name"name="Name"></td>
					</tr>
					<tr>
					<td> </td><td><input type="date" class="app-form-control" placeholder="Date"name="Date"></td>
					</tr>
					<tr>
					<td> </td><td><input type="time" class="app-form-control" placeholder="StartTime"name="StartTime"></td>
					</tr>
					<tr>
					<td> </td><td><input type="time" class="app-form-control" placeholder="EndTime"name="EndTime"></td>
					</tr>
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