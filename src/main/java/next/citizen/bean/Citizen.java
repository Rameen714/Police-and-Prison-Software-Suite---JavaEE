package next.citizen.bean;

import java.sql.SQLException;

import next.Appointment.bean.Appointment;
import next.FIR.bean.FIR;
import next.Token.bean.Token;
import next.complaint.bean.Complaint;

public class Citizen
{
	private String Name;
	private String CNIC;
	
	public Citizen()// default constructor
	{
		this.Name=null;
		this.CNIC=null;
	}
	
	public Citizen(String Name, String CNIC)// overloaded constructor
	{
		this.Name=Name;
		this.CNIC = CNIC;
	}
	
	public boolean File_FIR(String RAName, String DES) throws SQLException // must create a FIR and store it in DB
	{
		
		 FIR NewFIR = new FIR();
		 boolean fire = NewFIR.Input(this, RAName, DES);
		 return fire;
	}
	
	public boolean File_Complain(String Des) throws SQLException// create Compalain and Store it in DB
	{
		Complaint NewComplaint = new Complaint();
		boolean IsFiled = NewComplaint.Input(this , Des);
		return IsFiled;
	}
	
	public boolean Set_Appointment(String date, String time, String WName) throws SQLException// create Appointment obj fill and store in DB
	{
		Appointment NewAppointment= new Appointment();
		
		boolean IsFiled= NewAppointment.input(this, date, time , WName );
		
		return IsFiled;
	}
	
	public Token Get_VisitingToken() throws SQLException// create token obj and return
	{
		Token NewToken= new Token();
		NewToken.input();
		
		return NewToken;
	}

	public String getCNIC() 
	{
		return CNIC;
	}

	public void setCNIC(String cNIC)
	{
		CNIC = cNIC;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String name) 
	{
		Name = name;
	}
};
