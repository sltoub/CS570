//Steven Toub
//slt82@drexel.edu
//CS570-900 Homework 7

import java.io.*;
import java.util.Scanner;


public class Cryptography {
	
	//This string is the lowercase and uppercase alphabet for comparison to encryption keys
	static String charIndex = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
//Method for encryption
//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------
	public static void Encrypt() throws IOException, Exception {
		
		//Initializes a BufferedReader for reading encryption key files
		BufferedReader encryptInput = null;
		//variables for storing user file directions
		String keyFile;
		String outputFile;
		//variable for storing user's message to be encrypted
		String toBeEncrypted;
		
		//Scanner for collecting user file selections and message to be encrypted
		Scanner scan = new Scanner(System.in);
		
		//accepts user's selection of a key file
		System.out.print("Enter file name for your encryption key: ");
			
			keyFile = scan.nextLine();
			System.out.println("");
		
		//accepts user's selection of an output file
		System.out.print("Enter file name for your output: ");
		
			outputFile =  scan.nextLine();
			System.out.println("");
		
		//Accepts the message the user wants to encode
		System.out.print("Enter the message you want to encrypt: ");
		
			toBeEncrypted = scan.nextLine();
			System.out.println("");
		
		//Try opening encryptInput Buffered Reader and output FileWriter
		try {
				
				//opens the BufferedReader that collects the selected encryption key
				encryptInput = new BufferedReader (new FileReader(keyFile));
					
					//Stores the encryption key file contents in string for future use
					String encryptInputRead = encryptInput.readLine();
				
				//initializes the FileWriter that writes outputs to selected file
				FileWriter output = new FileWriter(outputFile);
			
			//for loop that cycles through each character in the user's message to encrypt
			for(int i = 0; i < toBeEncrypted.length(); i++) {
				
				//boolean variable for initializing comparison while loop
				boolean encryptStart = true;
				
				//index integer for cycling through each character in charIndex
				int index = 0;
			
			//try finding the user input character in the charIndex
			try {
				
				//comparison while loop (runs for each character in the user message)
				while(encryptStart == true) {
					
					//if the character does not match the charIndex character, goes to next index
					if(toBeEncrypted.charAt(i) != charIndex.charAt(index)) {
						
						index++;
					}
					
					//if character matches the charIndex character
					else if(toBeEncrypted.charAt(i) == charIndex.charAt(index)) {
						
						//stores the character in the encryption key at the index of the matching
						//charIndex character
						char outputChar = encryptInputRead.charAt(index);
						
						//writes the selected encryption key character to the selected file
						output.write(outputChar);
						
						//ends the comparison while loop
						encryptStart = false;
						
					}
					
				}
			}
			
			//if no match between charIndex and user message character found, catches exception
			catch(StringIndexOutOfBoundsException notInKey) {
				
				//writes the character of the user's message as is, since it's not a
				//character from the alphabet and thus not be encrypted
				char outputChar = toBeEncrypted.charAt(i);
				
				output.write(outputChar);
				
				//terminates the comparison while loop
				encryptStart = false;
			}
				
			}
			
			//closes the BufferedReader and FileWriter Streams
			encryptInput.close();
			output.close();
			
			//Opens a new BufferedReader that reads the encrypted ouput written to
			//selected output file
			BufferedReader outputDisplay = new BufferedReader(new FileReader(outputFile));
			
			//prints the encoded message read from the output file
			System.out.print("Your encoded message is: ");
			System.out.println(outputDisplay.readLine());
			System.out.println("");
			
			//closes BufferedReader
			outputDisplay.close();
			
			}	
			
			//if the selected file does not exist or is not able to be opened, catches the
			//exception and informs the user
			catch(IOException noFile) {
				
				System.out.println("Encryption key file not found or could not be opened");
				System.out.println("");
			}
			
			//if the selected encryption key file exists but has no contents, informs the
			//user that there is no encryption key present in the file.
			catch(Exception NullPointerException) {
				
				System.out.println("The key file exists but has no contents.");
				System.out.println("");
			}
						
	}	
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
	
