package next.Prisoner.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrisonerDatabase 
{
	public boolean Insert(Prisoner A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// write SQL query to input into database 	 
		  	String query  = "INSERT INTO dbo.[Prisoner]  " +  "VALUES(?, ?, ?, ?, ?, ?, ?)"; 	 
		  	PreparedStatement ps;
			ps = con.prepareStatement(query);
			ps.setString(1, A.getAPrisoner().getName());
			ps.setString(2, A.getAPrisoner().getCNIC());
			ps.setString(3, A.getDateOfEntry());
			ps.setString(4, null);
			ps.setString(5, A.getCrime());
			ps.setString(6, A.getCellId());
			ps.setString(7, A.getStatus());
			
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
