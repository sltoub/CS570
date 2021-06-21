//Steven Toub
//slt82@drexel.edu
//Homework 8 Book Class

import java.text.NumberFormat;

public class BookClass {
	
	//variables for a BookClass object
	private String iSBN;
	private String title;
	private String author;
	private int numPages;
	private double price;
	private int numInStock;
	
	//default constructor that initializes a BookClass as all null or 0
	BookClass(){
		
		iSBN = null;
		title = null;
		author = null;
		numPages = 0;
		price = 0;
		numInStock = 0;
		
	}
	
	//alternate constructor for using user input
	BookClass(String newISBN, String newTitle, String newAuthor,
				int newNumPages, double newPrice, int newStock){
		
		//mutators
		iSBN = newISBN;
		title = newTitle;
		author = newAuthor;
		numPages = newNumPages;
		price = newPrice;
		numInStock = newStock;
		
	}
	
	//mutator for number of books in stock for a book object
	protected void modStock(int changeStock) {
		
		//modifies the number of books in stock by subtracting the parameter from current stock
		numInStock = numInStock - changeStock;
		
	}
	
	//accessor methods for each object 
	protected String getISBN() {
		
		return iSBN;
	}
	
	protected String getTitle() {
		
		return title;
	}
	
	protected String getAuthor() {
		
		return author;
	}
	
	protected int getNumPages() {
		
		return numPages;
	}
	
	protected double getPrice() {
		
		return price;
	}
	
	protected int getNumInStock() {
		
		return numInStock;
	}
	
	//method for displaying the contents of a book object
	protected void printBook() {
		
		//Formatter for displaying getPrice as a currency amount
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		//prints each variable of a book object using accessor methods with a standard spacing format
		System.out.printf("%-15s%-25s%-20s%-10s%-10s%-10s\n", getISBN(), getTitle(), getAuthor(), getNumPages(), 
							fmt.format(getPrice()), getNumInStock());
		

	}
	
}
