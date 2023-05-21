package next.Police.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AddPoliceOfficer_Servlet
 */
@WebServlet("/AddPoliceOfficer")
public class AddPoliceOfficer_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPoliceOfficer_Servlet() {
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
		String Name = request.getParameter("Name");
		String ID	= request.getParameter("ID");
		String Password = request.getParameter("Password");
		String Rank = request.getParameter("Rank");
		
		if(Name.isEmpty() == true || ID.isEmpty() == true || Password.isEmpty() == true)
			response.sendRedirect("AddPoliceOfficer.jsp");
		else
		{
			SeniorPoliceOfficer SPO = new SeniorPoliceOfficer();
			boolean added = false;
			try 
			{
				added = SPO.addPoliceOff(Name, ID, Password,Rank);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(added == true)
				response.sendRedirect("Success.jsp");
			else 
				response.sendRedirect("AddPoliceOfficer.jsp");
		}
		//doGet(request, response);
	}

}
