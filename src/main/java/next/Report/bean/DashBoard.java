package next.Report.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DashBoard
{
	public boolean Update(Report A)  throws SQLException 
	{
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
			String sql = "select count(*) total from dbo.[FIR]";
			String sql1 = "SELECT Count(*) total FROM FIR WHERE  FileDate >= DATEADD(day,-7, GETDATE())";
			String sql3="SELECT Count(*) total FROM Prisoner WHERE  DateOfEntry >= DATEADD(day,-7, GETDATE())";
			
			PreparedStatement ps3;
			PreparedStatement ps1;
			PreparedStatement ps2;
			
			ps1 = con.prepareStatement(sql);
			ps2 = con.prepareStatement(sql1);
			ps3 = con.prepareStatement(sql3);
			
			ResultSet s = ps1.executeQuery();
			ResultSet s2 = ps2.executeQuery();
			ResultSet s3 = ps3.executeQuery();
			while(s.next() && s2.next() && s3.next())
			{
				System.out.println(s.getString("total"));
				System.out.println(s2.getString("total"));
				System.out.println(s3.getString("total"));
				
				A.setTotalCrimes(Integer.valueOf(s.getString("total")));
				A.setNoOfUniqueCases(Integer.valueOf(s2.getString("total")));
				A.setNoOfNewPrisoners(Integer.valueOf(s3.getString("total")));
			}
			con.close();
        }
		catch(SQLException F)
		{
			F.printStackTrace();
		}
		
		return false;
	}
}
