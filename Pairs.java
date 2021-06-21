// Name: 	Pairs.java
// Purpose:	Define a class to represent a numeric pair (x, y). 
//			For example (3, 5)
// Author:	Adelaida A. Medlock
// Date:	October 9, 2018

public class Pairs 
{
	private int first;
	private int second;
	
	public Pairs()
	{
		first = 0;
		second = 0;
	}
	
	public Pairs(int f, int s)
	{
		first = f;
		second = s;
	}
	
	public int getFirst()
	{
		return first;
	}
	
	public int getSecond()
	{
		return second;
	}
	
	public void changeFirst(int f)
	{
		first = f;
	}
	
	public void changeSecond(int s)
	{
		second = s;
	}
	
	public String toString()
	{
		return ( "(" + first + ", " + second + ")" ) ;
	}
}
