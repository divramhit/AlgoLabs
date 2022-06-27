
import java.util.Scanner;
import java.util.*;


public class LAB9QU1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1, 5, 70, 98, 4, 34, 102, 56, 23, 54};
		
		System.out.println("Displaying Contents of Array: ");
		for (int i = 0; i < arr.length; i ++)
		{
			System.out.println(arr[i]);
		}
		System.out.println("End of Contents of Array");
		
		selectionSort(arr);
		InsertionSort(arr);
	}
	public static void selectionSort(int arr[])
	{
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++)
		{
			int min_indx = i;
			for(int j = i + 1; j < n; j++)
			{
				if (arr[j] < arr[min_indx])
				{
					min_indx = j;
				}
	
			}
			
			int temp = arr[min_indx];
			arr[min_indx] = arr[i];
			arr[i] = temp;
		}
		
		
		System.out.println("Displaying Contents of Array After Selection Sort: ");
		for (int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + ",");
		}
		System.out.println("End of Contents of Array");
	}
	
	public static void InsertionSort(int arr[])
	{
		int n = arr.length;
		
		for(int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > key)
			{
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			
			arr[j + 1] = key;
		}
		
		System.out.println("Displaying Contents of Array After Insertion Sort: ");
		for (int i = 0; i < n; i++)
		{
			if (i < n - 1)
			{
				System.out.print(arr[i] + ",");
			}
			else
			{
				System.out.print(arr[i]);
			}
		}
		System.out.println("End of Contents of Array");
	}
}
