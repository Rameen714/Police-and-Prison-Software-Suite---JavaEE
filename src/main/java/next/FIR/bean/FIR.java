package next.FIR.bean;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import next.Resource.bean.Resource;
import next.Police.bean.JuniorPoliceOfficer;
import next.citizen.bean.Citizen;

enum Status {
    ongoing,
    completed
}

public class FIR 
{
	// should add ID 
	private String ID;
	private Citizen ReportedBy;
    private Citizen ReportedAgainst;
    private LocalDate dateofFIR;
    private String firDescription;
    private Status status;
    private JuniorPoliceOfficer AppointedOfficer;
    private Resource AssignedResource;
    
    
    
    public void Setter(String A, String B , String C , String D ,String E, String F , String G , String H, String I, String J)
    {
    	this.ID =A;
    	
    	this.ReportedBy = new Citizen(B,C);
    	this.ReportedAgainst = new Citizen(D, E);
		/*
		 * this.ReportedBy.setName(B); this.ReportedBy.setCNIC(C);
		 */
		/*
		 * this.ReportedAgainst.setName(D); this.ReportedAgainst.setCNIC(E);
		 */
    	
    	this.dateofFIR =LocalDate.parse(H);
    	this.firDescription = F;
    	
    	this.status = Status.valueOf(G);	
    	
    	AppointedOfficer = new JuniorPoliceOfficer();
    	if(I != null)
    		AppointedOfficer.SetId(I); 
    	AssignedResource = new  Resource();
    	if(J != null)
    		AssignedResource.setId(J); 
    }
    public FIR()// default constructor
    {
    	this.ReportedBy = null;
    	this.ReportedAgainst =null;
    	this.dateofFIR = null;
    	this.firDescription = null;
    	this.status = null;	
    	this.ID =null;
    	AppointedOfficer= null;
    	AssignedResource =null;
    }

    public boolean Input(Citizen _ReportedBy , String RAName , String DES) throws SQLException// setter
    {
    	this.ReportedBy = _ReportedBy ;
    	this.ReportedAgainst = new Citizen(RAName, "0");
    	this.dateofFIR = java.time.LocalDate.now();
    	this.firDescription = DES;
    	this.status = Status.ongoing;	
    	
    	FIRDatabase NEWFIR = new FIRDatabase();
    	boolean a = NEWFIR.Insert(this);
    	
    	return a;
    }

    public void displayFIR(ArrayList<FIR> List) throws SQLException
    {
    	FIRDatabase New = new FIRDatabase();
    	New.Display(List);
    }

    public void updateStatus(String ID) throws SQLException
    {
    	FIRDatabase New = new FIRDatabase();
    	New.Search(ID);
		
    }

	public String getID() 
	{
		return ID;
	}

	public Citizen getReportedBy() 
	{
		return ReportedBy;
	}

	public String getDateofFIR() 
	{
		return String.valueOf( dateofFIR);
	}
	
	public Citizen getReportedAgainst()
	{
		return ReportedAgainst;
	}

	public String getFirDescription() 
	{
		return firDescription;
	}

	public String getStatus()
	{
		return String.valueOf(status);
	}
	
	public JuniorPoliceOfficer getAppointedOfficer() 
	{
		return AppointedOfficer;
	}

	public Resource getResouces()
	{
		return AssignedResource;
	}

}


