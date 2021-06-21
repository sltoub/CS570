// Name: 	TestPairs.java
// Purpose:	Demonstrate  the creation of objects and usage of methods
//			It uses the Pair class
// Author:	Adelaida A. Medlock
// Date:	October 9, 2018

public class TestPairs 
{
	public static void main(String[] args) 
	{
		System.out.println("Testing the Pairs class\n");
		
		Pairs p1 = new Pairs(10, 5);
		Pairs p2 = new Pairs();
			
		p2.changeFirst(100);
		p2.changeSecond(200);
		
		System.out.println("Pair p1 = " + p1.toString());
		System.out.println("Pair p2, first element: " + p2.getFirst());
		System.out.println("Pair p2, second element: " + p2.getSecond());
	}
}
