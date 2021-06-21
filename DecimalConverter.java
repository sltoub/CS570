//Steven Toub
//slt82@drexel.edu
//Homework 4 -- Decimal to Binary Converter

import java.util.Scanner;

public class DecimalConverter {
	
	//method for converting decimal numbers to binary numbers through recursion
	public static void ConvertToBinary(int n) {
		
		//base case is 0
		//if n is greater than base case, recursive method runs again again
		if(n > 0) {
			
			//recursive statement, taking input and dividing by two each iteration
			ConvertToBinary(n / 2);
			
			//prints the remainder of n/2, which produces a remainder of either 1 or 0
			System.out.print(n % 2);
		}
	}
	
	public static void main(String[] args) {
		
		//initialize scanner and input variable for user input
		Scanner scan = new Scanner(System.in);
		int userInput;
		
		//variable for initializing main loop
		char startUp = 'y';
		
		//main loop
		while(startUp == 'y') {
			
			//asks user for input and scans input
			System.out.print("Enter a positive integer or 0 to terminate program: ");
			userInput = scan.nextInt();
			
			//loop for ensuring input is positive integer
			do{
				
				//less than zero repeats loop asking for input/zero terminates program
				if(userInput < 0) {
					
					System.out.println("You need to input a positive integer.");
					
					//asks the user for new input
					System.out.println("Enter a positive integer or 0 to terminate program: ");
					userInput = scan.nextInt();
				}
			
			}while(userInput < 0);
			
			//initiates recursive decimal converter if user's input if positive integer
			if (userInput > 0) {
				
			System.out.print(userInput + " in binary is ");
			
			//runs the conversion method
			ConvertToBinary(userInput);
			
			System.out.println(" ");
			
			}
	
			//loop to verify if user wants to run the program again on another integer
			else if(userInput == 0) {
				
				System.out.print("Goodbye.");
				
				//converts main loop condition to char that will end loop
				startUp = 'n';
			}
	
		}

	}

}
