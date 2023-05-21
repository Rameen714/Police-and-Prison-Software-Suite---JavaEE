package next.Token.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TokenDatabase // gets token number from database and return : search by using current date 
{
	public int Update(LocalDate A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// first we'll check if there is data related to current date in database if yes then we get and generate 
        	// that token number and update value else we add new date data and start tokens from start
        	// write SQL query to input into database 	 
		  	String query  = "SELECT TokenNO FROM Token where TokenDate = ?"; 	 
		  	PreparedStatement ps;
			ps = con.prepareStatement(query);
			ps.setString(1 , A.toString());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == true)
			{
				int stat = rs.getInt("TokenNO");
				int ss= stat +1;
				
				String querys  = "update Token set TokenNO =?  where TokenNO=?"; 	 
			  	PreparedStatement pss;
				pss = con.prepareStatement(querys);
				pss.setString(1 , String.valueOf(ss));
				pss.setString(2, String.valueOf(stat));
				status1 = pss.executeUpdate();
				
				return stat;
			}
				
			else 
			{
				String q  = "INSERT INTO dbo.[Token] " +  "VALUES(?, ?)"; 	
				int s=2;
			  	PreparedStatement pss;
				pss = con.prepareStatement(q);
				pss.setString(1, A.toString());
				pss.setString(2, String.valueOf(s));
				status1 = pss.executeUpdate();
		
				return 1;
			}
        } 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
  
        return 0;
	}
}
