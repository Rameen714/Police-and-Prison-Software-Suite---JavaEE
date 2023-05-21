package next.Patrol.bean;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import next.Police.bean.JuniorPoliceOfficer;
import next.Police.bean.PoliceOfficer;
import next.citizen.bean.Citizen;

public class Patrol 
{
	
	private String ID;
	private LocalDate  dateOfPatrol;
	private LocalTime startTime;
	private LocalTime endTime;
	private String JPOName;
	private String JPOID;

	
	public Patrol()
	{
        int int_random = ThreadLocalRandom.current().nextInt();  
        this.ID = String.valueOf(int_random); 
		this.dateOfPatrol = null;
		this.startTime = null;
		this.endTime = null;
		this.JPOName = null;
		this.JPOID = null;
	}
	
	public Patrol(String  dateOfPatrol, String startTime, String endTime, String JPOName, String JPOID)
	{
		System.out.println("I am in Patrol");
        int int_random = new Random(). nextInt((30 - 20) + 1) + 20;
        //	ThreadLocalRandom.current().nextInt();  
        this.ID = String.valueOf(int_random); 
		System.out.println("ID");
        this.dateOfPatrol = LocalDate.parse(dateOfPatrol);
		System.out.println("date");
		this.startTime = LocalTime.parse(startTime);
		System.out.println("starttime");
		this.endTime = LocalTime.parse(endTime);
		System.out.println("endtime");
		this.JPOName = JPOName;
		System.out.println("JPONAME");
		this.JPOID = JPOID;
		System.out.println("JPOID");
	}
	
	public String getID()
	{
		return ID;
	}
	
	public String getDateOfPatrol()
	{
		return dateOfPatrol.toString();
	}
	
	public String getStartTime()
	{
		return startTime.toString();
	}
	
	public String getEndTime()
	{
		return endTime.toString();
	}
			
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public void setLocalDate(String dateOfPatrol)
	{
		this.dateOfPatrol = Date.valueOf(dateOfPatrol).toLocalDate();
	}
	
	public void setStartTime(String startTime)
	{
		this.startTime = Time.valueOf(startTime).toLocalTime();
	}
	
	public void setEndTime(String endTime)
	{
		this.endTime = Time.valueOf(endTime).toLocalTime();
	}
	
	public void setAppointeeName(String Name)
	{
		this.JPOName = Name;
	}
	
	public void setAppointeeID(String ID)
	{
		this.JPOID = ID;
	}
	
	public boolean input(LocalDate  dateOfPatrol, LocalTime startTime, LocalTime endTime, String JPOName, String JPOID, String JPORank)
	{
        int int_random = ThreadLocalRandom.current().nextInt();  
        this.ID = String.valueOf(int_random);   
    	this.dateOfPatrol = dateOfPatrol ;
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.JPOName = JPOName;
    	this.JPOID = JPOID;
    	
    	//PatrolDao NEWPATROL = new PatrolDao();
    	//boolean a = NEWPATROL.update(this);
    	//return a;
    	return true;
	}
	
	public boolean viewSchedule() throws SQLException
	{
		//PatrolDao PDBObj = new PatrolDao();		
		List<Patrol> list = new ArrayList();
		//list = PDBObj.display(JPOName, JPOID, JPORank);
		
		if(list == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}

	public String getJPOName() {
		// TODO Auto-generated method stub
		return this.JPOName;
	}

	public String getJPOID() {
		// TODO Auto-generated method stub
		return this.JPOID;
	}
}