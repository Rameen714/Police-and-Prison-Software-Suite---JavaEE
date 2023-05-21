package next.Cell.bean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.JuniorPoliceOfficer;
import next.Prisoner.bean.Prisoner;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Cell_Servlet
 */
@WebServlet("/CellRelease")
public class Cell_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cell_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
	     try (PrintWriter out = response.getWriter()) {
	       out.println("<!DOCTYPE html>");
	       out.println("<html>");
	       out.println("<head>");
	       out.println("<title>Prisoners LiST</title>");
	       out.println("</head>");
	       out.println("<body>");
	  
	       ArrayList<Prisoner> std = new ArrayList<Prisoner>();    
	       JuniorPoliceOfficer NEW = new JuniorPoliceOfficer();
	       NEW.displayListOfPrisoners(std);
	  
	       // Setting the attribute of the request object
	       request.setAttribute("data", std);
	  
	       // Creating a RequestDispatcher object to dispatch
	       RequestDispatcher rd = request.getRequestDispatcher("DisplayPrisoners.jsp");
	  
	       // The request will be forwarded to the resource 
	       rd.forward(request, response);
         out.println("</body>");
         out.println("</html>");
	        } 
	     //catch (SQLException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
		//	}
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    @Override
	    public String getServletInfo()
	    {
	        return "Short description";
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String CNIC = request.getParameter("ID");
		Cell newCell = new Cell();
		boolean isReleased = false;
		try 
		{
			isReleased = newCell.releasePrisoner(CNIC); // need to add message here for successful/unsuccesful operation
			doGet(request, response);
		} 
		catch (Exception g) 
		{
			g.printStackTrace();
		}
	}

}
