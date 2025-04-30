import java.util.*;

public class FrequencyCount
{
	public static void getFrequency(Map<String,Integer> frequncyMap , List<String> fruits )
	{
		for(String fruit: fruits)
		{
			frequncyMap.put(fruit,frequncyMap.getOrDefault(fruit,0)+1);
		}
	}
	public static void main(String args[])
	{
		Map<String,Integer> frequncyMap=new HashMap<>();
		List<String> fruits=new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange"));
		getFrequency(frequncyMap,fruits);
		System.out.println(frequncyMap);
	}
}