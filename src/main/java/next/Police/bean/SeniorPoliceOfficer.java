package next.Police.bean;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

import next.Cell.bean.Cell;
import next.FIR.bean.FIR;
import next.FIR.bean.FIRDatabase;
import next.Patrol.bean.Patrol;
import next.Patrol.bean.PatrolDao;
import next.Report.bean.Report;
import next.Resource.bean.Resource;
import next.Resource.bean.ResourceDao;
import next.complaint.bean.Complaint;

public class SeniorPoliceOfficer extends PoliceOfficer
{
	public SeniorPoliceOfficer() 
	{
		
	}
	
	public SeniorPoliceOfficer(String Name,String ID,String Password,String Rank) 
	{
		this.name = Name;
		this.policeID = ID;
		this.password = Password;
		this.rank = Rank;
	}
	
	public boolean 	addPoliceOff(String Name,String ID,String Password,String Rank) throws Exception
	{
		SeniorPoliceOfficerDao D = new SeniorPoliceOfficerDao();
		boolean added = false;
		if(Rank.equals("Junior"))
		{
			JuniorPoliceOfficer JPO = new JuniorPoliceOfficer(Name,ID,Password,Rank);
			added = D.Insert(JPO);	
		}
		else if(Rank.equals("Senior"))
		{
			SeniorPoliceOfficer SPO = new SeniorPoliceOfficer(Name,ID,Password,Rank);			
			added = D.Insert(SPO);
		}

		return added;
	}
	public boolean 	editPoliceOff(String OfficerID,String item,String choice) throws Exception 
	{
		SeniorPoliceOfficerDao spod = new SeniorPoliceOfficerDao();
		boolean edited = spod.Edit(OfficerID,item,choice);
		if (edited == false)
			System.out.println("OOPS_Java");		
		return edited;
	}
	public boolean 	deletePoliceOff(String Name,String ID) throws Exception 
	{
		SeniorPoliceOfficerDao spod = new SeniorPoliceOfficerDao();
		boolean deleted = spod.Remove(Name,ID);
		return deleted;
	}
	public Report generateReport() throws SQLException 
	{
		Report New = new Report();
		New.calculateCrimes();
		return New;	
	}
	public void 	manageComplaints() 
	{
		
	}
	public boolean 	assignPatrols(String dateOfPatrol,String startTime, String endTime, String jPOID, String Name) 
	{
		System.out.println("IN SPO ASSIGN PATROLS");
		Patrol A = new Patrol(dateOfPatrol,startTime, endTime,Name,jPOID );
		System.out.println("Back from PATROLS to SPO");
		PatrolDao D = new PatrolDao();
		boolean assigned = D.update(A);
		return assigned;
	}
	
	public boolean 	addResources(String ID, String Type) throws NumberFormatException, Exception 
	{
		boolean inUse = false;
		Resource r = new Resource(Integer.parseInt(ID),Type,inUse);
		if(r!=null)
			return true;
		return false;
	}
	
	public boolean 	appointOfficer()
	{
		return false;
	}
	public void 	managePrisoner()
	{
		
	}
	
	public void 	DisplayListOfComplaint(ArrayList<Complaint> List) throws Exception  
	{
		Complaint c = new Complaint();
		c.DisplayComplaint(List);
	}
	
	public void DisplayListOfFIR(ArrayList<FIR> List) throws SQLException
	{
		
		FIR NEW = new FIR();
		NEW.displayFIR(List);
	}
	
	public void 	ResolveComplaint(int ID) throws Exception
	{
		System.out.println("I am in SPO");
		System.out.println(ID);
		Complaint New = new Complaint();
		New.updateStatus(ID);
	}
	
	public void ResolveFIR(String ID) throws SQLException

	{
		FIR New = new FIR();
		New.updateStatus(ID);
	}

	@Override
	public void viewPatrols() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean 	assignResources(String _resourceid , String _firID) 
	{
		ResourceDao obj2 = new ResourceDao();
		if(obj2.check(_resourceid) == true)
		{
			FIR fir1 = new FIR();
			FIRDatabase fir2 = new FIRDatabase();
			if(fir2.checkFir(_firID) == true)
			{
//				fir1.setID(_firID);
//				fir1.setResourceID(_resourceid);
				return true;
			}
			
		}
		
		
		
		return false;
	}
	
	public boolean 	appointOfficer(String OfficerId , String FirId)
	{
		PoliceOfficerDao obj2 = new PoliceOfficerDao();
		if(obj2.checkOfficer(OfficerId) == true)
		{
			FIRDatabase fir2 = new FIRDatabase();
			if(fir2.checkFir(FirId) == true)
			{
//				fir1.setID(_firID);
//				fir1.setResourceID(_resourceid);
				return true;
			}
			
		}
		return false;
	}
	
	public boolean deleteResource(String iD) throws Exception {
		
		ResourceDao d = new ResourceDao();
		Boolean removed = d.Remove(iD);
		return removed;
	}
}
