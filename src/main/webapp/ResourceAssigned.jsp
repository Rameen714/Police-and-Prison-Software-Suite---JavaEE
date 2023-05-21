<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
ResultSet rs = null;



String FIRID  = request.getParameter("FIRID");
String ResourceID  = request.getParameter("ResourceID");

System.out.println("Checking para");
System.out.println(FIRID);
System.out.println(ResourceID);

%>
<h2 align="center"><font><strong>Resource Assigned</strong></font></h2>

<%
System.out.println("display hone wali a");
System.out.println("DisplayAllPatrols ka JSP 1");

try
(Connection con = DriverManager.getConnection(dbUrl);Statement stmt = con.createStatement();) 
{
	System.out.println("update se pehle");
String sql ="UPDATE FIR SET ResourceID = ? where ID = ?" ;
System.out.println("update hua");
PreparedStatement ps;
ps = con.prepareStatement(sql);
ps.setString(1, ResourceID);
ps.setString(2, FIRID);

int i =ps.executeUpdate();
%>
<p> Input Successful</p>

<% 

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>