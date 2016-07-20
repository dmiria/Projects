/* The second program you will be making is a program to calculate the cost of 
sales tax on an item, and the total cost to purchase that item. Your program 
will prompt the user for the sales tax percentage and the cost of the item, and 
will output the tax on the item, and the totalcost of the purchase.Your program 
must output the price in the correct currency, determined by the settings on the 
user's computer (hint:  think NumberFormat).*/


import java.util.*;
import java.text.*;

public class SalesTaxCalculator {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	
	
	System.out.println("Enter the tax percentage (for example, if tax is 6.5%, enter 6.5");
	double tax = keyboard.nextDouble( );
	
	System.out.println("Enter the cost of the item.");
	double cost = keyboard.nextDouble ( );
	
	double taxCalculated = cost*(tax/100);
	double totalCost = taxCalculated + cost;
	
	NumberFormat nf = NumberFormat.getCurrencyInstance( );
	
	
	System.out.println("The tax on your item is: " +  nf.format(taxCalculated));
	System.out.println("The total cost of your purchase is " + nf.format(totalCost));


	}
	
}