import java.util.*;
public class SortedList
{
	public static void main(String args[])
	{
		Set<Integer> s=new HashSet<>(Arrays.asList(5, 3, 9, 1));
		Set<Integer> newset=new LinkedHashSet<>(s);
		System.out.println(newset);
	}
}