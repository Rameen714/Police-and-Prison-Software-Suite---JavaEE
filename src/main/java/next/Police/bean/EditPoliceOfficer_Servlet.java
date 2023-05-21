package next.Police.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class EditPoliceOfficer_Servlet
 */
@WebServlet("/EditPoliceOfficer")
public class EditPoliceOfficer_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPoliceOfficer_Servlet() {
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

		String OfficerID = request.getParameter("ID");		
		String item = request.getParameter("item");
		String choice = request.getParameter("choice");
		
		if(OfficerID.isEmpty() == true || item.isEmpty() == true || choice.isEmpty() == true)
			response.sendRedirect("EditPoliceOfficer.jsp");
		else
		{
			boolean edited = false;
			try
			{
				SeniorPoliceOfficer SPO = new SeniorPoliceOfficer();
				edited = SPO.editPoliceOff(OfficerID,item,choice);
				if (edited == false)
					System.out.println("OOPS_Servlet");
			}
			catch(Exception e) 
			{
				e.printStackTrace();				
			}
			if(edited == true)
				response.sendRedirect("Success.jsp");			
		}
	}

}
