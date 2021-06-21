//Loan Payment Calculator
//Steven Toub
//slt82@drexel.edu
//CS570-900

//This program is slightly deficient without the use of if then statements. Should the user input a payment
//amount that is less than the accrued interest, the program displays the output strangely, since it cannot 
//detect that the monthly payment is less than the accrued interest.
//It still outputs the correct new loan balance in this circumstance.

import java.util.Scanner;

public class LoanPaymentCalculator
{

	public static void main(String[] args)
	{

		double principalBalance;
		double monthlyPayment;
		double interestAccruedMonthly;
		double interestPayment;
		double principalPayment;
		double newPrincipalBalance;

		System.out.println("This program calculates how much of your monthly loan payment goes "
					+ "to payment on your principal ");
		System.out.println("balance and how much goes towards accrued interest.");

	//This creates a break to make the output more readable.
		System.out.println("");

		Scanner scan = new Scanner(System.in);

	//User is prompted to input their principal balance and monthly payment amounts and program
	//transfers the input into the corresponding variables/rounds input to two decimal places
		
		System.out.print("Enter your principal balance: ");
			principalBalance = (((double)((int)(((scan.nextDouble()) + 0.005) * 100)))/100);

		System.out.print("Enter your monthly loan payment: ");
			monthlyPayment = (((double)((int)(((scan.nextDouble()) + 0.005) * 100)))/100);
		
	//This creates a break to make the output more readable.
		System.out.println("");

	//Algorithm for calculating the principal amount plus the interest accrued in one month.

		interestAccruedMonthly = ((principalBalance * 0.0451)/12);
	
	//Algorithms for calculating how much of the monthly payment goes towards interest
	// and how much then goes towards the principal. The results are rounded to two decimal places.
		
	        interestPayment = (((double)((int)((interestAccruedMonthly + 0.005) * 100)))/100);
		principalPayment = (((double)((int)(((monthlyPayment - interestAccruedMonthly) + 0.005) * 100)))/100);

	//Algorithm for determining the user's new principal balance on their loan. Result is rounded to
	//two decimal places

		newPrincipalBalance = (((double)((int)(((principalBalance - principalPayment) + 0.005) * 100)))/100);

	//Program displays the final calculations

		System.out.println("From your monthly payment of $" + monthlyPayment + ":");
		System.out.println("$" + interestPayment + " goes towards interest.");
		System.out.println("$" + principalPayment + " goes towards your principal balance.");
		System.out.println("Your new loan balance is: $" + newPrincipalBalance);
	
	}
}
	
	