package next.Appointment.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import next.FIR.bean.FIR;

public class AppointmentDatabase
{
	public boolean Insert(Appointment A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
		
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// first retrieve to see if there is any appointment at that time if not insert
        	String sql = "SELECT * FROM Appointment where AppDate = ? and AppTime = ? ";
			PreparedStatement ps1;
			ps1 = con.prepareStatement(sql);
			ps1.setString(1, A.getAppDate());
			ps1.setString(2, A.getAppTime());
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next() == true)
				return false;
			
			else 
			{
				String Q= "Select top 1 ID from dbo.[Appointment] order by ID desc";
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
			  	String query  = "INSERT INTO dbo.[Appointment]  " +  "VALUES(?, ?, ?, ?, ?, ?)"; 
			  	PreparedStatement ps;
				ps = con.prepareStatement(query);
				ps.setString(1, String.valueOf(ss));
				ps.setString(2, A.getAppTime());
				ps.setString(3, A.getAppDate());
				ps.setString(4, A.getAppHolder().getName());
				ps.setString(5, A.getAppHolder().getCNIC());
				ps.setString(6, A.getAppointmentWith());
				
				status1 = ps.executeUpdate();
				if(status1 == 1)
					return true;
				con.close();	
			}
        } 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return false;	
	}
}
