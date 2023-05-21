package next.Patrol.bean;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import next.Police.bean.JuniorPoliceOfficer;
import next.Police.bean.PoliceOfficer;
import next.xadmin.login.bean.LoginServlet;

public class PatrolDao 
{
	public List<Patrol> display(String JPOName, String JPOID)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
       
		ResultSet rs = null;	
		List<Patrol> list = new ArrayList();
		
		
		String check = LoginServlet.obj.getPassword();
		if(check.charAt(0) == 'J')
		{
			try (Connection con = DriverManager.getConnection(dbUrl)) 
	        {
				// write SQL query to input into database 	 
			  	String query  = "SELECT FROM dbo.[Patrol]" +  "WHERE Patrol.AppointeeID" + JPOID; 	 
			  	PreparedStatement ps;
				ps = con.prepareStatement(query);
	
	
				rs = con.createStatement().executeQuery(query);
	
		        String ID = "na";
		        String LocalDate = "NotFound";
		        String StartTime = "NotFound";
		        String EndTime = "NotFound";
		        String AppointeeName = "NotFound";
		        String AppointeeID = "NotFound";
		         
				Patrol type = new Patrol();
	
	
			    while (rs.next()) {
			    	
			    	type.setID(rs.getString(1));
			        type.setLocalDate(rs.getString(2));
			        type.setStartTime(rs.getString(3));
			        type.setEndTime(rs.getString(4));
			        type.setAppointeeName(rs.getString(5));
			        type.setAppointeeID(rs.getString(6));
			        System.out.println(ID+"  "+LocalDate+"  "+StartTime+"  "+EndTime+"  "+AppointeeName+"  "+AppointeeID);
			        list.add(type);
			        
			    }
			    rs.close();
			    con.close();
	
	        }catch (SQLException e) {
	        	System.out.println("SQLException");
			    e.printStackTrace();
			}
		}  

		
		else
		{
			System.out.println("No ID Found");
		}
			
        return(list);	
	}
	
	
	public List<Patrol> display()  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
       
		ResultSet rs = null;	
		List<Patrol> list = new ArrayList();
		
		
		String check = LoginServlet.obj.getPassword();
		if (check.charAt(0) == 'S')
		{
			try (Connection con = DriverManager.getConnection(dbUrl)) 
	        {
	        	// write SQL query to input into database 	 
			  	String query  = "SELECT FROM dbo.[Patrol]"; 	 
			  	PreparedStatement ps;
				ps = con.prepareStatement(query);
	
	
				rs = con.createStatement().executeQuery(query);
	
		        String ID = "na";
		        String LocalDate = "NotFound";
		        String StartTime = "NotFound";
		        String EndTime = "NotFound";
		        String AppointeeName = "NotFound";
		        String AppointeeID = "NotFound";
		         
				Patrol type = new Patrol();
	
	
				while (rs.next()) {
					type.setID(rs.getString(1));
			        type.setLocalDate(rs.getString(2));
			        type.setStartTime(rs.getString(3));
			        type.setEndTime(rs.getString(4));
			        type.setAppointeeName(rs.getString(5));
			        type.setAppointeeID(rs.getString(6));
			        System.out.println(ID+"  "+LocalDate+"  "+StartTime+"  "+EndTime+"  "+AppointeeName+"  "+AppointeeID);
			        list.add(type);
			    }
			    rs.close();
			    con.close();
	
	         }catch (SQLException e) {
	        	 System.out.println("SQLException");
			     e.printStackTrace();
			 }
		 
		}
		
		else
		{
			System.out.println("No ID Found");
		}
			
        return(list);		
		
	}

	

	 public boolean update(Patrol A) 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl);) 
        {
        	System.out.println("I am here in patrol dao");
		  	String query  = "INSERT INTO dbo.[Patrol]  " +  "VALUES(?, ?, ?, ?, ?, ?)"; 	 
		  	PreparedStatement ps;
			ps = con.prepareStatement(query);
			ps.setString(1, A.getID());
			ps.setString(2, A.getDateOfPatrol());
			ps.setString(3, A.getStartTime());
			ps.setString(4, A.getEndTime());
			ps.setString(5, A.getJPOName());
			ps.setString(6, A.getJPOID());
			
			status1 = ps.executeUpdate();
			if(status1 == 1)
				return true;
			con.close();	
        } 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return false;
	}


}