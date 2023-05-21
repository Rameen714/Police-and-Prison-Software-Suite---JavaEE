package next.Resource.bean;

public class Vehicle extends Resource
{
	private String vehicleType;

    public Vehicle(int resourceID, String name, boolean inUse) throws Exception
    {
		super(resourceID, name, inUse);
		// TODO Auto-generated constructor stub
	}
    @Override
	public boolean changeStatus()
    {
		// TODO Auto-generated method stub
		return false;
	}

	public String getVehicleType()
	{
		return vehicleType;
	}
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
	}

}
