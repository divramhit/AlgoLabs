package ques1;
import java.util.Map;
import java.util.HashMap;

public class majorityhashmap {
	public static int checkMajorityElement(int arr[], int N) {
		//arr[]  is the array in which the majority element must be found and N is the size of the array 
		
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++)
		{
			if(mp.containsKey(arr[i])) {
				mp.put(arr[i], mp.get(arr[i]) + 1);
			}
			else
			{
				mp.put(arr[i], 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			if (entry.getValue() > (N / 2))
			{
				return entry.getKey();
			}
		}
		
		return -1;
	}

}
