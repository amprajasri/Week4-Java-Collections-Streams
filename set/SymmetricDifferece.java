import java.util.*;

public class SymmetricDifferece
{
	public static void main(String args[])
	{
	Set<Integer> s1=new HashSet<>(Arrays.asList(1,2,3));
	Set<Integer> s2= new HashSet<>(Arrays.asList(3,4,5));
	Set<Integer> union=new HashSet<>(s1);
	Set<Integer> intersection =new HashSet<>(s1);
	Set<Integer> difference =new HashSet<>(union);
	union.addAll(s2);
	intersection.retainAll(s2);
	union.removeAll(intersection);
	System.out.println(union);
	}
}