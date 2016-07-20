import java.util.Scanner;
import java.io.FileInputStream;//connect Java to file
import java.io.FileNotFoundException;//If the program tries to 
												 //open a program that doesn't exist.
public class JavaQuiz 
{
	public static void main(String [] args)
	{	
	Scanner fileIn = null; //initializes fileIn to empty
	
	try
	{
		//Attempt to open the file
		fileIn = new Scanner (new FileInputStream("questions.txt"));
	}
	
	catch (FileNotFoundException e)
	{
		//This block executed if the files is not found
		//and then the program exists.
		System.out.println("File not found.");
		System.exit (0);
	}
	
	//If the file gets here than the file was opened 
	//successfully.
//----------------------------------------------------------------------------------------------------------------
	Scanner keyboard = new Scanner(System.in);
	double correctAns = 0;
	double skippedNum = 0;
	double attemptedQuest = 0;
	
	while (fileIn.hasNextLine()){
		String question = fileIn.nextLine();
		int indx = question.indexOf("|");
		
		System.out.println(question.substring(0,indx));
		String ans = keyboard.nextLine();
		if ((ans.compareToIgnoreCase(question.substring(indx+2))) == 0)
			{
			attemptedQuest ++;
			correctAns ++;
			}
		while ((ans.compareTo("q") != 0) && ((ans.compareToIgnoreCase(question.substring(indx+2))) != 0))
			{
			attemptedQuest ++;
			System.out.println("Incorrect. Please try again.");
			ans = keyboard.nextLine();
			if ((ans.compareToIgnoreCase(question.substring(indx))) == 0)
				{
				correctAns ++;
				attemptedQuest ++;
				}
			}
			if (ans.compareTo("q") == 0)
				{
				skippedNum ++;
				}
	}
	fileIn.close();
	System.out.printf("You got %.0f questions correct \n", correctAns);
	System.out.printf("You skipped %.0f questions \n", skippedNum);
	
	double averageCorrect = attemptedQuest/5.0;
	System.out.printf("And for the questions you completed, you average %.2f", averageCorrect);
	
	}
}
