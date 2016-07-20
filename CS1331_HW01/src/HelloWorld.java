public class HelloWorld {
    public static void main(String[] args) {
	String message = "Hello World!";
	System.out.println(message);
	System.out.println("The message is " + message.length()
		+ " characters long");
	String name = "D'Miria Collins";
	String major = "Computational Media";
	System.out.println("My name is " + name + " and I am a " + major + " major. And recent grad");
    }
}

/*
 * Questions:
 * 
 * 1. Explain what happens when this code runs. (Go into more detail than just saying what
 * it prints out)
 * 
 * Answer: The string "Hello World" is assigned to the variable message. Then the code prints 
 	whatever is assigned to message. The code then prints another line with a string that tells 
	the user the number of characters in the string assigned to message. 
 * 
 * 
 * 2. What is the type and value of the variable called message?
 * 
 *  Type:String (string of characters)
 *  Value: Hello World!
 *  
 * 3. When we say message.length(), we are:
 *     a) calling the length() method on the String held in the message variable
 *     b) getting the amount of space in memory that the message variable takes up
 *     c) making a new string 
 *  
 *  Answer: a) calling the length() method on the String held in the message variable

 *  
 *  
 * 4. Add to the code above - create a new variable called "name", and one called "major".
 *    In those variables, store your actual name and major, and then print out those
 *    variables in a way makes sense. If I were to do this, the additional line printed would
 *    look like:
 *    
 *    My name is Elizabeth Johnson, and I am a Computational Media major. 
 * 
 * 
 * 5. What is the main method for in a java program?
 *  
 *  Answer:The main method calls the class and other methods needed for the code.
 *  
 *  
 * 6. What are the three categories of errors discussed in class?
 *  
 *  Answer: Runtime, Semantic, and Syntax Error
 * 
 * 7. If you get an error in your code, you should:
 *  a) cry
 *  b) give up
 *  c) read the stack trace that java spits out at you and then look at the
 *     line that caused the error so that you can fix it
 *  d) ask everyone you know for help BEFORE you try to fix it
 * 
 *  Answer:c) read the stack trace that java spits out at you and then look at the
 *     		line that caused the error so that you can fix it
 *  
 * 8. What are the integer primitive types?
 * 
 *  Answer: Long, short, byte, int
 *  
 * 9. Legal/Not Legal
 *      For each of the following lines, state if the line is legal or not (does it compile & run).
 *  If it is legal, give the value of the variable (remember, 0 and 0.0 are completely different things in java)
 *  
 *  a) int i = 10;
 *      Legal?: Yes
 *      Value: 10 
 *  
 *  b) float f = 12.1;
 *      Legal?: No
 *      Value: --
 *      
 *      c) double d = 4/5;
 *              Legal?:Yes
 *              Value:0.0
 *  
 *  d) double d = 1/10.0;
 *      Legal?:Yes
 *      Value:0.1
 *  
 *  e) int i = 3 + 4.0*5;
 *      Legal?:No
 *      Value: --
 *  
 *  f) int i = (int)(4.0*5);
 *      Legal?:Yes
 *      Value:20
 *  
 */
