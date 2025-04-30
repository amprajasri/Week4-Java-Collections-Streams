import java.util.*;

public class ListReversal
{

	public static <T> void reverseList(List<T> list)
	{
		int start=0;
		int end=list.size()-1;
		while(start<end)
		{
			T temp=list.get(start);
			list.set(start,list.get(end));
			list.set(end,temp);
			start++;
			end--;
		}
	}
	
	public static void main(String args[])
	{
		List<Integer> l1 =new ArrayList<> (Arrays.asList(10,20,30));
		List<Integer>l2 =new LinkedList<>  (Arrays.asList(50,60,70));
		System.out.println("original arrayList:"+l1);
		System.out.println("original LinkedList:"+l2);
		reverseList(l1);
		reverseList(l2);
		System.out.println("reversed arrayList:"+l1);
		System.out.println("reversed LinkedList:"+l2);
	}
}