package next.Police.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeletePoliceOfficer
 */
@WebServlet("/DeletePoliceOfficer")
public class DeletePoliceOfficer_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePoliceOfficer_Servlet() {
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
		
		if(Name.isEmpty() == true || ID.isEmpty() == true)
			response.sendRedirect("DeletePoliceOfficer.jsp");
		else 
		{
			boolean deleted = false;
			try 
			{
				SeniorPoliceOfficer spo = new SeniorPoliceOfficer();
				deleted = spo.deletePoliceOff(Name,ID);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(deleted == true)
				response.sendRedirect("Success.jsp");

		}
	}

}
