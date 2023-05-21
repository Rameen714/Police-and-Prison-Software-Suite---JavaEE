package next.Resource.bean;

public class Resource {

	protected int resourceID;
	protected String name;
	protected boolean inUse;
	
	public Resource(int resourceID, String name, boolean inUse) throws Exception
	{
		this.resourceID = resourceID;
		this.name = name;
		this.inUse = inUse;
		
		ResourceDao D = new ResourceDao();
		D.Insert(this);

	}
	
	public Resource()
	{
		this.resourceID = 0;
		this.name = null;
		this.inUse = false;
	}
	
	public String getID()
	{
		return String.valueOf(resourceID);
	}
	
	public void setId(String Id)
	{
		if(Id != null)
			resourceID = Integer.valueOf(Id);
		resourceID = 0;
	}
	
	public void input()
	{
		

	}
	
	public boolean changeStatus()
	{
		return false;
	}
}
