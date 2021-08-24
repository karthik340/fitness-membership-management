package fitness;

public class Member {
	private char memberType;
	private int memberId;
	private String name;
	private double fees;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public char getMemberType() {
		return memberType;
	}
	public void setMemberType(char memberType) {
		this.memberType = memberType;
	}
	public Member(char pmemberType,int pmemberId,String pname,double pfees) {
		// TODO Auto-generated constructor stub
		memberType= pmemberType;
		memberId=pmemberId;
		name=pname;
		fees=pfees;
	}
	public String toString()
	{
		return memberType+", "+memberId+", "+name+", "+fees;
	}
	
	
}
