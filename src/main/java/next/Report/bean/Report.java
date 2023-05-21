package next.Report.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Report {
	
	private int totalCrimes;
	private int noOfNewPrisoners;
	private int noOfUniqueCases;
	public Report()
	{
		this.totalCrimes =0;
		this.noOfNewPrisoners =0 ;
		this.noOfUniqueCases=0;
	}
	
	public void calculateCrimes() throws SQLException
	{
		DashBoard New= new DashBoard();
		New.Update(this);
	}

	public int getTotalCrimes() {
		return totalCrimes;
	}
	public void setTotalCrimes(int totalCrimes) {
		this.totalCrimes = totalCrimes;
	}
	public int getNoOfNewPrisoners() {
		return noOfNewPrisoners;
	}
	public void setNoOfNewPrisoners(int noOfNewPrisoners) {
		this.noOfNewPrisoners = noOfNewPrisoners;
	}
	public int getNoOfUniqueCases() {
		return noOfUniqueCases;
	}
	public void setNoOfUniqueCases(int noOfUniqueCases) {
		this.noOfUniqueCases = noOfUniqueCases;
	}
}