import java.util.Scanner;
import java.io.*;

/**
  *This class puts alls of the blank types into an array, make an array to hold
  *all of the blanks, checks to see if there are any more blanks in a madlib, and
  *converts the madlib file into a string. 
  *
  *@author D'Miria Collins
  *@version 1.0
**/
												 
public class MadLib{
	private String fileName;
	private String [] blanks;
	private String [] blankTypes;
	private int counter;
/**
  *This constructs a method that opens a certain file name containing a MadLib. The
  *blanks in the MadLib are put into an array.
  *
  *@param fileName name of the file containg the particular MadLib
**/

	public MadLib(String fileName){
		this.fileName = fileName;
		
		Scanner fileIn	= null; //initializes fileIn to empty
		try{
//		Attempt to open the file
		fileIn =	new Scanner	(new File(fileName));
		
		int currentIndx = 0;
		int numOfBlanks = fileIn.nextInt();
		blankTypes = new String[numOfBlanks];
		blanks = new String[numOfBlanks];

		//fileIn.nextLine;
		
		while (fileIn.hasNext()){
//			for (int i = 0; i <= numOfBlanks; i++){
			String sentence = fileIn.next();
			if (sentence.contains("[") && sentence.contains("]")){
				String word = sentence.substring((sentence.indexOf("[")+1),sentence.indexOf("]"));
				blankTypes[currentIndx] = word; 
				currentIndx ++;
				
				}
			}
		
		}catch (FileNotFoundException	e){
//    This block executed if the files is not found
//		and then the program exists.
		System.out.println("File "+fileName+" not found");
		System.exit	(0);
		}	
	}
/**
  *This method gets the type of the next blank in the MadLib.
  *
  *@return blankTypes[counter]gets the type of the blank at the assigned slot in the array.
**/ 

	//method to get the type of the next blank 
	public String getNextType(){
		return blankTypes[counter];
	}
/**
  *This method fills the next blank with the word inputted into the method.
  *
  *@param word word to place in the blanks array
**/

	//method to fill the next blank
	public void fillNextBlank(String word){
		blanks[counter++] = word;
	}
	
	//method to determine if there are any more 
	//blanks to be filled
/**
  *This method determines if there are any more blanks to be filled
  *
  *@return counter < blanks.length 
**/

	public boolean hasMoreBlanks(){
		return counter < blanks.length;	
	}
/**
  *This method puts the entire file in a string with 10 words on each line.
  *Then it prints the string again with all of the blanks filled with the slots
  *for the new words.
  *
  *@return paragraph returns the entire MadLib
**/
	
	public String toString(){
		
		Scanner fileIn	= null; //initializes fileIn to empty
		Scanner scan = new Scanner(System.in);
		try{
		fileIn =	new Scanner	(new FileInputStream(fileName));
		}catch (FileNotFoundException	e){
		System.out.println("File not found.");
		System.exit	(0);
		}
		
		
		int counter = 0;
		String sentence;
		String sentenceAdd = "";

		int lineLength = 0;
		int numOfBlanks = fileIn.nextInt();
		
		
		while (fileIn.hasNext()){
			sentence = fileIn.next();
			if (sentence.contains("[") && sentence.contains("]")&& blanks[counter] != null){
				String word = sentence.substring(sentence.indexOf("["),sentence.indexOf("]")+1);
				sentence=blanks[counter].toUpperCase();
				counter ++;
			}
			sentenceAdd += sentence;
			sentenceAdd += " ";
			lineLength ++;
			if (lineLength == 10){
				sentenceAdd += "\n";
				lineLength = 0;
			}		
		}
		return sentenceAdd;
	}
}