package next.xadmin.login.bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao 
{
	public String validate(LoginBean loginBean) throws SQLException 
	{
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbUrl = "jdbc:sqlserver://VALEENAAFZAL ;database=PoliceSystem;integratedSecurity = true; encrypt=true;trustServerCertificate=true";
		String rank=null;
	
        try (Connection con = DriverManager.getConnection(dbUrl); Statement stmt = con.createStatement();) 
        {
			String sql = "SELECT * FROM PoliceOfficer where ID = ? and Password =? ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getPassword());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next() == true)
				rank= rs.getString("Rank");
				
			con.close();
			
        }
		catch (SQLException e)
		{
			e.printStackTrace();
		}
        return rank;
	}
}