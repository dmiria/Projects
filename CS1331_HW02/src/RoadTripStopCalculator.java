/*  The first program you will be making is a program to calculate 
the number of stops a person must make on a road trip. The number of 
stops is solely determined by when you need to refill the car with gas
-we will not take into account the needs of the people on the trip. 
You also assume that you start off with a full tank of gas, you only 
need to fill up when the car is 100% out of gas, and every time you 
get gas, you completely fill the tank.Your program should prompt the 
user for the distance for the road trip rounded to the nearest whole 
number, the tank size of the car, and the mpg (miles per gallon) rating
of the car.
*/

import java.util.Scanner;

public class RoadTripStopCalculator {

    public static void main(String[] args) {
	 	
		Scanner keyboard = new Scanner (System.in);
				
		System.out.println("How many miles (to the nearest whole number) is your trip?");
		double tripMiles = keyboard.nextDouble( );
		
		System.out.println("How many gallons of gas does your tank hold?");
		double gallonsOfGas = keyboard.nextDouble( );
		
		System.out.println("What is the mpg rating of your car?");
		double milesPerGallon = keyboard.nextDouble( );

		int numOfTrips = (int) tripMiles/ (int)(gallonsOfGas*milesPerGallon);

		System.out.println("You will have to make " + numOfTrips + " stops during your trip.");
	}
}