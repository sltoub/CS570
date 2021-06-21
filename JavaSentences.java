//Steven Toub
//slt82@drexel.edu
//CS570-900
//JavaSentences Class

import java.util.Scanner;

public class JavaSentences {

	public static void main(String[] args) {
		
		String userInput;
		int inputLength;
		char lastChar;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a sentence: ");
			
			userInput = scan.nextLine();
			
		//Stores the length of the string for finding the position of last char in the userInput
		//String.length returns the length not including 0 as a position
		//Since the first index is 0 in the charAt method, one is subtracted so that inputLength 
		//can be used in the charAt method without producing an out of bounds exception
			inputLength = (userInput.length() - 1);
			
		//Stores the char at the end of userInput
			lastChar = userInput.charAt(inputLength);
			
		//if statements for determining which of the four conditions userInput falls in
			
		//First if statement asks if statement ends in a "?" and if its length divided by 2 has
		// a remainder of 0. Since inputLength is adjusted earlier in the program to account for
		//the index of 0, a remainder of 0 actually indicates an odd length, rather than even
			if(lastChar == '?' && inputLength % 2 == 0) {
				
					System.out.println("No");
			}
				
		//Second if statement for determining if userInput has a ? and is even
			else if(lastChar == '?' && inputLength % 2 != 0) {

					System.out.println("Yes");
			}
			
		//if statement for strings ending with "!"
			else if(lastChar == '!') {
				
				System.out.println("Wow");
			}
		
		//method for all other string inputs
			else {
				
				System.out.println("You always say " + "\"" + userInput + "\"");
			}
			
	}

}