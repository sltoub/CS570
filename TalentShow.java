//Steven Toub
//slt82@drexel.edu
//CS570-900 Homework 5 Question 1

import java.util.Scanner;

//Class for collecting contestant votes, displaying results, and determining the winner
public class TalentShow {

	
	//method for displaying the contestant names and their codes
	public static void displayCodes(String[] namesArray){
		
		//Labels for displayed output
		System.out.println("Contestant         Code");
		System.out.println("------------------------");
		
		//loop that cycles through each String in namesArray and displays
		//the names next to their numeric code to be used for selection
		for(int count = 1; count <= namesArray.length; count++) {
			
			//outputs names and codes for each loop iteration
			//formats the output to look pleasant
			System.out.format("%-20s%d%n", namesArray[(count-1)], count);	
		}
		
		//denotes end of method output in user interface
		System.out.println("------------------------");
	}
	
	
	
	//method for collecting votes from the user for contestants, based on their code
	//votes are stored in the votesArray in the same index as the corresponding namesArray index
	public static void collectVotes(int votesArray[]) {
		
		//char collect is the activation character for the vote collection loop
		char collect = 'y';
		
		Scanner scan = new Scanner(System.in);
		
		//stores the code between 1 and 10 user inputs
		int userInput;
		
		//while loop for collecting votes. Loops until char collect receives a terminating character
		while(collect == 'y') {
			
			//initial request for user input
			System.out.print("Enter the code for the contestant you want to vote for: ");
			
			//initial collection of user input
			userInput = scan.nextInt();
			
			//error handling for when the user inputs a code less than 1 or greater than 10
			//loops error message and input collection until 1 <= user input <=10
			while(userInput > 10 | userInput < 1) {
				
				//displays error message and then asks for new input
				System.out.println("Contestant code must be a value between 1 and 10.");
				System.out.println("");
				System.out.print("Enter the code for the contestant you want to vote for: ");
				
				//collects new input
				userInput = scan.nextInt();
			}
			
			//after acceptable input received, allocates 1 point to the index in votesArray that 
			//corresponds to the same index in the namesArray (accounts for the 0-9 index by
			//subtracting 1 from the contestant codes 1-10
			votesArray[(userInput - 1)] = votesArray[(userInput - 1)] + 1;
			
			scan.nextLine();
			
			//booleans to determine if main while loop will terminate or not
			boolean yes;
			boolean no;
			
			//loop for determining if user wants to run the main while loop again to collect another
			//vote
			do
			{
			  System.out.print("Are there any other votes to cast? (y/n) ") ;
			  
			  //scans first character to see if it is a y or n to determine user response
			  collect = scan.nextLine().charAt(0); 
			  	
			  //if statement to convert lower case y's to upper case Y's to satisfy while loop condition
			  	if(collect == 'Y') {
			  		collect = 'y';
			  	}
			  	
			  // y or Y runs program again, n or N ends the main while loop.
			  yes = (collect == 'Y' ) || (collect == 'y' ) ;
			  no = (collect == 'N' ) || (collect == 'n' ) ;

			} while( !( yes || no ));
		}
	}

	
	
	//method for displaying the number of votes each contestant received
	public static void displayVotes(String[] namesArray, int[] votesArray) {
		
		//Labels for displayed output
		System.out.println("Contestant         Votes");
		System.out.println("------------------------");
		
		//loop that cycles through each index in the namesArray and votesArray and displays data at each
		//index as a pair
		for(int count = 1; count <= namesArray.length; count++) {
			
			//statement for displaying the indexes of the arrays, formatting them to look uniformly spaced
			System.out.format("%-20s%d%n", namesArray[(count-1)], votesArray[(count-1)]);	
		}
		
		//denotes end of method output in user interface
		System.out.println("------------------------");
		
	}

	
	
	//method for determining who has the most votes
	public static void findWinner(int[] votesArray, String[] namesArray) {
		
		//holds the index of the highest value in the votesArray
		//initiated at 0 so that the first comparison in the loop is between index 0 and 1
		int mostVotes = 0;
		
		//for loop that compares the values in votesArray to find the largest value
		for(int count = 1; count < votesArray.length; count++) {
			
			//if the value at the current index in votesArray is greater than the value at the
			//stored index with the greatest value, sets the new greatest value index to be mostVotes
			//for future comparisons
			if(votesArray[count] > votesArray[mostVotes]) {
				
				mostVotes = count;
			}
		}
			
			//Upon completion of the loop, displays the index in namesArray that corresponds to the index
			//in votesArray with the highest value
			System.out.println("The winner is: " + namesArray[mostVotes]);
	}
	

	
	
	//main method
	public static void main(String[] args) {
		
		//declares the array for holding contestant names
		String[] namesArray = new String[10];
		
		//fills up the namesArray with each contestant's name
		namesArray[0] = "Abigail";
		namesArray[1] = "Ben";
		namesArray[2] = "Carla";
		namesArray[3] = "David";
		namesArray[4] = "Ella";
		namesArray[5] = "Fred";
		namesArray[6] = "Grace";
		namesArray[7] = "Hector";
		namesArray[8] = "Irene";
		namesArray[9] = "Jerry";
		
		//array for storing number of votes for each contestant
		int[] votesArray = new int[10];
		
		//Shows the user the contestants and their codes
		displayCodes(namesArray);
		
		//Collects votes from the user based on contestant codes
		collectVotes(votesArray);
		
		//Cleans up the output, separates the voting info from the results
		System.out.println("");
		System.out.println("Results:");
		
		//Shows each contestant and the number of votes they received
		displayVotes(namesArray, votesArray);
		
		//displays the name of the contestant with the most votes
		findWinner(votesArray, namesArray);
	}

}
