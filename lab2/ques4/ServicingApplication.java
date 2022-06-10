package ques4;

import java.util.Scanner;

public class ServicingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		servicing servicing_arr[] = new servicing[20];
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your Number of objects: ");
		try {
		    int size = Integer.parseInt(sc.nextLine());		//This is how we should be taking input and using nextLine, nextInt, nextDouble with each other in a loop or one after the other.
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
		
	}

}
