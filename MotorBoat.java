//Steven Toub
//slt82@drexel.edu
//Homework 3 --- MotorBoat Class

import java.text.DecimalFormat;
import java.util.Scanner;

public class MotorBoat {

	double tankCapacity; //Fuel tank capacity in gallons
	double fuelAmount;   //Amount of fuel currently in the boat in gallons
	double maximumSpeed; //Measured in miles per hour
	double currentSpeed; //Current speed of the boat in miles per hour
	double gasMileage;   //Efficiency of the engine, measured by gallons/mile
	double distanceTraveled; //distance traveled in miles
	double timeTraveled; //Amount of time traveled, input in hours
	double fuelAdded; //Variable for calculating how much fuel is added to fuelAmount
	double fuelUsed; //Variable for calculating how much fuel should be subtracted after travel
	double changeSpeed; //variable for comparing user input and ensuring it's not faster than maximumSpeed
	
	
	Scanner scan = new Scanner(System.in);
	
	DecimalFormat fmt = new DecimalFormat("0.##");
	
	//MotorBoat Constructor class
	//Accepts input values for boat attributes, sets all other MotorBoat() variables to zero.
	
		MotorBoat(){
			
			System.out.println("Enter your boat specs:");
			
			System.out.print("Enter your boat's fuel tank capacity (gal): ");
				
				tankCapacity = scan.nextDouble();
				
			System.out.print("Enter your boat's maximum speed (mph): ");
					
				maximumSpeed = scan.nextDouble();
				
			System.out.print("Enter your boat's fuel efficiency rate (gal/mile): ");
			
				gasMileage = scan.nextDouble();
				
			//values modifies by other methods are set to zero
				fuelAmount = 0;
				currentSpeed = 0;
				distanceTraveled = 0;		
		}
		
		//method for changing the speed of the boat/contains error processing if entered speed
		//is higher than the boat was created to be capable of.
	
		public void changeSpeed() {
			
			System.out.print("Enter new speed: ");
			
			changeSpeed = scan.nextDouble();
			
			if(changeSpeed <= maximumSpeed) {
				
				currentSpeed = changeSpeed;
			}
			
			//Error handling for when selected speed is higher than object is capable of
			//Inputs maximum speed instead
			else if(changeSpeed > maximumSpeed) {
				
				System.out.print("Your boat cannot go that fast! ");
				
				currentSpeed = maximumSpeed;
				
				System.out.println("Your boat will travel at its maximum speed instead.");
			}
			
		}
		
		//method for adding fuel to the boat/ contains error processing for instances where fuel
		//addition is greater than the capacity of the boat
		
		public void addFuel() {
			
			System.out.print("How much fuel are you adding?: ");
			
			fuelAdded = scan.nextDouble();
			
			if(fuelAdded <= tankCapacity - fuelAmount) {
				
				fuelAmount = (fuelAmount + fuelAdded);
				
				System.out.print("You have " + fmt.format(fuelAmount) + " gallons in your tank. ");
			}
			
			//Error handling for if user adds too much fuel. Simply tops off tank instead.
			else if(fuelAdded > tankCapacity - fuelAmount) {
				
				System.out.print("That's too much fuel! ");
				
				fuelAmount = tankCapacity;
				
				System.out.println(" Your tank has been filled to capacity instead.");
				System.out.println("You have " + fmt.format(fuelAmount) + " gallons in your tank.");
			}
			
		}
		
		//INSPECTOR METHODS for returning object data
			
		public double getDistanceTraveled() {
			
			return (distanceTraveled);
		}
		
		public double getFuelAmount() {
			
			return fuelAmount;
		}
		
		public double getCurrentSpeed() {
			
			return currentSpeed;
		}
		
		public double getMaximumSpeed() {
			
			return maximumSpeed;
		}
		
		public double getTankCapacity() {
			
			return tankCapacity;
		}
			
		//the operate boat method accepts input on travel time, calculates the distance traveled,
		//the amount of fuel consumed, the amount of fuel left in the tank, and determines if the
		//boat needs to refuel before making the trip back. Outputs this data to the user.
		
		public void operateBoat() {
			
			System.out.print("How many hours would you like to travel?: ");
			
				timeTraveled = scan.nextDouble();
				
				distanceTraveled = timeTraveled * currentSpeed;
				
				fuelUsed = (gasMileage * distanceTraveled);
				
				//If the user selects a travel time that exceeds the capabilities of the boat object
				//produces error message
				if(fuelUsed >= fuelAmount) {
					
					System.out.println("You don't have enough fuel to travel that long.");
				}
				
				//This section of the method handles scenarios where the boat has enough fuel to get
				//back without refueling
				else if(fuelUsed < (0.5 * fuelAmount)) {
					
					fuelAmount = fuelAmount - fuelUsed;
					
					System.out.println("After traveling for " + fmt.format((timeTraveled * 60)) + " minutes, you have traveled "
									+ fmt.format(getDistanceTraveled()) + " miles and have " 
									+ fmt.format(getFuelAmount()) + " gallons of fuel left.");
					
					System.out.println("You have enough fuel for the trip back.");
					
				}
				
				//This section handles scenarios where the boat runs, but does not have enough fuel
				//to get back and needs to refuel/prompts user to use addFuel() method
				else if(fuelUsed >= (0.5 * fuelAmount)) {
					
					fuelAmount = fuelAmount - fuelUsed;
					
					System.out.println("After traveling for " + fmt.format((timeTraveled * 60)) + " minutes, you have traveled "
							+ fmt.format(getDistanceTraveled()) + " miles and have " + fmt.format(getFuelAmount()) + " out of " 
							+ fmt.format(getTankCapacity()) + " gallons of fuel left.");
					
					System.out.print("You need to refuel! ");
					
					//invokes addFuel method() so user can add enough fuel to fulfill return
					//requirements
					addFuel();
						
					if(fuelAmount >= fuelUsed) {
							
						System.out.println("You have enough fuel for the trip back.");
					}
						
				//Error handling for when added fuel amount is not sufficient for trip back
					else {
							
						System.out.println("That won't be enough fuel to get back.");
					}
					
				}
			
		}
		
}
