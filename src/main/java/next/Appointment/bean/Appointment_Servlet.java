package next.Appointment.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.citizen.bean.Citizen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class Appointment_Servlet
 */
@WebServlet("/Appointment")
public class Appointment_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appointment_Servlet() {
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
		// app date and time should be next to cureent date and time 
		String Name = request.getParameter("Name"); // we need to add a check of time that app time should be office hours
		String CNIC = request.getParameter("CNIC");
		String WName = request.getParameter("WName");
		String Date = request.getParameter("Date");
		String time= request.getParameter("Time");
		
		if(Name.isEmpty() == true || CNIC.isEmpty()== true || Date.isEmpty() == true || time.isEmpty()== true || WName.isEmpty() == true)
			  response.sendRedirect("Appointment_Form.jsp");
		else 
		{
			Citizen NewCitizen = new Citizen(Name, CNIC);
			boolean ISFiled = false;
			try 
			{
				ISFiled = NewCitizen.Set_Appointment(Date, time , WName); // need to add message here for successful/unsuccesful operation
			} 
			catch (SQLException e) 
			{
					e.printStackTrace();
			}
			
			if(ISFiled == true)
				  response.sendRedirect("Success.jsp");
		}		
	}

}
