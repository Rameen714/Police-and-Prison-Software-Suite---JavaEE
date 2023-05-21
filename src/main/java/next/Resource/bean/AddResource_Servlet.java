package next.Resource.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.SeniorPoliceOfficer;

import java.io.IOException;

/**
 * Servlet implementation class AddResource_Servlet
 */
@WebServlet("/AddResource")
public class AddResource_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResource_Servlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String ID	= request.getParameter("ID");
		String Type = request.getParameter("Type");
		
		if(ID.isEmpty() == true || Type.isEmpty() == true)
			response.sendRedirect("AddResource.jsp");
		else
		{
			SeniorPoliceOfficer SPO = new SeniorPoliceOfficer();
			boolean added = false;
			try 
			{
				added = SPO.addResources( ID,Type);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if(added == true)
				response.sendRedirect("Success.jsp");
		}
	}
	

}
