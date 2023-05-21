<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";




String FIRID  = request.getParameter("FIRID");
String POID  = request.getParameter("POID");

System.out.println("Checking para");
System.out.println(FIRID);
System.out.println(POID);

%>
<h2 align="center"><font><strong>Officer Appointed</strong></font></h2>

<%
System.out.println("display hone wali a");
System.out.println("DisplayAllPatrols ka JSP 1");

try
(Connection con = DriverManager.getConnection(dbUrl);Statement stmt = con.createStatement();) 
{
	System.out.println("update se pehle");
	
String sql ="UPDATE FIR SET AppointedOfficerID = ? where ID = ?";
System.out.println("update hua");
PreparedStatement ps;
ps = con.prepareStatement(sql);
ps.setString(1, POID);
ps.setString(2, FIRID);

int i =ps.executeUpdate();
/* ResultSet rs = ps.executeQuery(); */


System.out.println("execute hua");
%>
<p> Input Successful</p>

<% 

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>