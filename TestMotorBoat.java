//Steven Toub
//slt82@drexel.edu
//Homework 3 --- MotorBoat Class Tester
import java.text.DecimalFormat;

public class TestMotorBoat {

	public static void main(String[] args) {
		
		DecimalFormat fmt = new DecimalFormat("0.##");
		
		//Uses the MotorBoat constructor to create a new motor boat object
		MotorBoat boat = new MotorBoat();
		
		//Uses the method for adding fuel to the boat object
		boat.addFuel();
		
		//Uses changeSpeed() method to select travel speed
		boat.changeSpeed();
			
			System.out.println("Your current speed is: " + fmt.format(boat.getCurrentSpeed()) + " out of " 
							+ fmt.format(boat.getMaximumSpeed()) + " miles per hour.");
			System.out.println("Your current fuel amount is: " + fmt.format(boat.getFuelAmount())
							+ " out of " + fmt.format(boat.getTankCapacity()) + " gallons.");
	
		//Runs the operateBoat() method to finish out the program			
		boat.operateBoat();
			
	}

}