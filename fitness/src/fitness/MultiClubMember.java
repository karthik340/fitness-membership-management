package fitness;

public class MultiClubMember extends Member {
	private int membershipPoints;
	public MultiClubMember(char pmemberType, int pmemberId, String pname, double pfees,int pmembershipPoints) {
		super(pmemberType, pmemberId, pname, pfees);
		// TODO Auto-generated constructor stub
		this.membershipPoints=membershipPoints;
	}
	public int getMembershipPoints() {
		return membershipPoints;
	}
	public void setMembershipPoints(int membershipPoints) {
		this.membershipPoints = membershipPoints;
	}
	public String toString()
	{
		return super.toString()+", "+membershipPoints;
	}

	
	
}
