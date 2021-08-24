package fitness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class FileHandler {
	public LinkedList<Member> readFile()
	{
		
		String line;
		LinkedList<Member> members=new LinkedList();
		String words[];
		Member mem;
		
		try(BufferedReader reader=new BufferedReader(new FileReader("members.csv"))){
			line=reader.readLine();
			while(line!=null)
			{
				words=line.split(", ");
				
				if(words[0].equals("S"))
				{
					mem=new SingleClubMember('S',Integer.parseInt(words[1]),words[2],Double.parseDouble(words[3]),Integer.parseInt(words[4]));
				}
				else
				{
					mem=new MultiClubMember('M',Integer.parseInt(words[1]),words[2],Double.parseDouble(words[3]),Integer.parseInt(words[4]));
				}
				
				members.add(mem);
				line=reader.readLine();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return members;
	}
	public void appendFile(String line)
	{
		try(BufferedWriter writer=new BufferedWriter(new FileWriter("members.csv",true))){
			writer.write(line+"\n");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void overWrite(LinkedList<Member> m)
	{
		try(BufferedWriter writer=new BufferedWriter(new FileWriter("dummy.csv",false))){
			for(Member a:m)
			{
				writer.write(a.toString()+"\n");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		File oldF=new File("dummy.csv");
		File newF=new File("members.csv");
		oldF.renameTo(newF);
		newF.delete();
	}
}
