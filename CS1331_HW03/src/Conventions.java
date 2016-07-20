import java.util.Scanner;

public class Conventions {
    public static void main(String[] args){
	
		String text1 = "This file is full of poor coding conventions. I want you to go through and fix each of them, and then write me a short paragraph about what was wrong, and why conventions are necessary/helpful.";
		
		System.out.println(text1);
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the  side length of a rectangle");
		double length1 = keyboard.nextDouble(); 
		System.out.println("Enter the other side of the rectangle");
		double length2 = keyboard.nextDouble();
		
		//multiply x and y - store in the double-type variable q
		//When you multiply one side of a rectangle by another, you get the are of the entire rectangle.
		
		double area = length1*length2;

		System.out.println("Rectangle area:" + area);
		String seeHowHardThisIsToRead = "Crazy, eh?";     
		System.out.println("And yet, the compiler has no problem with this code. Do you know why?");      
		String commentsAndThings = "Comments are superhelpful in code - especially when it gets more complex";     
		System.out.println(commentsAndThings + " Create a block comment that contains your description of what is wrong with this and why conventions are awesome.");
     
     }
}

/*The name of the file should capitalized because it is a class. The fancy bracket on line 
6 should be placed on line 5 after the parenthesis. The name of the String and doubles should 
have a variable name that is relevent to what the variable is assigned to. Lines 9 through 15 
should be indented inside of the block. The Scanner name should have a simpler name associated 
with the new scanner. The print line on line 12 should be put on a new line (13)so that it is 
easier to read. The comment should explaint the purpose of this code a little better. On line 
22 the words should be written in camel case. The last 3 lines of code should also be indented. 
The String COMMENTSANDTHINGS should also be camel case and be put on a new line. On line 24 
the fancy bracket should be put on a new line and indented. 
*/

