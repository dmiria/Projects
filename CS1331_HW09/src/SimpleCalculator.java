import java.util.*;
/**
 *This class handles performing the operation based on the operator 
 *and number passed to it and keeps track of the result.
 * 
 * @author D'Miria Collins
 * @version 1.0
 */
public class SimpleCalculator {
	private double result = 0.0;
/**
 * Constructs a method that takes in the result.
 * @param result
 * 
 */
	
	public SimpleCalculator(double result){
		this.result = result;
	}
/**
 *Constructs a method to create SimpleCalculator 
 *object
 *
 */
	public SimpleCalculator(){
	}
	public void operation(String operator, double number) throws ArithmeticException, UnknownOperatorException{
		if (operator.equals("+")){
			result += number;
		}else if(operator.equals("-")){
			result -= number;
		}else if (operator.equals("*")){
			result *= number;
		}else if (operator.equals("/")){
			if (number == 0){
				throw new ArithmeticException("You cannot divide by 0!");
			}else{	
				result /= number;	
			}	
		}else{
			throw new UnknownOperatorException ("We do not support that operation!");
		}	

	}
/**
 *Constructs a method to get the result after performing the
 *operations.
 *
 */
	public String getResult(){
		return "result = " + result;
	}
}
		
		
		
		
		
		
		
		
		
		
