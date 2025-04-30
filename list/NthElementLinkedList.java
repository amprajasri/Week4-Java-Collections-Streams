import java.util.*;
public class NthElementLinkedList
{
	public static void main(String args[])
	{
		List<String> list=new LinkedList <>(Arrays.asList("A", "B", "C", "D", "E"));
		int n=2;
		Iterator<String> i1=list.iterator();
		Iterator<String> i2=list.iterator();
		for(int i=0;i<n;i++)
		{
			i1.next();
		}
		
		while(i1.hasNext())
		{
			i1.next();
			i2.next();
		}
		System.out.println(i2.next());
	}
}