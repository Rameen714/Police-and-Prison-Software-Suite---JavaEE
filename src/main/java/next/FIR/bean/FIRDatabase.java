package next.FIR.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FIRDatabase
{
	public boolean Insert(FIR A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// write SQL query to input into database 	 
		  	String query  = "INSERT INTO dbo.[FIR]  " +  "VALUES(?, ?, ?, ?, ?, ?, ? , ? , ? , ?)"; 	 
		  	PreparedStatement ps;
			ps = con.prepareStatement(query);
			
			String Q= "Select top 1 ID from dbo.[FIR] order by ID desc";
			PreparedStatement p;
			p = con.prepareStatement(Q);
			ResultSet r = p.executeQuery();
			String s=null;
			while (r.next())
			{
				s= r.getString("ID");
			}
			
			if(s == null)
				s="1";
			int ss = Integer.valueOf(s);
			
			ss++;
			
			ps.setString(1, String.valueOf(ss));
			ps.setString(2, A.getReportedBy().getName());
			ps.setString(3, A.getReportedBy().getCNIC());
			ps.setString(4, A.getReportedAgainst().getName());
			ps.setString(5, A.getReportedAgainst().getCNIC());
			ps.setString(6, A.getFirDescription());
			ps.setString(7, A.getStatus());
			ps.setString(8, A.getDateofFIR());
			ps.setString(9, null);
			ps.setString(10,null);
			
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
	
	public void Display(ArrayList<FIR> A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// write SQL query to input into database 	 
			String Q= "Select* from dbo.[FIR]";
			PreparedStatement p;
			p = con.prepareStatement(Q);
			ResultSet rs = p.executeQuery();
			while (rs.next())
			{	 
				FIR NEW = new FIR();
				NEW.Setter(rs.getString("ID"), rs.getString("ReportedByName"), rs.getString("ReportedByID"), rs.getString("ReportedAgainstName"),
						rs.getString("ReportedAgainstID"),rs.getString("Description"),rs.getString("status"),
						rs.getString("FileDate") ,rs.getString("AppointedOfficerID"),rs.getString("ResourceID") );
				
				A.add(NEW);
			}
			con.close();	
        } 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void Search(String ID)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	String Q= "Select * from dbo.[FIR] where ID = ?";
			PreparedStatement p;
			p = con.prepareStatement(Q);
			p.setString(1 , ID);
			ResultSet r = p.executeQuery();
			String s=null;
			while (r.next())
			{
				s= r.getString("status");
			}
			
			String setString =null;
			
			if(s.equals("ongoing"))
			{	
				setString = "completed";
			}
			else
			{
				setString="ongoing";
			}
			
			System.out.println(s);
			System.out.println(setString);
        	String querys  = "update dbo.[FIR] set [status]=? where ID = ?"; 	 
		  	PreparedStatement pss;
			pss = con.prepareStatement(querys);
			pss.setString(1 , setString);
			pss.setString(2 , ID);
			status1 = pss.executeUpdate();
			con.close();	
        } 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public Boolean checkFir(String FIRID ) // FIR obj
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		
		
	    try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
	    {
	    	// first retrieve to see if there is any appointment at that time if not insert
	    	String sql = "SELECT * FROM FIR WHERE ID = ?";
			PreparedStatement ps1;
			ps1 = con.prepareStatement(sql);
			
			ps1.setString(1,FIRID );
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next() == true) {
				
				return true;
	            
	        }
			return false;
	    } 
	    catch (SQLException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return false;	
	}
}
