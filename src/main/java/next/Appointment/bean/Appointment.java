package next.Appointment.bean;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

import next.citizen.bean.Citizen;
public class Appointment // we need to add appointment with here
{
	private LocalDate AppDate;
    private LocalTime AppTime;
    private int AppointmentId;
    private Citizen AppHolder;
    private String AppointmentWith;
    
    public Appointment()
    {
        AppDate = null;
        AppTime = null;
        AppointmentId = 0;
        AppHolder = null;
    }

    public boolean input(Citizen Holder, String Date , String Time , String AppWith) throws SQLException // setter
    {
        this.AppHolder = Holder;
        this.AppDate = LocalDate.parse(Date);
        this.AppTime = LocalTime.parse(Time);
        this.AppointmentWith = AppWith;
        
        AppointmentDatabase  NewAppointment = new AppointmentDatabase();
        boolean isSet = NewAppointment.Insert(this);
        return isSet;
    }

	public String getAppDate() 
	{
		return AppDate.toString();
	}

	public String getAppTime() 
	{
		return AppTime.toString();
	}

	public String getAppointmentId() 
	{
		return Integer.toString(AppointmentId);
	}

	public Citizen getAppHolder() 
	{
		return AppHolder;
	}

	public String getAppointmentWith()
	{
		return AppointmentWith;
	}

}
