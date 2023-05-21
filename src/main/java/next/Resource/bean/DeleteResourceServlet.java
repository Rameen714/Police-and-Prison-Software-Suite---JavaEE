package next.Resource.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.SeniorPoliceOfficer;

import java.io.IOException;

/**
 * Servlet implementation class DeleteResourceServlet
 */
@WebServlet("/DeleteResource")
public class DeleteResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteResourceServlet() {
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
			
			if(ID.isEmpty() == true )
				response.sendRedirect("DeleteResource.jsp");
			else
			{
				SeniorPoliceOfficer SPO = new SeniorPoliceOfficer();
				boolean added = false;
				try 
				{
					added = SPO.deleteResource(ID);
					System.out.println(added);
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
