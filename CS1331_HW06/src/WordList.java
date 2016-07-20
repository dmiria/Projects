import java.util.Scanner;
import java.util.Random;
import java.io.FileInputStream;//connect Java to file
import java.io.FileNotFoundException;//If the program tries to 
												 //open a program that doesn't exist.
/**
  *This class opens a file and places the contents of the file into an array. The file contains a list
  *of a certain part of speech. It returns a random word out of the array.
  *
  *@author D'Miria Collins
  *@version 1.0
**/

public class WordList{
	private Random rand;
	private String [] words;
	private String fileName;
/**
  *Constructs a method that takes in a file name for opening. It then sets a variable
  *equal to the first int value of the text file. Then an array is created to the length
  *equal to the variable value. Then every subsequent word on each line in the file
  *is placed in the array.
  *
  *@param fileName name of text file with the size of needed array and items to fill into array.
**/

	public WordList(String fileName){
		this.fileName = fileName;
		rand = new Random();
		Scanner fileIn	= null; //initializes fileIn to empty
		Scanner keyboard = new Scanner(System.in);
		
		try{
//		Attempt to open the file
		fileIn =	new Scanner	(new FileInputStream(fileName));
		}catch (FileNotFoundException	e){
//    This block executed if the files is not	found
//		and then the program exists.
		System.out.println("File not found.");
		System.exit	(0);
		}
	
		int numOfBlanks = fileIn.nextInt();
		fileIn.nextLine();
		words = new String[numOfBlanks];
		
		int i = 0;
		while (fileIn.hasNextLine()){
			//for (int i = 0; i <= numOfBlanks; i++){
				words[i] = fileIn.nextLine();
				i++;
			//}
		}

	}
/**This method uses a random word generator to select a random word from the list of words.
  *
  *@return words (at certain indexes) selects a random number 
**/

	public String getRandomWord(){
				
		int randNum = rand.nextInt(words.length);
		return words[randNum];
	}
}	