	public static void Decrypt() throws IOException, Exception{
		
		//Initializes a BufferedReader for reading encryption key files
		BufferedReader decryptInput = null;
		//variables for storing user file directions
		String keyFile;
		String outputFile;
		//variable for storing user's message to be decrypted
		String toBeDecrypted;
		
		//Scanner for collecting user file selections and message to be decrypted
		Scanner scan = new Scanner(System.in);
		
		//accepts user's selection of a key file
		System.out.print("Enter file name for your decryption key: ");
			
			keyFile = scan.nextLine();
			System.out.println("");
		
		//accepts user's selection of an output file
		System.out.print("Enter file name for your output: ");
		
			outputFile =  scan.nextLine();
			System.out.println("");
		
		//Accepts the message the user wants to decode
		System.out.print("Enter the message you want to decrypt: ");
		
			toBeDecrypted = scan.nextLine();
			System.out.println("");

		//Try opening decryptInput Buffered Reader and output FileWriter
		try {
				
				//initializes the BufferedReader that collects the encryption key from file
				decryptInput = new BufferedReader (new FileReader(keyFile));
					
					//stores contents of selected key file in string for future use
					String decryptInputRead = decryptInput.readLine();
				
				//initializes the FileWriter for writing decrypted message to file selection
				FileWriter output = new FileWriter(outputFile);
				
			//for loop that cycles through each character in the user's message to be decrypted
			for(int i = 0; i < toBeDecrypted.length(); i++) {
				
				//boolean variable for initializing the comparison while loop
				boolean decryptStart = true;
				//index for cycling through each character of the encryption key
				int index = 0;
			
			//try finding the user input character in the encryption key
			try {
				
				//comparison while loop (runs for each character in the user message)
				while(decryptStart == true) {
					
					//if the character at current index in encryption key does not match
					//the character at the current index in the user message, move to next
					//index in the encryption key
					if(toBeDecrypted.charAt(i) != decryptInputRead.charAt(index)) {
						
						index++;
					}
					
					//if the character in the key matches the character in the message
					else if(toBeDecrypted.charAt(i) == decryptInputRead.charAt(index)) {
						
						//stores the character in the charIndex at the matched
						//encryption key character index
						char outputChar = charIndex.charAt(index);
						
						//writes the stored character to the selected output file
						output.write(outputChar);
						
						//terminates comparison loop
						decryptStart = false;
						
					}
					
				}
			}
			
			//if the character in the user message is not in the encryption key, catches exception
			catch(StringIndexOutOfBoundsException notInKey) {
				
				//writes the character in the message as is
				char outputChar = toBeDecrypted.charAt(i);
				
				output.write(outputChar);
				
				//terminates comparison loop
				decryptStart = false;
			}
				
			}
			
			//closes the BufferedReader and the FileWriter
			decryptInput.close();
			output.close();
			
			//initializes the BufferedReader for reading what was written to output file
			BufferedReader outputDisplay = new BufferedReader(new FileReader(outputFile));
				
				//prints contents of the output file
				System.out.print("Your decoded message is: ");
				System.out.println(outputDisplay.readLine());
				System.out.println("");
			
			//closes the BufferedReader for reading output file
			outputDisplay.close();
			
			}
			
			//if the selected key file does not exist, catches exception and informs user
			catch(IOException noFile) {
				
				System.out.println("Encryption key file not found or could not be opened");
				System.out.println("");
			}
			
			//if the selected encryption file exits but is empty, informs the user
			catch(Exception NullPointerException) {
				
				System.out.println("The key file exists but has no contents.");
				System.out.println("");
			}
			
	}	
	
	
	//main method
	public static void main(String[] args) throws IOException, Exception{
		
		//Program header
		System.out.println("Encoder/Decoder Program");
		System.out.println("------------------------------------------");
		
		//boolean variable for determining whether or not to run main do while loop
		boolean startUp = true;
		//Scanner for collecting user's option selection
		Scanner selectRead = new Scanner(System.in);
		
		//main do while loop for collecting user selections and calling encrypt/decrypt
		do{
			
			//Displays available options to user
			System.out.println("Enter E to encrypt a message.");
			System.out.println("Enter D to decrypt a message.");
			System.out.println("Enter Q to exit the program");
			System.out.print("Enter your selection: ");
		
		//checks to see if user has added input to avoid a NoSuchElementException
		if(selectRead.hasNext()) {
			
			//stores the first char of user input to determine selection
			char userSelect = selectRead.next().charAt(0);
			
			//checks to see if encrypt option selected and calls encrypt()
			if(userSelect == 'E' || userSelect == 'e'){
			
				Encrypt();
			}
			
			//checks to see if decrypt option selected and call decrypt()
			else if (userSelect == 'D' || userSelect == 'd') {
			
				Decrypt();
			}
			
			//checks to see if user opted to close program and terminates the main do while loop
			else if (userSelect == 'Q' || userSelect == 'q'){
				
				startUp = false;
				
				System.out.println("");
				System.out.print("Goodbye.");
			}
			
			//if user selection is not above, informs user their selection is not accepted
			else {
				
				System.out.println("");
				System.out.println("Your selection is not a valid option.");
				System.out.println("");
			}
		}
		
		}while(startUp == true);
		
	}
	
}