package fitness;
import java.util.*;
public class MembershipManagement {
	final private Scanner reader=new Scanner(System.in);
	private int getIntInput()
	{
		int choice =0;
		while(choice==0)
		{
			try{
				choice=reader.nextInt();
				if(choice==0)
				{
					throw new InputMismatchException();
				}
				reader.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.out.println("ERROR: INVALID INPUT. Please try again:");
			}
		}
		return choice;
	}
	
	private void printClubOptions()
	{
		System.out.println("1) Club Mercury \n2) Club Neptune \n3) Club Jupiter \n4) Multi Clubs");
	}
	
	public int getChoice()
	{
		int choice;
		System.out.println("WELCOME TO OZONE FITNESS CENTER");
		System.out.println("================================");
		System.out.println("1) Add Member");
		System.out.println("2) Remove Member");
		System.out.println("3) Display Member Information");
		System.out.println("Please select an option (or Enter -1 to quit):");
		choice=getIntInput();
		return choice;
	}
	
	public String addMembers(LinkedList<Member> m)
	{
		String name;
		int club;
		String mem;
		double fees;
		int memberId;
		Member mbr;
		Calculator<Integer> cal;
		System.out.println("Enter Members Name : ");
		name=reader.nextLine();
		
		printClubOptions();
		club=getIntInput();
		
		while(club<1||club>4)
		{
			System.out.println("entered value is invalid : ");
			printClubOptions();
			club=getIntInput();
		}
		if(m.size()>0)
			memberId=m.getLast().getMemberId()+1;
		else
			memberId=1;
		if(club!=4)
		{
			cal = (n) -> {
				switch(n)
				{
					case 1:
						return 900;
					case 2:
						return 950;
					case 3:
						return 1000;
					default:
						return -1;
				}
			};
			fees=cal.calculateFees(club);
			mbr=new SingleClubMember('S', memberId, name, fees, club);
			m.add(mbr);
			mem=mbr.toString();
			System.out.println("\nSTATUS: Single Club Member added\n");
		}
		else
		{
			cal = (n) -> {
				switch(n)
				{
				case 4:
					return 1200;
				default:
					return -1;
				}
			};
			fees=cal.calculateFees(club);
			mbr=new MultiClubMember('M', memberId, name, fees, 100);
			m.add(mbr);
			mem=mbr.toString();
			System.out.println("\nSTATUS: Multi Club Member added\n");
		}
		return mem;
	}
	
	public void removeMember(LinkedList<Member> m)
	{
		int memberId;
		System.out.println("Enter Member Id to be removed: ");
		memberId=getIntInput();
		for(int i=0;i<m.size();i++)
		{
			if(m.get(i).getMemberId()==memberId)
			{
				m.remove(i);
				System.out.println("Member is removed successfully");
				return;
			}
		}
		System.out.println("Member Id not found");
	}
	
	public void printMemberInfo(LinkedList<Member> m)
	{
		int memberId;
		System.out.println("Enter Member Id of member to be printed: ");
		memberId=getIntInput();
		
		for(int i=0;i<m.size();i++)
		{
			if(m.get(i).getMemberId()==memberId)
			{
				String[] memberInfo = m.get(i).toString().split(", ");
				System.out.println("Member Type = "+memberInfo[0]);
				System.out.println("Member Id = "+memberInfo[1]);
				System.out.println("Member Name = "+memberInfo[2]);
				System.out.println("Membership Fees = "+memberInfo[3]);
				if(memberInfo[0]=="S")
				{
					System.out.println("Club Id = "+memberInfo[4]);
				}
				else
				{
					System.out.println("Membership Points = "+memberInfo[4]);
				}
				return;
			}
		}
		System.out.println("Member Id not found");
	}
	
	
}
