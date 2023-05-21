package next.Token.bean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

// you can use token the same  day you generate it
public class Token 
{
    private int tokenNo;
    private LocalTime generatedAt;
    private LocalDate visitingDate;
  
	public void input() throws SQLException
    {
		this.visitingDate = LocalDate.now();
		this.generatedAt = LocalTime.now(); 
		TokenDatabase New = new TokenDatabase();
		int number = New.Update(visitingDate);
		this.tokenNo = number;
		
		// we'll get token number from database we'll store token number for each date there and then get them 
		// we need to return token object
		// Token dao take input from databse and create new object and return it
    }
    //getter setters
	public int getTokenNo() 
	{
		return tokenNo;
	}
	public String getVisitingDate()
	{
		return visitingDate.toString();
	}
	public String getGeneratedAt() 
	{
		return generatedAt.toString();
	}
}