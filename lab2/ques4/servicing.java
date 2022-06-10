//A garage needs to store information about the services it provides for vehicles. For each servicing it
//performs in a day, it wishes to store the servicing number, the registration number of the vehicle, the name
//of the vehicle owner and the cost of the servicing.
//i. Create a class Servicing with the following attributes:
// servicingNum (int)
// registrationNum (String)
// ownerName (String)
// charge (double)
//and the following methods:
// Default constructor.
// Accessor and mutator methods for each of the attributes.
// Method toString to make it easier to display details pertaining to one servicing object.
//ii. Define a class ServicingApplication with a main method that declares an array for storing information
//of up to 20 servicing objects. The program must then display a menu that allows a user to choose one
//of the following:
// Create a new servicing object.
// To enter a servicing number and the program displays all information for the corresponding
//servicing object.
// To display of the average charge for servicing objects in the array.
//The program should then perform the task chosen by the user. An option should also be provided to
//exit the program.
package ques4;

public class servicing {
	private int servicingNum;
	private String registrationNum;
	private String ownerName;
	private double charge;
	
	public servicing() {
		this.servicingNum = 000000;
		this.registrationNum = "A0000";
		this.ownerName = "Xavier";
		this.charge = 0;
	}
	
	public int getsevicingNum() {
		return this.servicingNum;
	}
	
	public void setservicingNum(int servicingNum) {
		this.servicingNum = servicingNum;
	}
	
	public String getregistrationNum() {
		return this.registrationNum;
	}
	
	public void setregistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	
	public String getownerName() {
		return this.ownerName;
	}
	
	public void setownerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public double getcharge() {
		return this.charge;
	}
	
	public void setcharge(double charge) {
		this.charge = charge;
	}
	
	public String toString() {
		String output = "";
		output = "\n\tServicing Number: " + this.servicingNum + "\n\tRegistration Number: " + this.registrationNum + "\n\tOwner Name: " + this.ownerName + "\n\tCharge: " + this.charge + "\n";
		return output;
	}
	
}
