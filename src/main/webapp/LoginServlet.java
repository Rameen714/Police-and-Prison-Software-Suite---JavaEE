package next.xadmin.login.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet ("/login")

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public LoginServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LoginDao loginDao = new LoginDao();
		
		String username = request.getParameter("Name");
		String password = request.getParameter("Password");
		
		LoginBean loginBean = new LoginBean();
		setLoginBean(username, password);
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try 
		{
			String rank= loginDao.validate(loginBean);
			if (rank.isEmpty() == false )
			{			
				String pass ="Junior"; 
				String pass1 ="Senior";
			
				if(rank.toLowerCase().contains((pass).toLowerCase()))
					response.sendRedirect("JPO_Menu.jsp");
				else if(rank.toLowerCase().contains((pass1).toLowerCase()))
					response.sendRedirect("loginSuccess.jsp");
			}
			else 
			{
				response.sendRedirect("login.jsp");
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
	}
	
	public static LoginBean obj;
	
	static LoginBean getPoliceOfficer()
	{
		return obj;
	}
	
	static void setLoginBean(String username, String password)
	{
		obj = new LoginBean();
		obj.setUsername(username);
		obj.setPassword(password);
	}
	}
