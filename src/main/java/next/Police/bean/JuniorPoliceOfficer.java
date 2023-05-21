package next.Police.bean;

public class JuniorPoliceOfficer extends PoliceOfficer{

	public JuniorPoliceOfficer() {}
	public JuniorPoliceOfficer(String Name,String ID,String Password,String Rank) {
		this.name = Name;
		this.policeID = ID;
		this.password = Password;
		this.rank = Rank;
	}
	@Override
	public void viewPatrols() {
		// TODO Auto-generated method stub
		
	}

}
