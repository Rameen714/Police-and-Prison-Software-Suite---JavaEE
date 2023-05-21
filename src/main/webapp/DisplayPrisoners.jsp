<%@page import="next.Prisoner.bean.Prisoner"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Prisoners List</title>
  </head>
  <body>
      <h1 align="center"><font><strong>List Of Prisoners</strong></font></h1>
      
	      <table width="500" align="center" cellpadding="5" cellspacing="5" border="1">
	         <tr bgcolor="#A52A2A">	
	         	<th><b>Name</b></th>	          
				<th><b>CNIC</b></th>
				<th><b>Date Of Entry</b></th>
				<th><b>Date of Release</b></th>
				<th><b>Crime</b></th>
				<th><b>Cell ID</b></th>
				<th><b>Status</b></th>
	         </tr>
	        <%ArrayList<Prisoner> std = (ArrayList<Prisoner>)request.getAttribute("data");
	        for(Prisoner s:std)
	        {%>
	            <tr bgcolor="#DEB887">
	                <td><%=s.getAPrisoner().getName()%></td>
	                <td><%=s.getAPrisoner().getCNIC()%></td>
	                <td><%=s.getDateOfEntry()%></td>
	                <td><%=s.getDateOfRelease()%></td>
	                <td><%=s.getCrime()%></td>
	                <td><%=s.getCellId()%></td>
	                <td><%=s.getStatus()%></td>
	               	<td>
	               	<form action = "CellRelease" method ="post">
			            <input type="hidden" name="ID" value="<%=s.getAPrisoner().getCNIC()%>">
			            <input type="submit" name="action" value="Release" >
			        </form>
	           		</td>
	            </tr>
	            <%}%>
	        </table> 
     <input type="button" onclick="window.location.href = 'http://localhost:8080/Team2_Login/login.jsp';" value="Back to Main Page"> 
    </body>
</html>