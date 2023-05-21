package next.Prisoner.bean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import next.citizen.bean.Citizen;

public class Prisoner 
{
	private Citizen APrisoner;
	private LocalDate dateOfEntry;
	private LocalDate dateOfRelease;
	private String crime;
	private int cellId;
	private String status;
	
	public Prisoner()
	{
		APrisoner = null;
		dateOfEntry = LocalDate.now();
		dateOfRelease = null;
		crime = "";
		setCellId(-1);
		setStatus(null);
	}
	
	public void Setter(String A, String B , String C , String D ,String E, String F , String G)
	{
		this.APrisoner = new Citizen(A,B);
		 dateOfEntry = LocalDate.parse(C);
		 if(D != null)
			 dateOfRelease= LocalDate.parse(D);
		 crime = E;
		 cellId =Integer.valueOf(F);
		 status = G;
	}
	
	public boolean input(String Name , String Cnic, String Des, String cellID) throws SQLException
	{
		this.APrisoner = new Citizen(Name,Cnic);
		int i = Integer.parseInt(cellID);
		this.cellId =i;
		crime =Des;
		status = "InPrison";
		
		PrisonerDatabase NewPrisoner = new PrisonerDatabase();
		boolean isAdded =  NewPrisoner.Insert(this);
		return isAdded;		
	}
	
	public boolean SetStatus() // function to change status of prisoner relased/ inprison
	{
		
		// when we chnage status to release we must set release date as well
		return true;
	}

	public String getDateOfEntry() {
		return dateOfEntry.toString();
	}

	public Citizen getAPrisoner() {
		return APrisoner;
	}

	public String getDateOfRelease() 
	{
		if(dateOfRelease != null)
			return dateOfRelease.toString();
		else 
			return null;
	}

	public String getCrime() {
		return crime;
	}

	public String getCellId() {
		String Id= Integer.toString(cellId);
		return Id;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
