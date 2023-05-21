package next.Police.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import next.Cell.bean.Cell;
import next.Prisoner.bean.Prisoner;

public abstract class PoliceOfficer
{
	protected String name;
	protected String policeID;
	protected String password;
	protected String rank;
	
	public PoliceOfficer() 
	{
		name = policeID = password = null;		
	}
	
	public void displayListOfPrisoners(ArrayList<Prisoner> List) throws SQLException
	{
		Cell New = new Cell();
		New.getPrisoners(List);		
	}

	public boolean addPrisoner(String Name,String CNIC, String crime , String Cellid) throws SQLException
	{
		Prisoner NewPrisoner= new Prisoner();
		boolean isAdded = NewPrisoner.input(Name,CNIC,crime,Cellid);
		return isAdded;
	}
	public boolean relasePrisoner(String CNIC)
	{
		return false;
	}
	public  abstract void viewPatrols() ;
	
	public void SetId(String ID)
	{
		policeID = ID;
	}
	
	public String GetId()
	{
		return policeID ;
	}
}
