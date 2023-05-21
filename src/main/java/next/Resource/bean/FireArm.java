package next.Resource.bean;

public class FireArm extends Resource 
{
	//data members
	private String firearmType;
	//class methods
	public FireArm(int resourceID, String name, boolean inUse) throws Exception 
	{
		super(resourceID, name, inUse);
	}
	@Override
	public boolean changeStatus() 
	{
		// TODO Auto-generated method stub
		return false;
	}
	//setter getter
	public String getFirearmType() 
	{
		return firearmType;
	}
	public void setFirearmType(String firearmType) 
	{
		this.firearmType = firearmType;
	}

}
