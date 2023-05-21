package next.Police.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PoliceOfficer")
/**
 * Servlet implementation class PoliceOfficerServlet
 */
public class PoliceOfficerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoliceOfficerServlet() {
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
			String POID = request.getParameter("POID");
			
			System.out.println("Sumbit k bad ka ");
			System.out.println(FIRID);
			System.out.println(POID);
			
			SeniorPoliceOfficer SPO = new SeniorPoliceOfficer();
			boolean check = SPO.appointOfficer(POID, FIRID);
			
			System.out.println("Assign k bad ka ");
			System.out.println(FIRID);
			System.out.println(POID);
			
			if(check)
			{
				response.sendRedirect( "OfficerAppointedFIR.jsp?FIRID=" + FIRID + "&POID=" + POID);
				
			}
			
		}
	}

}
