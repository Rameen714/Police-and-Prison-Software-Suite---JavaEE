package next.Cell.bean;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.SQLException;
import next.Prisoner.bean.Prisoner;

public class Cell 
{
	
	private int cellId;
	private boolean occupied;
	private ArrayList <Prisoner> prisoners;
	
	public Cell()
	{
		cellId = -1;
		occupied = false;
		prisoners = new ArrayList<>();
	}
	
	public boolean input(boolean s, ArrayList <Prisoner> p) throws SQLException
	{
		cellId = ThreadLocalRandom.current().nextInt();
		occupied = s;
		prisoners = p;
		
		return true;
	}
	
	public boolean addPrisoner(Prisoner p)
	{
		prisoners.add(p);
		occupied = true;
		
		return true;
	}
	
	public boolean releasePrisoner(String releaseCNIC) throws SQLException
	{
		boolean res = false;
		CellDatabase cell = new CellDatabase();
		res = cell.releaseP(releaseCNIC);
		return res;
	}
	
	public int getCellID()
	{
		return cellId;
	}
	
	public boolean getOccupied()
	{
		return occupied;
	}
	
	public void getPrisoners(ArrayList<Prisoner> list) throws SQLException 
	{
		CellDatabase New = new CellDatabase();
		New.Display(list);
	}
}

