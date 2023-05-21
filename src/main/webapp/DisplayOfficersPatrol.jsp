<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";

ResultSet rs = null;
String id = request.getParameter("id");
System.out.println(id);
System.out.println("BLA bLA");
System.out.println(id);


%>
<h2 align="center"><font><strong>List Of Patrols</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr></tr>
<tr bgcolor="#A52A2A">
<td><b>ID</b></td>
<td><b>DateC</b></td>
<td><b>Start Time</b></td>
<td><b>End  Time</b></td>
<td><b>Appointee Name</b></td>
<td><b>Appointee ID</b></td>
</tr>
<%

try
(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
{
String sql ="SELECT * FROM dbo.[Patrol] where AppointeeID  = '"+ id + "'";
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