<%@page import="next.Token.bean.Token"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Token</title>
  </head>
  <body>
      <h1 align="center"><font><strong>Your Token Details</strong></font></h1>
      <table width="500" align="center" cellpadding="10" cellspacing="10" border="1">
         <tr bgcolor="#A52A2A">
          <th><b>Token No</b></th>
          <th><b>Generated At</b></th>
          <th><b>For Date</b></th>
         </tr>
        <%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "StudentServlet.java"
        --%> 
        <%ArrayList<Token> std = 
            (ArrayList<Token>)request.getAttribute("data");
        for(Token s:std){%>
        <%-- Arranging data in tabular form
        --%>
            <tr bgcolor="#DEB887">
                <td><%=s.getTokenNo()%></td>
                <td><%=s.getGeneratedAt() %></td>
                <td><%=s.getVisitingDate()%></td>
            </tr>
           
            <%}%>
        </table> 
        <h2 style="color:red ;" align="center"><font><strong> Important! Do not Forget to screenShot your Token </strong></font></h2>
    </body>
</html>