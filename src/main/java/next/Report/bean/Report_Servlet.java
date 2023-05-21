package next.Report.bean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.SeniorPoliceOfficer;
import next.Token.bean.Token;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class Report_Servlet
 */
@WebServlet("/Report")
public class Report_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Report report=null;
		SeniorPoliceOfficer New = new SeniorPoliceOfficer();
		try 
		{
			report = New.generateReport();
			
			response.setContentType("text/html;charset=UTF-8");
		     try (PrintWriter out = response.getWriter()) {
		       out.println("<!DOCTYPE html>");
		       out.println("<html>");
		       out.println("<head>");
		       out.println("<title>Report</title>");
		       out.println("</head>");
		       out.println("<body>");
		
		       ArrayList<Report> std = new ArrayList<Report>();
		       std.add(report);      
		       
		       request.setAttribute("data", std);
		       RequestDispatcher rd = request.getRequestDispatcher("Report.jsp");
		          rd.forward(request, response);
		            out.println("</body>");
		            out.println("</html>");
		        } 
		}
		     catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
