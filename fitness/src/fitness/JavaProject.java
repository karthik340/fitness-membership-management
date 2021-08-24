package fitness;
import java.util.*;
public class JavaProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mem;
		MembershipManagement mm= new MembershipManagement();
		FileHandler fh=new FileHandler();
		LinkedList<Member> members=fh.readFile();
		int choice=mm.getChoice();
		
		while(choice!=-1)
		{
			switch(choice)
			{
			case 1:
				mem= mm.addMembers(members);
				fh.appendFile(mem);
				break;
			case 2:
				mm.removeMember(members);
				fh.overWrite(members);
				break;
			case 3:
				mm.printMemberInfo(members);
				break;
			default:
				System.out.println("Invalid Option is chosen\n\n");
			}
			choice=mm.getChoice();
		}
		System.out.println("Good Bye!");

	}

}
