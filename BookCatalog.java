//Steven Toub
//slt82@drexel.edu
//Homework 8 Book Catalog

import java.util.Scanner;

public class BookCatalog {

	public static void main(String[] args) throws Exception{
		
		//initializes a linked list for the catalog
		BookLinkedList catalogList = new BookLinkedList();
		
		//initializes a scanner to accept user input
		Scanner scan = new Scanner(System.in);
		
		//outputs display header
		System.out.println("                      Bookstore Catalog");
		System.out.println("-----------------------------------------------------------------");
		
		//boolean for initializing the while loop
		boolean start = true;
		
		//stores the termination String for future comparison
		String terminate = "000";
		
		//while loop for collecting user input to create book objects
		while(start == true) {
			
			System.out.print("Enter an ISBN or 000 to stop: ");
		
		//ensures that user entered input before attempting to mutate using input
		if(scan.hasNext()) {
			
			//collect user ISBN
			String userISBN = scan.nextLine();
			
			//catches the termination condition and determines whether to collect input
			if(userISBN.equals(terminate)) {
				
				start = false;
				System.out.println("");
				
			}
			
			//if ISBN is not termination condition, proceeds with book object creation
			else {
				
				//collects title
				System.out.print("Enter book title: ");
				String userTitle = scan.nextLine();
				
				//collects author
				System.out.print("Enter book author: ");
				String userAuthor = scan.nextLine();
				
				//local variables for validating numeric input
				int userPageNum;
				double userPrice;
				int userQuantity;
				
				//do while loop that reiterates until valid page number received
				do {
				
				//collects page number
				System.out.print("Enter the number of pages in the book: ");
				userPageNum = scan.nextInt();
				
				//informs user if input was 0
				if(userPageNum == 0) {
					
					System.out.println("You must enter a value greater than zero");
				}
				
				//informs user if input if negative
				else if(userPageNum < 0) {
					
					System.out.println("You must enter a non-negative value.");
				}
				
				}while(userPageNum < 0 | userPageNum == 0);
				
				//do while loop that reiterates until valid price received
				do {
				
				//collects price
				System.out.print("Enter the price of the book: ");
				userPrice = scan.nextDouble();
				
				//informs user if input was 0
				if(userPrice == 0) {
					
					System.out.println("You must enter a value greater than zero.");
				}
				
				//informs user if input if negative
				else if(userPrice < 0) {
					
					System.out.println("You must enter a non-negative value.");
				}
				
				}while(userPrice < 0 | userPrice == 0);
				
				//do while loop that reiterates until valid number of copies collected
				do {
				
				//collects number of copies in stock
				System.out.print("Enter the number of copies in stock: ");
				userQuantity = scan.nextInt();
				
				//separates collection output from future System output
				System.out.println("");
				
				//informs user if input was negative
				if(userQuantity < 0) {
					
					System.out.println("You must enter a non-negative value.");
				}
				
				}while(userQuantity < 0);
				
				//creates a new BookClass object using collected parameters and adds it the the start
				//of the linked list
				catalogList.addStartingNode(new BookClass(userISBN, userTitle, userAuthor, 
											userPageNum, userPrice, userQuantity));
				
				//clears the scanner to prepare for collecting String input in next book object
				scan.nextLine();
			}
		}
	}
		
		//calls the printList method to display contents of each BookObject in the list
		catalogList.printList();
		
		//calls the modifyStock method to collect number of copies sold for each object
		//in the list
		catalogList.modifyStock();
		
		//prints the updates list of BookClass objects in the list
		catalogList.printList();
		
		//calls the printGrossSales method to display gross numbers sold and gross dollar
		//amount sold
		catalogList.printGrossSales();
	}	
}
