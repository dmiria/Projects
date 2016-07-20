import java.util.Scanner;
import java.util.*;
/**
 *This class prompts the user to modify the result in each
 *cycle through addition, subtraction, division, and 	
 *multiplication.
 *
 *@author D'Miria Collins
 *@version 1.0
 */
public class SimpleCalculatorDriver {
	public static void main (String [] args){
	
	Scanner keyboard = new Scanner(System.in);
		
	boolean calcOn = true;
	SimpleCalculator calculator = new SimpleCalculator();

	while (calcOn){
	
		System.out.println(calculator.getResult());
		System.out.println("Enter an operation or 'q' to end the program.");
		
		try{
			//System.out.println(calculator.getResult());
			//System.out.println("Enter an operation or 'q' to end the program.");

			String nextOperator = keyboard.next();
			if (!(nextOperator.equals("q"))){
				System.out.println("Enter a number");
				int nextNum = keyboard.nextInt();	
				calculator.operation(nextOperator,nextNum);
					
			}else{
				calcOn = false;
			}
		}catch(UnknownOperatorException f){
				System.out.println(f.getMessage());
		}catch(InputMismatchException m){
				System.out.println("That is not a number! Please try again.");
		}catch(ArithmeticException k){
				System.out.println(k.getMessage());
		}
	}
	}
}