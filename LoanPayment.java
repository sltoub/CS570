//Steven Toub
//slt82@drexel.edu
//Homework 4 -- Loan Payment Calculator

import java.util.Scanner;
import java.text.NumberFormat;

public class LoanPayment {
	
	public static void main(String[] args) {
		
		//variable for initialization and determining if user wants to run loop again
		char startUp = 'Y';
		
		//main while loop for initializing program and allowing user to run it more than once
		while(startUp == 'Y') {
			
			//Scanner and currency formatter
			Scanner scan = new Scanner(System.in);
			NumberFormat fmt = NumberFormat.getCurrencyInstance();
			
			//user input variables
			double amountBorrowed;
			double annualRate;
			double loanTerm;
			
			//variables calculated by program
			double amountOnPrincipal;
			double totalInterest = 0;
			double interest;
			double monthlyPayment;
			
			//Loop for determining principal balance
			do {
				
				System.out.print("What is your loan's principal amount? (Must be less than $1,000,000): ");
				amountBorrowed = scan.nextDouble();
				
				//prevents amount from being greater than 1 million dollars
				//these if statements in the do loops for getting user input run through the do loop
				//again if conditions are true
				if(amountBorrowed > 1000000) {
					
					System.out.println("Your loan principal must be less than $1,000,000!");
				}
				
				//prevents amount from being less than 0 dollars
				if(amountBorrowed <= 0) {
					
					System.out.println("Your loan principal must be greater than $0!");
				}
			}while (amountBorrowed <= 0 || amountBorrowed > 1000000);
			
			//loop for determining the interest rate. Accepts #.## format for ease of input, converts later
			do {
				
				System.out.print("What is your loan's annual interest rate?(2%-15%): ");
				annualRate = scan.nextDouble();
				
				//prevents rate from being greater than 15%
				if(annualRate > 15) {
					
					System.out.println("Your interest rate must be less than or equal to 15%.");
				}
				
				//prevents rate from being less than 2%
				if(annualRate < 2) {
					
					System.out.println("Your interest rate must be greater than or equal to 2%.");
				}
			}while(annualRate < 2 || annualRate > 15);
			
			//loop for determining how many years the loan is
			do {
				
				System.out.print("How many years are in your loan's term?: ");
				loanTerm = scan.nextDouble();
				
				//ensures the loan is not greater than 30 years
				if(loanTerm > 30) {
					
					System.out.println("Your loan's term cannot be greater than 30 years.");
				}
				
				//ensures loan is not less than 0 years
				if(loanTerm <= 0) {
					
					System.out.println("You loan's term must be greater than 0 years.");
				}
			}while(loanTerm <= 0 || loanTerm > 30);
			
			//Displays user input about loan
			System.out.println("Your loan is $" + amountBorrowed + " at %" + annualRate
								+ " for " + loanTerm + " years.");
			
			//takes user input and converts from #.## to mathematically useful monthly rate
			annualRate = ((annualRate / 100) / 12);
			
			//calculation for fixed monthly payment
			monthlyPayment = (amountBorrowed * annualRate) / (1 - (Math.pow((1 / (1 + annualRate)),(12 * loanTerm))));
			
			//displays fixed monthly payment
			System.out.println("Your monthly payment is " + fmt.format(monthlyPayment));
			
			//Prints info to organize future output
			System.out.println("");
			System.out.println(" Month   Interest   Principal");
			System.out.println("------------------------------");
			
			//month counter variable, initialized outside loop to prevent it from always being "1"
			int month = 1;
			
			//loop for calculating monthly payments on principal and interest;
			while(amountBorrowed > 0) {
				
				//calculations for interest, principal payment, and new principal
				interest = annualRate * amountBorrowed;
				amountOnPrincipal = monthlyPayment - interest;
				amountBorrowed = amountBorrowed - amountOnPrincipal;
					
				//condition checking statement to prevent extra month output after $0 condition met.
					if(amountBorrowed > 0) {
						
						//prints one line of updated output per iteration of loop/formats into readable pattern
						System.out.format("%-10d%-10.2f%-10.2f%n", month, interest, amountOnPrincipal);
					}
				
				//keeps track of total amount of interest paid for all iterations of loop
				totalInterest = totalInterest + interest;
				
				//adds one to the month counter at end of each iteration
				month++;			
				
			} 
			
			//Separates list of output from final output on total interest for easier to read output
			System.out.println("-------------------------------");
			System.out.println(fmt.format(totalInterest) + " in interest paid over span of loan.");
			
			//booleans for determining if user wants to run program again
			boolean yes;
			boolean no;
			
			//prepares input to read String
			scan.nextLine();
			
			//loop for determining if user wants to run the program again
			do
			{
			  System.out.print("Do any other loans require processing? (y/n) ") ;
			  
			  //scans first character to see if it is a y or n to determine user response
			  startUp = scan.nextLine().charAt(0); 
			  	
			  //if statement to convert lower case y's to upper case Y's to satisfy while loop condition
			  	if(startUp == 'y') {
			  		startUp = 'Y';
			  	}
			  	
			  // y or Y runs program again, n or N ends the main while loop.
			  yes = (startUp == 'Y' ) || (startUp == 'y' ) ;
			  no = (startUp == 'N' ) || (startUp == 'n' ) ;

			} while( !( yes || no )); //if user input is not approved y or n, asks for input again
			
			//adds a space before next output
			System.out.println(" ");
		} 
		
		//Output if user chooses to exit program
		System.out.println("Goodbye.");
		
	}
}
