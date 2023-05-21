package next.complaint.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.citizen.bean.Citizen;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class Complaint_Servlet
 */
@WebServlet("/Complaint")
public class Complaint_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Complaint_Servlet() {
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
		String DES= request.getParameter("Description");
		
		if(Name.isEmpty() == true || CNIC.isEmpty()== true || DES.isEmpty()== true )
			  response.sendRedirect("Complaint_Form.jsp");
		else 
		{
			Citizen NewCitizen = new Citizen(Name,CNIC);
			
			boolean ISFiled = false;
			try
			{
				ISFiled = NewCitizen.File_Complain(DES);// need to add message here for successful/unsuccesful operation
				
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			if(ISFiled == true)
				  response.sendRedirect("Success.jsp");
		}
	}

}
