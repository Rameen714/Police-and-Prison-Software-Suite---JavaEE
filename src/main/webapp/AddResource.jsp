<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddResource</title>
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
          <div class="app-contact">Add Resource Form</div>
        </div>
        <div class="screen-body-item">
          <div class="app-form">
          	 <form action="AddResource" method=post>
				<table>
					<tr>
						<td>ID:</td>
						<td><input type = "text" name="ID"></td>
					</tr>
				</table>
				<p>Type:		
				<select name="Type">
						<option value = "FireArm">FireArm</option>
						<option value = "Vehicle">Vehicle</option>
				</select>
				</p>
				<table>
					<tr><td></td></tr>
					<tr><td></td></tr>
					<tr>
						<td><input type="submit" value="Submit"></td>
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