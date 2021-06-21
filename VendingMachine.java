//Steven Toub
//slt82@drexel.edu
//Homework 3 --- Vending Machine

import java.util.Scanner;
import java.text.NumberFormat;

public class VendingMachine {

	public static void main(String[] args) {
	
	//all the variables for vending machine items
		String oneName = "Cookies";
		double onePrice = 2.25;
		String twoName = "Chips";
		double twoPrice = 1.75;
		String threeName = "Candy Bar";
		double threePrice = 1.25;
		String fourName = "Muffin";
		double fourPrice = 2.55;
		String fiveName = "Pretzels";
		double fivePrice = 1.55;
		String sixName = "Trail Mix";
		double sixPrice = 2.15;
		
	//variables for user Input
		int userSelect;
		double userPayment;
		
	//variable for storing the user's change or for storing how much more money is needed for an item
		double change;
	
	//Scanner for reading user input
		Scanner scan = new Scanner(System.in);
	
	//Formatter to ensure system output is in currency format
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
	//Title display output
		System.out.println("CS 570 Vending Machine");
		System.out.println("------------------------");
		
	//Vending machine item list
		System.out.println("1. " + oneName + " ----> $" + onePrice);
		System.out.println("2. " + twoName + " ----> $" + twoPrice);
		System.out.println("3. " + threeName + " ----> $" + threePrice);
		System.out.println("4. " + fourName + " ----> $" + fourPrice);
		System.out.println("5. " + fiveName + " ----> $" + fivePrice);
		System.out.println("6. " + sixName + " ----> $" + sixPrice);
		
	//Prompts for user input (item choice and amount of money inserted)
		System.out.print("Enter your item choice: ");
			
			userSelect = scan.nextInt();
			
			//Loop for determining if user input is a valid selection
			
			if (userSelect == 1 || userSelect == 2 || userSelect == 3 || userSelect == 4 || userSelect == 5 || userSelect == 6) {
				
				System.out.print("Enter how much money you're inserting: ");
				
			}
			
			//Error handling for when user selection is not an integer between 1 and 6
			else {
				System.out.print("Invalid Entry");
				
				System.exit(0);
			}
			
			//Proceeds to collect payment if input is deemed valid
			
			userPayment = scan.nextDouble();
			
	//if loops for detecting which item was selected and if enough money was inserted, provides change amount
	//or how much more money is required based on how much money the user inputs
	
	//loops for item One
		if(userSelect == 1 && userPayment >= onePrice) {
			
			change = (userPayment - onePrice);
			System.out.println("Thanks for selecting " + oneName + "! Your change is " + fmt.format(change));
		}
		
		else if(userSelect == 1 && userPayment < onePrice) {
			
			change = (onePrice - userPayment);
			System.out.print("You are " + fmt.format(change) + " short!");
		}
	
	//loops for item Two
		else if(userSelect == 2 && userPayment >= twoPrice) {
			
			change = (userPayment - twoPrice);
			System.out.println("Thanks for selecting " + twoName + "! Your change is " + fmt.format(change));
		}
		
		else if(userSelect == 2 && userPayment < twoPrice) {
			
			change = (twoPrice - userPayment);
			System.out.print("You are " + fmt.format(change) + " short!");
		}
		
	//loops for item Three
		else if(userSelect == 3 && userPayment >= threePrice) {
			
			change = (userPayment - threePrice);
			System.out.println("Thanks for selecting " + threeName + "! Your change is " + fmt.format(change));
		}
		
		else if(userSelect == 3 && userPayment < threePrice) {
			
			change = (threePrice - userPayment);
			System.out.print("You are " + fmt.format(change) + " short!");
		}
		
	//loops for item Four
		else if(userSelect == 4 && userPayment >= fourPrice) {
			
			change = (userPayment - fourPrice);
			System.out.println("Thanks for selecting " + fourName + "! Your change is " + fmt.format(change));
		}
		
		else if(userSelect == 4 && userPayment < fourPrice) {
			
			change = (fourPrice - userPayment);
			System.out.print("You are " + fmt.format(change) + " short!");
		}
	
	//loops for item Five
		else if(userSelect == 5 && userPayment >= fivePrice) {
			
			change = (userPayment - fivePrice);
			System.out.println("Thanks for selecting " + fiveName + "! Your change is " + fmt.format(change));
		}
		
		else if(userSelect == 5 && userPayment < fivePrice) {
			
			change = (fivePrice - userPayment);
			System.out.print("You are " + fmt.format(change) + " short!");
		}
		
	//loops for item Six
		else if(userSelect == 6 && userPayment >= sixPrice) {
			
			change = (userPayment - sixPrice);
			System.out.println("Thanks for selecting " + twoName + "! Your change is " + fmt.format(change));
		}
		
		else if(userSelect == 6 && userPayment < sixPrice) {
			
			change = (sixPrice - userPayment);
			System.out.print("You are " + fmt.format(change) + " short!");
		}
		
	}
}
