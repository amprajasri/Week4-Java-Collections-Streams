import java.util.*;

public class RemoveDuplicate
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		int n=input.nextInt();
		for(int i=0;i<n;i++)
		{
			list.add(input.nextInt());
		}
		ArrayList<Integer> output=new ArrayList<>();
		for(Integer num: list)
		{
			if(!output.contains(num)) output.add(num);
		}
		System.out.println(output);
	}
}