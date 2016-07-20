/*The third program that you will be making is one that will manipulate 
user input in specific ways and print out the result of the manipulations. 
You program should prompt the user for an initial string. It should then 
split the string in half, change the first half to all capital letters, 
and change the second half to all lowercase letters. It should then put 
the string back together in reverse order (the last half, then the first 
half) and print the result out to the user.

It should then take in another string. In this new string, it should locate 
the first instance of a lowercase a. It should then replace all lowercase 
a's with uppercase A's, and replace all e's with the number 3. Then print 
out the result to the user.*/

import java.util.Scanner;

public class StringFun {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);


	System.out.println("Please input a string of text.");
	String text1 = keyboard.nextLine( );
	//System.out.println("You entered: " + text1);
	
	int lenOfString = (text1.length( ))/2;
	String firstHalfOfText1 = text1.substring (0,lenOfString);
	String secondHalfOfText1 = text1.substring (lenOfString, text1.length());
	
	//firstHalfOfText1.toLowerCase( );
	//System.out.println(firstHalfOfText1.toUpperCase( ));
	//secondHalfOfText1.toUpperCase( );
	//System.out.println(secondHalfOfText1.toLowerCase( ));

	System.out.println(secondHalfOfText1.toLowerCase( ) + firstHalfOfText1.toUpperCase( ));


//Part 2

	System.out.println("Please input another string of text.");
	String text2 = keyboard.nextLine( );
	
	int locateLetter = text2.indexOf("a");
	
	String newtext2 = text2.replace("a","A");
	String finaltext2 = newtext2.replace("e","3");
	
	
	System.out.println("The first 'a' is located at index " + locateLetter);
	System.out.println(finaltext2);
	}
	
}