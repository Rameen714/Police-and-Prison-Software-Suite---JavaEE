<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String id = request.getParameter("userId");
String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
ResultSet rs = null;
%>
<h2 align="center"><font><strong>List Of Patrols</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr></tr>
<tr bgcolor="#A52A2A">
<td><b>ID</b></td>
<td><b>Date</b></td>
<td><b>Start Time Of Patrol</b></td>
<td><b>End Time of Patrol</b></td>
<td><b>Appointee Name</b></td>
<td><b>Appointee ID</b></td>
</tr>
<%

try
(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
{
String sql ="SELECT * FROM dbo.[Patrol]";
PreparedStatement ps;
ps = con.prepareStatement(sql);
rs = ps.executeQuery();

while(rs.next()){
%>
<tr bgcolor="#DEB887">
<td><%=rs.getString("ID") %></td>
<td><%=rs.getString("date") %></td>
<td><%=rs.getString("StartTime") %></td>
<td><%=rs.getString("EndTime") %></td>
<td><%=rs.getString("AppointeeName") %></td>
<td><%=rs.getString("AppointeeID") %></td>
</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>