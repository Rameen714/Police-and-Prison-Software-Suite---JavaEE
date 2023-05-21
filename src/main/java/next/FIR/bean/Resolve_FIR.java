package next.FIR.bean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.SeniorPoliceOfficer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class Resolve_FIR
 */
@WebServlet("/Resolve")
public class Resolve_FIR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resolve_FIR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
	     try (PrintWriter out = response.getWriter()) {
	       out.println("<!DOCTYPE html>");
	       out.println("<html>");
	       out.println("<head>");
	       out.println("<title>FIR LIST</title>");
	       out.println("</head>");
	       out.println("<body>");
	  
	       ArrayList<FIR> std = new ArrayList<FIR>();
	       SeniorPoliceOfficer NEW = new SeniorPoliceOfficer();
	       NEW.DisplayListOfFIR(std);
	  
	       // Setting the attribute of the request object
	       request.setAttribute("data", std);
	  
	       // Creating a RequestDispatcher object to dispatch
	       RequestDispatcher rd = request.getRequestDispatcher("Firlist.jsp");
	  
	       // The request will be forwarded to the resource 
	       rd.forward(request, response);
          out.println("</body>");
          out.println("</html>");
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    @Override
	    public String getServletInfo()
	    {
	        return "Short description";
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("ID");
		SeniorPoliceOfficer spo= new SeniorPoliceOfficer();
		try 
		{
			spo.ResolveFIR(Id);
			System.out.println(Id);
			doGet(request, response);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
