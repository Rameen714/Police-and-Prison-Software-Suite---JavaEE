<%@page import="next.complaint.bean.Complaint" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complaint List</title>
</head>
<body>
<h1 align="center"><font><strong>List Of Complaints</strong></font></h1>
      
	      <table width="500" align="center" cellpadding="5" cellspacing="5" border="1">
	         <tr bgcolor="#A52A2A">
		          <th><b>Complaint ID</b></th>
		          <th><b>Complain</b></th>
		          <th><b>Complainer Name</b></th>
		          <th><b>Complainer CNIC</b></th>
		          <th><b>Status</b></th>
		     </tr>
		    <%ArrayList<Complaint> std = (ArrayList<Complaint>)request.getAttribute("data");
	        for(Complaint s:std)
	        {%>
	            <tr bgcolor="#DEB887">
	                <td><%=s.getID() %></td>
	                <td><%=s.getComplain()%></td>
	                <td><%=s.getComplainer().getName()%></td>
	                <td><%=s.getComplainer().getCNIC()%></td>
	                <td><%=s.isStatus()%></td>
	             	<td>
	               	<form action = "ResolveComplaint" method ="post">
			            <input type="hidden" name="ID" value="<%=s.getID()%>">
			            <input type="submit" name="action" value="Resolve" >
			        </form>
	           		</td>
	            </tr>
	       <%}%>
		 </table> 
     <input type="button" onclick="window.location.href = 'http://localhost:8080/Team2_Login/SPO_Menu.jsp';" value="Back to Menu"> 
</body>
</html>