package next.complaint.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComplaintDatabase 
{
	public boolean Insert(Complaint A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	String Q= "Select top 1 ID from dbo.[Complaint] order by ID desc";
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
			
			
        	// write SQL query to input into database 	 
		  	String query  = "INSERT INTO dbo.[Complaint]  " +  "VALUES(?, ?, ?, ?, ?)"; 	 
		  	PreparedStatement ps;
			ps = con.prepareStatement(query);
			ps.setString(1, String.valueOf(ss));
			ps.setString(2, A.isStatus());
			ps.setString(3, A.getComplainer().getName());
			ps.setString(4, A.getComplainer().getCNIC());
			ps.setString(5, A.getComplain());
			
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
	
	public void Display(ArrayList<Complaint> A)  throws SQLException 
	{
		System.out.println("IN C DAO ");
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// write SQL query to input into database 	 
			String Q= "Select* from dbo.[Complaint]";
			PreparedStatement p;
			p = con.prepareStatement(Q);
			ResultSet rs = p.executeQuery();
			while (rs.next())
			{	 
				Complaint NEW = new Complaint();
				NEW.Setter(rs.getInt("ID"), rs.getString("Description"), rs.getString("ComplainerName"),rs.getString("ComplainerID"), rs.getString("status"));
				System.out.println(rs.getInt("ID"));
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

	public void Search(int ID)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	String Q= "Select * from dbo.[Complaint] where ID = ?";
			PreparedStatement p;
			p = con.prepareStatement(Q);
			p.setInt(1 , ID);
			ResultSet r = p.executeQuery();
			String s=null;
			while (r.next())
			{
				s= r.getString("status");
			}
			System.out.println(s);
			String setString =null;			
			if(s.equals("unresolved"))
			{	
				setString = "resolved";
			}
			else
			{
				setString="unresolved";
			}
			
			System.out.println(s);
			System.out.println(setString);
        	String querys  = "update dbo.[Complaint] set [status]=? where ID = ?"; 	 
		  	PreparedStatement pss;
			pss = con.prepareStatement(querys);
			pss.setString(1 , setString);
			pss.setInt(2 , ID);
			status1 = pss.executeUpdate();
			con.close();	
        } 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
