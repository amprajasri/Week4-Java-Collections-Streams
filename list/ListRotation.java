import java.util.*;

public class ListRotation
{
	public static void main(String args[])
	{
		List<Integer> l=new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
		int num=2;
		Integer temp;
		for(int i=0;i<num;i++)
		{
			temp=l.remove(0);
			l.set(l.size()-1,temp);
		}
		System.out.println(l);
	}
}