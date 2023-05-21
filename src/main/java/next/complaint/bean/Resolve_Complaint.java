package next.complaint.bean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.FIR.bean.FIR;
import next.Police.bean.SeniorPoliceOfficer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/ResolveComplaint")
public class Resolve_Complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Resolve_Complaint() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
	     try (PrintWriter out = response.getWriter())
	     {
	       out.println("<!DOCTYPE html>");
	       out.println("<html>");
	       out.println("<head>");
	       out.println("<title>Complaint LIST</title>");
	       out.println("</head>");
	       out.println("<body>");
	  
	       ArrayList<Complaint> std = new ArrayList<Complaint>();
	       
	       SeniorPoliceOfficer NEW = new SeniorPoliceOfficer();
	       NEW.DisplayListOfComplaint(std);
	  
	       // Setting the attribute of the request object
	       request.setAttribute("data", std);
	  
	       // Creating a RequestDispatcher object to dispatch
	       RequestDispatcher rd = request.getRequestDispatcher("ComplaintList.jsp");
	  
	       // The request will be forwarded to the resource 
	       rd.forward(request, response);
	       out.println("</body>");
	       out.println("</html>");
	     } 
	     catch (Exception e) 
	     {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

    public String getServletInfo()
    {
        return "Short description";
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String Id = request.getParameter("ID");
		System.out.println("I am in resolve complaint srvelte");
		System.out.println(Integer.parseInt(Id));
		SeniorPoliceOfficer spo= new SeniorPoliceOfficer();
		try 
		{
			spo.ResolveComplaint(Integer.parseInt(Id));
			doGet(request, response);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
