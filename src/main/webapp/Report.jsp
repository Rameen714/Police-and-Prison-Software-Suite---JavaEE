<%@page import="next.Report.bean.Report"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Report</title>
  </head>
  <body>
      <h1 align="center"><font><strong>Weekly Report</strong></font></h1>
      <table width="500" align="center" cellpadding="10" cellspacing="10" border="1">
         <tr bgcolor="#A52A2A">
          <th><b>Total Cases</b></th>
          <th><b>Cases reported in Last week</b></th>
          <th><b>Prisoners caught in last week</b></th>
         </tr>
        <%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "StudentServlet.java"
        --%> 
        <%ArrayList<Report> std = 
            (ArrayList<Report>)request.getAttribute("data");
        for(Report s:std){%>
        <%-- Arranging data in tabular form
        --%>
            <tr bgcolor="#DEB887">
                <td><%=s.getTotalCrimes()%></td>
                <td><%=s.getNoOfUniqueCases()%></td>
                <td><%=s.getNoOfNewPrisoners()%></td>
            </tr>
            <%}%>
        </table> 
    </body>
</html>