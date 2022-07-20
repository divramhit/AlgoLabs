package QU1;
//Using DC for Max-Min Problem
import java.util.Scanner;

public class LAB10QU1 {
	
	static Scanner sc = new Scanner(System.in);
	
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int a[];
	static int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter Size of array: ");
		size = sc.nextInt();
		
		a = new int[size];
		
		inputArray();
		MaxMin(0 , size - 1 );
		
		System.out.println("Max Value : " + max + "\nMin Value : " + min);
	}
	
	public static void MaxMin(int i, int j)
	{
		int max1, min1, mid;
		
		if(i == j)
		{
			max = min = a [i];
		}
		else
		{
			if (i == j - 1)
			{
				if (a[i] < a[j])
				{
					max = a[j];
					min = a [i];
				}
				else
				{
					max = a[i];
					min = a [j];
				}
			}
			else
			{
				mid = (i + j) / 2;
				MaxMin(i, mid);
				
				max1 = max;
				min1 = min;
				MaxMin(mid + 1, j);
				if(max < max1)
				{
					max = max1;
				}
				
				if(min > min1)
				{
					min = min1;
				}
			}
		}
	}
	
	public static void inputArray()
	{
		for (int i = 0; i < size; i++)
		{
			a[i] = sc.nextInt();
		}
	}

}
