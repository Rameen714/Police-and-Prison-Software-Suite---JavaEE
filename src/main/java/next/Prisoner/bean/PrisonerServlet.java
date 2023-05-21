package next.Prisoner.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.JuniorPoliceOfficer;
import next.citizen.bean.Citizen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class PrisonerServlet
 */
@WebServlet("/AddPrisoner")
public class PrisonerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrisonerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String Name = request.getParameter("Name");
		String CNIC = request.getParameter("CNIC");
		String cell = request.getParameter("CellID");
		String crime= request.getParameter("Description");
		
		if(Name.isEmpty() == true || CNIC.isEmpty()== true || cell.isEmpty() == true || crime.isEmpty()== true )
			  response.sendRedirect("AddPrisoner_Form.jsp");
		else 
		{
			JuniorPoliceOfficer New = new JuniorPoliceOfficer();
			boolean ISFiled = false;
			try 
			{	
				ISFiled = New.addPrisoner(Name, CNIC, crime , cell); // need to add message here for successful/unsuccesful operation
			} 
			catch (SQLException e) 
			{
					e.printStackTrace();
			}
			
			if(ISFiled == true)
				  response.sendRedirect("Success.jsp");
			else 
				response.sendRedirect("AddPrisoner_Form.jsp");
		}
	}

}
