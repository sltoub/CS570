//Steven Toub
//slt82@drexel.edu
//Homework 8 Linked List

import java.util.Scanner;
import java.text.NumberFormat;

public class BookLinkedList{
	
	//variables for tracking gross sales in number and dollar amount
	//declared as class variable so that they can be accessed outside of
	//method that is tracking them
	int totalStockDeduct = 0;
	double totalSales = 0;
	
	//Node object for storing the first object in the list
	private Node listHead;
	
	//nested Node Class
	private class Node{
		
		BookClass book;
		private Node nextNode;
		
		//default constructor for Node class
		public Node() {
			
			book = new BookClass();
			nextNode = null;
			
		}
		
		//alternate Node constructor
		public Node(BookClass newBook, Node newNode) {
			
			//mutators for Node class
			book = newBook;
			nextNode = newNode;
		}
	}
	
	//linked list constructor
	public BookLinkedList() {
		
		listHead = null;
	}
	
	//method for adding a new node to the linked list
	public void addStartingNode(BookClass addBook) {
		
		//sets the new node as the start of the list
		listHead = new Node(addBook, listHead);
	}
	
	//method for cycling through linked list, collecting number of books sold for each object
	//in the list, and then updating the remaining stock in each object
	public void modifyStock() throws Exception{
		
		//node object for tracking current object
		Node location;
		
		//initializes the location as the start of the list
		location = listHead;
		
		//scanner for collecting number of copies of a book object sold
		Scanner modStockInput = new Scanner(System.in);
		
		//int for storing modStockInput input from user
		int stockDeduct;
		
		//variable for collecting a book object's getPrice() for use in calculations
		double nodePrice;
		
		//Book object for manipulating the object at the current node location in loop
		BookClass bookAtLocation;
		
		//boolean for determining whether or not to run modifyStock on another node/object
		boolean runStock = true;
		
		try {
			
			//header for copies sold
			System.out.println("");
			System.out.println("Copies sold this week");
			System.out.println("--------------------------------------------------------------------------------------");
		
		//loop for modifying stock on a book object in list, tracking gross sales, and traversing to next object in list
		while(runStock == true) {
			
			//sets the current object as the next node in the list
			bookAtLocation = location.book;
			
			//terminates while loop if end of list has been reached
			if(bookAtLocation == null) {
				
				runStock = false;
				
			}
			
			else if(bookAtLocation != null) {
				
				//do while loop for collecting and validating input
				do {
					
					//requests input for current object in list
					System.out.print("Enter the number of copies sold for " + bookAtLocation.getTitle()
					+ ": ");
					
					//sets the number to be deducted from object's numInStock to latest user input
					stockDeduct = modStockInput.nextInt();
					
					//informs user if input is greater than object's numInStock
					if(stockDeduct > bookAtLocation.getNumInStock()) {
						
						System.out.println("You cannot sell more than is in stock.");
					}
					
					//informs user if input is a negative
					else if(stockDeduct < 0) {
						
						System.out.println("You cannot sell a negative number of books.");
					}
					
					//else = input is valid and can be used
					else {
						
						//enacts modStock method from BookClass on current object in list using input as parameter
						bookAtLocation.modStock(stockDeduct);
						
						//adds the input to the total number of books deducted from stock
						totalStockDeduct = totalStockDeduct + stockDeduct;
						
						//uses getPrice() from BookClass to collect price variable from current object
						//multiplies it by number of books sold in current object
						nodePrice = ((bookAtLocation.getPrice()) * stockDeduct);
						
						//adds nodePrice to total sales to track gross sales
						totalSales = totalSales + nodePrice;
						
						//resets stockDeduct to 0 to prepare for input on next object in list
						stockDeduct = 0;
					}
				
				//will cycle the do while loop until input is greater than 0 and not more than an object's
				//number in stock
				}while(stockDeduct > bookAtLocation.getNumInStock() | stockDeduct < 0);
					
					//traverses to the next node in the list
					location = location.nextNode;
				
			}
		}
		}
		
		//catches the nullPointerException thrown when end of list is reach to cleanly end
		//modifyStock() method once all input is received
		catch(NullPointerException endOfList) {
			
			System.out.println("");
		}
	}
	
	//method for printing the number of books total sold and the gross dollar sales
	public void printGrossSales() {
		
		//initializes a NumberFormatter for displaying the price variable as a dollar amount
		NumberFormat fmtSales = NumberFormat.getCurrencyInstance();
		
		//prints total books sold
		System.out.println("Total number of books sold this week: " + totalStockDeduct);
		
		//prints gross dollar sales
		System.out.println("Gross sales this week: " + fmtSales.format(totalSales));
		System.out.println("");
	}
	
	//method for displaying each book object in the linked list
	public void printList() {
		
		//initializes a node as the first object in the list
		Node location;
		location = listHead;
		
		//prints the header for the catalog
		System.out.println("Current Catalog");
		System.out.println("--------------------------------------------------------------------------------------");		
		System.out.printf("%-15s%-25s%-20s%-10s%-10s%-10s\n", "ISBN", "Title", "Author", "Pages", "Price", "Stock");
		System.out.println("--------------------------------------------------------------------------------------");
		
		//while loop that iterates until the end of the list is reached
		while(location != null) {
			
			//calls the printBook() method of the BookClass for the current object in list
			location.book.printBook();
			
			//traverses to the next object in the list
			location = location.nextNode;
		}
	}
	
}
