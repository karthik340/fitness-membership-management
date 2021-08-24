package fitness;

public class SingleClubMember extends Member {
	private int club;

	public SingleClubMember(char pmemberType, int pmemberId, String pname, double pfees, int club) {
		super(pmemberType, pmemberId, pname, pfees);
		this.club = club;
	}

	public int getClub() {
		return club;
	}

	public void setClub(int club) {
		this.club = club;
	}
	
	public String toString()
	{
		return super.toString()+", "+club;
	}

}
