package next.complaint.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import next.citizen.bean.Citizen;

enum ComplaintStatus {
    unresolved,
    resolved
}


public class Complaint 
{
	private int ID;
	private  ComplaintStatus Status;
	private String Complain;
	private Citizen Complainer;
	
	public Complaint()
	{
		this.ID= 0;
		this.Status = ComplaintStatus.unresolved ;
		this.Complain = null;
		this.Complainer = null;
		
	}
	public void Setter(int ID,String A, String B , String C,String D)
	{
		this.ID = ID; 
		this.Complain = A;
		this.Complainer = new Citizen(B,C);
		this.Status = ComplaintStatus.valueOf(D);
	}

	
	public boolean Input(Citizen complainer , String complain) throws SQLException // takes input kind of a setter for all attributes
	{
		this.Complain = complain;
		this.Complainer = complainer;
		
		ComplaintDatabase NewComplaint = new ComplaintDatabase();
		boolean Filed =NewComplaint.Insert(this);
		return Filed;
	}
	
	public void DisplayComplaint(ArrayList<Complaint> List) throws SQLException// print function
	{
		ComplaintDatabase cd =  new ComplaintDatabase(); 
		cd.Display(List);
	}
	
	public void ChangeStatus(ComplaintStatus status)// setter
	{
		Status = status;
	}

	public String getID() 
	{
		return String.valueOf(ID);
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public Citizen getComplainer()
	{
		return Complainer;
	}

	public void setComplainer(Citizen complainer)
	{
		Complainer = complainer;
	}

	public String isStatus() 
	{
		return String.valueOf(Status);
	}

	public String getComplain() 
	{
		return Complain;
	}

	public void setComplain(String complain) 
	{
		Complain = complain;
	}
	public void updateStatus(int ID2) throws SQLException {
		// TODO Auto-generated method stub
		ComplaintDatabase New = new ComplaintDatabase();

    	System.out.println("I am in uodate Status COmplaint");
    	System.out.println(ID2);
    	New.Search(ID2);
		
	}
};
