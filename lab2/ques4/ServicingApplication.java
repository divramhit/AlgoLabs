//Lab 2 Ques 4
package ques4;

import java.util.Scanner;

public class ServicingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		servicing servicing_arr[] = new servicing[20];
		Scanner sc = new Scanner(System.in);
		
		int choice, i;
		choice =0; i =0;
		int servNum = 0;
		String registrationNum, ownerName;
		double charge;
		
		for (int n =0; n < 20; n++) {
			servicing_arr[i] = new servicing();
		}
		
		while (choice != 4)
		{
			System.out.format("--------------------Main Menu--------------------\n\t1. Create New Servicing Object\n\t2. Enter a servicing number and display all its Info\n\t3.Display average charge for Servicing objects in the array\n\t4. Exit\n-------------------------------------------------\n");
			System.out.print("Enter your choice --> ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
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
				
				
				//Inserting values into the array
				System.out.println("Inserting Values into Array....");
				try {
					servicing_arr[i].setservicingNum(servNum);
					servicing_arr[i].setregistrationNum(registrationNum);
					servicing_arr[i].setownerName(ownerName);
					servicing_arr[i].setcharge(charge);
				}
				catch (Exception e) {
					System.out.println(e + "\n" + e.getMessage());
				}
				finally {
					System.out.println("Values successfully inserted.");
				}
					
				break;
				
			case 2:
				System.out.format("Enter Servincing Number:");
				servNum = sc.nextInt();
				sc.nextLine();
				
				for(int j = 0; j < 20; j++) {
					if (servicing_arr[j].getsevicingNum() == servNum) {
						System.out.println(servicing_arr[j].toString());
						break;
					}
				}
				break;
				
			case 3:
				double sum = 0.0;
				int objNum = 0;
				for(int k = 0; k < 20; k++) {
					if (servicing_arr[k] != null)
					{
						sum+=servicing_arr[k].getcharge();
						objNum++;
					}
					
				}
				
				System.out.format("Average charge in Array is : Rs %.2f \n", (sum/objNum));
				break;
				
			case 4:
				System.out.println("Exiting Application.....");
				System.exit(0);
			}
		}
		
		
		
	}
	

}
