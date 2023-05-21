<%@page import="next.FIR.bean.FIR"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>FIR List</title>
  </head>
  <body>
      <h1 align="center"><font><strong>List Of FIRs</strong></font></h1>
      
	      <table width="500" align="center" cellpadding="5" cellspacing="5" border="1">
	         <tr bgcolor="#A52A2A">
		          <th><b>FIR ID</b></th>
		          <th><b>Reportee Name</b></th>
		          <th><b>Reportee CNIC</b></th>
		          <th><b>Reported Against</b></th>
		          <th><b>Reported Against CNIC</b></th>
		          <th><b>Description</b></th>
		          <th><b>Status</b></th>
		          <th><b>Filed Date</b></th>
		          <th><b>Appointed Officer ID</b></th>
		          <th><b>Assigned Resource ID</b></th>
	         </tr>
	
	        <%ArrayList<FIR> std = (ArrayList<FIR>)request.getAttribute("data");
	        for(FIR s:std)
	        {%>
	            <tr bgcolor="#DEB887">
	                <td><%=s.getID() %></td>
	                <td><%=s.getReportedBy().getName()%></td>
	                <td><%=s.getReportedBy().getCNIC()%></td>
	                <td><%=s.getReportedAgainst().getName()%></td>
	                <td><%=s.getReportedAgainst().getCNIC()%></td>
	                <td><%=s.getFirDescription()%></td>
	                <td><%=s.getStatus()%></td>
	                <td><%=s.getDateofFIR()%></td>
	                <td><%=s.getAppointedOfficer().GetId()%></td>
	                <td><%=s.getResouces().getID()%></td>
	             
	               	<td>
	               	<form action = "Resolve" method ="post">
			            <input type="hidden" name="ID" value="<%=s.getID()%>">
			            <input type="submit" name="action" value="Resolve" >
			        </form>
	           		</td>
	            </tr>
	            <%}%>
	        </table> 
     <input type="button" onclick="window.location.href = 'http://localhost:8080/Team2_Login/loginSuccess.jsp';" value="Back to Menu"> 
    </body>
</html>