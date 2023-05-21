<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String id = request.getParameter("userId");
String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
ResultSet rs = null;
%>
<h2 align="center"><font><strong>List Of Police Officers</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr></tr>
<tr bgcolor="#A52A2A">
<td><b>Name</b></td>
<td><b>CNIC</b></td>
<td><b>Password</b></td>
<td><b>Rank</b></td>
</tr>
<%
try
(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
{
String sql ="SELECT * FROM dbo.[PoliceOfficer] order by Rank desc";
PreparedStatement ps;
ps = con.prepareStatement(sql);
rs = ps.executeQuery();

while(rs.next()){
%>
<tr bgcolor="#DEB887">
<td><%=rs.getString("Name") %></td>
<td><%=rs.getString("ID") %></td>
<td><%=rs.getString("Password") %></td>
<td><%=rs.getString("Rank") %></td>
</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>