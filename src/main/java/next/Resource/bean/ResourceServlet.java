package next.Resource.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.SeniorPoliceOfficer;

import java.io.IOException;

@WebServlet("/Resource")
/**
 * Servlet implementation class ResourceServlet
 */
public class ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceServlet() {
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
		// TODO Auto-generated method stub
		if(request.getParameter("submit") != null)
		{
			String FIRID = request.getParameter("FIRID");
			String ResourceID = request.getParameter("ResourceID");
			
			System.out.println("Sumbit k bad ka ");
			System.out.println(FIRID);
			System.out.println(ResourceID);
			
			SeniorPoliceOfficer SPO = new SeniorPoliceOfficer();
			boolean check = SPO.assignResources(ResourceID, FIRID);
			
			System.out.println("Assign k bad ka ");
			System.out.println(FIRID);
			System.out.println(ResourceID);
			
			if(check)
			{
				response.sendRedirect( "ResourceAssigned.jsp?FIRID=" + FIRID + "&ResourceID=" + ResourceID);
				
			}
			
		}
	}

}
