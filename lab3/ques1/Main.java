//Given an array of integers containing duplicates, return the majority element in the array, if present. A
//majority element appears more than n/2 times where n is the size of the array.
//For example: the majority element is 2 in the array {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}.
package ques1;
import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayNum = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
		
		int N = arrayNum.length;
		
		System.out.print("This is the array --> ");
		System.out.print("{");
		for (int i = 0; i < N; i++)
		{
			if (i == (N-1))
			{
				System.out.format("%d", arrayNum[i]);
			}
			else
			{
				System.out.format("%d,", arrayNum[i]);
			}
		}
		System.out.println("}");
		
		majorityhashmap majoH = new majorityhashmap();
		int ans = majoH.checkMajorityElement(arrayNum, N);
		if (ans != -1)
		{
			System.out.println("Majority Element is: " + ans);
		}
		else
		{
			System.out.println("No majority element found.");
		}
	}

}
