//Shipping Charges Calculator
//Steven Toub
//slt82@drexel.edu
//CS570-900

import java.util.Scanner;

public class ShippingCalculator
{

	public static void main(String[] args)
	{
		double packageWeight;
		double costPerPound;
		double shippingCost;
		
		System.out.println("This program calculates your shipping cost based on the package's "
					+ "weight and the cost of shipping per pound.");
	
	//Clears a line to make the program more readable
		System.out.println("");

		Scanner scan = new Scanner(System.in);

	//User prompted to input their package's weight and the cost of shipping per pound/program rounds input
	//to two decimal places.

		System.out.print("Enter your package's weight in pounds: ");
			packageWeight = ((double)((int)(((scan.nextDouble())+.005)*100))/100);
;
	
		System.out.print("Enter the shipping cost per pound: ");
			costPerPound = ((double)((int)(((scan.nextDouble())+.005)*100))/100);

	//Algorithm for calculating the cost of shipping. Rounds the result to two decimal places.

		shippingCost = ((double)((int)(((packageWeight*costPerPound)+.005)*100))/100);

	//Clears a line to separate the output from the input lines
	//Program displays all input information and the result of the shipping calculator algorithm
		
		System.out.println("");
		System.out.println("Package weight: " + packageWeight + " pounds");
		System.out.println("Cost of shipping per pound: $" + costPerPound);
		System.out.println("It will cost $" + shippingCost + " to ship your package.");
	}
}