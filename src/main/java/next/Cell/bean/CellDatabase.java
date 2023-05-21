package next.Cell.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import next.FIR.bean.FIR;
import next.Prisoner.bean.Prisoner;


public class CellDatabase 
{
	public boolean releaseP(String releaseCNIC) throws SQLException
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int s = -1, s2 = -1; int s3=-1;
		
		try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
			String sql = "UPDATE Prisoner SET status = 'Released' WHERE CNIC = ?";
			String sql1 = "Update Prisoner SET DateofRelease = ? WHERE CNIC = ?";
			String sql3="Update Prisoner SET CellID = 0  WHERE CNIC = ?";
			
			PreparedStatement ps3;
			PreparedStatement ps1;
			PreparedStatement ps2;
			
			ps1 = con.prepareStatement(sql);
			ps2 = con.prepareStatement(sql1);
			ps3 = con.prepareStatement(sql3);
			
			ps1.setString(1,releaseCNIC);
			LocalDate date= LocalDate.now();
			
			String S = date.toString();
			
			System.out.println(S);
			ps2.setString(1, S);
			ps2.setString(2, releaseCNIC);
			
			ps3.setString(1,releaseCNIC);
			
			s = ps1.executeUpdate();
			s2 = ps2.executeUpdate();
			s3 = ps3.executeUpdate();
			
			if(s == 1 && s2 == 1)
				return true;
			con.close();
        }
		catch(SQLException F)
		{
			F.printStackTrace();
		}
		
		return false;
	}
	
	public void Display(ArrayList<Prisoner> A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// write SQL query to input into database 	 
			String Q= "Select* from dbo.[Prisoner]";
			PreparedStatement p;
			p = con.prepareStatement(Q);
			ResultSet rs = p.executeQuery();
			
			while (rs.next())
			{	 
				Prisoner NEW = new Prisoner();
				NEW.Setter(rs.getString("Name"), rs.getString("CNIC"), rs.getString("DateOfEntry"), rs.getString("DateofRelease"),
						rs.getString("Crime"),rs.getString("CellID"),rs.getString("Status"));		
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

}
