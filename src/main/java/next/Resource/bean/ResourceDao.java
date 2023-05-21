package next.Resource.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ResourceDao 
{

	public boolean Insert (Resource R) throws Exception
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
		
		try(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();)
		{
			String sql = "INSERT INTO dbo.[Resources] " + "VALUES(?,?,?)";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, R.name);
			ps.setString(2, R.getID());
			ps.setString(3, String.valueOf(R.inUse));
			
			status1 = ps.executeUpdate();
			if(status1 == 1)
				return true;
			con.close();
		}
        catch (SQLException e) 
        {
			e.printStackTrace();
		} 
		return false;
		
	}
	public boolean Remove (String ID)  throws Exception
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		int status1 = -1;
		System.out.println(ID);
		try(Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();)
		{
			String sql = "delete from dbo.[Resources] where ID = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			status1 = ps.executeUpdate();
			if(status1 == 1)
				return true;
			con.close();
			System.out.println("OOPS DAo");
		}
        catch (SQLException e) 
        {
			e.printStackTrace();
		} 
		return false;
	}
	
	public Boolean check(String ResourceID )
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		
		
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
        	// first retrieve to see if there is any appointment at that time if not insert
        	String sql = "SELECT * FROM Resources WHERE ID = ?";
			PreparedStatement ps1;
			ps1 = con.prepareStatement(sql);
			ps1.setString(1,  ResourceID);
			ResultSet rs = ps1.executeQuery();
			
//			if(rs.next() == true)
//				return false;
			if(rs.next()) {
				 
//                myID = rs.getString("ID");
//                myName = rs.getString("name");
//                String _Status = rs.getString("status");
//                if(_Status == "Inuse")
//                {
//                	myStatus = true;
//                	
//                }
//                else
//                {
//                	myStatus = false;
//                }
                return true;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
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
