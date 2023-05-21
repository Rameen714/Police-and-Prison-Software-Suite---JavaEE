package next.Police.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SeniorPoliceOfficerDao {

	public boolean Insert (PoliceOfficer PO) throws Exception
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
		
		try(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();)
		{
			String sql = "INSERT INTO dbo.[PoliceOfficer] " + "VALUES(?,?,?,?)";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, PO.name);
			ps.setString(2, PO.policeID);
			ps.setString(3, PO.password);
			ps.setString(4, PO.rank);
			
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
	public boolean Remove (String Name,String ID)  throws Exception
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";

		int status1 = -1;
		
		try(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();)
		{
			String sql = "delete from dbo.[PoliceOfficer] where Name = ? and ID = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, Name);
			ps.setString(2, ID);
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
	public boolean Edit(String OfficerID,String item, String choice ) throws Exception
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";

		int status = -1;
		
		try(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();)
		{
			String sql1 = "update dbo.[PoliceOfficer] set ID = ? where ID = ?";
			String sql2 = "update dbo.[PoliceOfficer] set Password = ? where ID = ?";
			String sql3 = "update dbo.[PoliceOfficer] set Name = ? where ID = ?";
			String sql4 = "update dbo.[PoliceOfficer] set Rank = ? where ID = ?";
			
			if(item.equals("ID"))
			{	
				PreparedStatement ps1;
				ps1 = con.prepareStatement(sql1);
				ps1.setString(1, choice);
				ps1.setString(2, OfficerID);
				status = ps1.executeUpdate();					
			}
			else if(item.equals("Password"))
			{	
				PreparedStatement ps2;
				ps2 = con.prepareStatement(sql2);
				ps2.setString(1, choice);
				ps2.setString(2, OfficerID);
				status = ps2.executeUpdate();					
			
			}
			else if(item.equals("Name"))
			{		
				PreparedStatement ps3;
				ps3 = con.prepareStatement(sql3);
				ps3.setString(1, choice);
				ps3.setString(2, OfficerID);
				status = ps3.executeUpdate();						
			
			}
			else if(item.equals("Ran"))
			{		
				PreparedStatement ps4;
				ps4 = con.prepareStatement(sql4);
				ps4.setString(1, choice);
				ps4.setString(2, OfficerID);
				status = ps4.executeUpdate();						
			
			}
			con.close();
			if(status == 1)				
				return true;
		}
        catch (SQLException e) 
        {
			e.printStackTrace();
		} 
		return false;
	}
}
