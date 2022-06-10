//Lab 2 Ques 4
package ques4;

import java.util.Scanner;

public class ServicingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		servicing servicing_arr[] = new servicing[20];
		Scanner sc = new Scanner(System.in);
		
		int servNum = 0;
		String registrationNum, ownerName;
		double charge;
		
		for (int i = 0; i < 20; i++)
		{
			try
			{
				System.out.format("Enter Servivicing Number for servicing %d: ", i + 1);
				servNum = Integer.parseInt(sc.nextLine());			//This is how input should be taken for Numbers when there going to be followed by a string
			}
			catch (Exception e)
			{
				System.out.println(e + "\n" + e.getMessage());
			}
			
			System.out.format("Enter the Registration Number for Servicing %d: ", i + 1);
			registrationNum = sc.nextLine();
			
			System.out.format("Enter the Owner Name for Servicing %d: ", i + 1);
			ownerName = sc.nextLine();
			
			System.out.format("Enter the Charge for Servicing %d : ", i + 1);
			charge = sc.nextDouble();
			
			sc.nextLine(); //If try/catch doesn't want to be used, we can instead opt for sc.nextLin() which adds the \n in the memory to allow for the next numerical input
		}
	
		
		
	}

}
