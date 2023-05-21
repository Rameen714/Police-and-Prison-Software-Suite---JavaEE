package next.FIR.bean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.SeniorPoliceOfficer;
import next.citizen.bean.Citizen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/FIR")
public class FIR_Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public FIR_Servlet() 
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
	
	}
	    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		String Name = request.getParameter("Name");
		String CNIC = request.getParameter("CNIC");
		String RAName = request.getParameter("AgainstName");
		String DES= request.getParameter("Description");
		
		if(Name.isEmpty() == true || CNIC.isEmpty()== true || RAName.isEmpty() == true || DES.isEmpty()== true )
			  response.sendRedirect("FIR_Form.jsp");
		else 
		{
			Citizen NewCitizen = new Citizen(Name, CNIC);
			boolean ISFiled = false;
			try 
			{
				
				ISFiled = NewCitizen.File_FIR(RAName , DES); // need to add message here for successful/unsuccesful operation
			} 
			catch (SQLException e) 
			{
					e.printStackTrace();
			}
			
			if(ISFiled == true)
				  response.sendRedirect("Success.jsp");
		}
	}
	
	protected void doResolve(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
			{
				String Id = request.getParameter("ID");
				System.out.println(Id);
			}

}
