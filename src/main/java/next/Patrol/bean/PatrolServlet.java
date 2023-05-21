package next.Patrol.bean; 

import java.io.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.Police.bean.JuniorPoliceOfficer;
import next.Police.bean.PoliceOfficerDao;
import next.Police.bean.SeniorPoliceOfficer;
import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.bean.LoginServlet; 

/**
 * Servlet implementation class PatrolServlet
 */
/* @WebServlet("/AssignPatrols") */ @WebServlet(urlPatterns = {"/AssignPatrols", "/Patrol"})
public class PatrolServlet extends HttpServlet
{ 
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public PatrolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
		String JPOID = request.getParameter("ID");
		String Name  = request.getParameter("Name");
		String dateOfPatrol = request.getParameter("Date");
		String startTime = request.getParameter("StartTime");
		System.out.println("I am the problem");
		System.out.println(startTime);
		String endTime = request.getParameter("EndTime");
		
		/*
		 * startTime = "00:00:00"; endTime = "00:00:00";
		 */
		boolean assigned = false;
		try 
		{

			PoliceOfficerDao D = new PoliceOfficerDao();
			boolean matched = D.Search(JPOID);
			if(matched == true)
			{
				System.out.println("I am in matched true");
				SeniorPoliceOfficer SPO = new SeniorPoliceOfficer();
				assigned = SPO.assignPatrols(dateOfPatrol, startTime, endTime, JPOID, Name);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(assigned == true)
			response.sendRedirect("Success.jsp");
		else
			System.out.println("OOPS");
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
		if(request.getParameter("submitJPOID") != null)
		{
			String id = request.getParameter("ID");
			System.out.println(id);
			response.sendRedirect( "DisplayOfficersPatrol.jsp?id=" + id );
		}
		System.out.println("Patrol_Servlet_doPost1_1");
		if(request.getParameter("JPOViewPatrols") != null)
		{
			System.out.println("Patrol_Servlet_doPost1_2");
			LoginBean LBObj = new LoginBean();
			LBObj = LoginServlet.obj;
			String username = LBObj.getUsername();
			System.out.println(username);
			
			response.sendRedirect( "Display_JPO_Schedule.jsp?UN=" + username );
		}
  }
} 