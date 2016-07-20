import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
  *This class uses MadLib and WordList classes to print out three MadLibs and three 
  *random solutions.
  *
  *@author D'Miria Collins
  *@version 1.0
**/

public class MadLibDriver{
	public static void main(String[] args){

		MadLib [] madLib = new MadLib[3];
		WordList [] wordList = new WordList[4];
		
		madLib [0] = new MadLib("zooMadLib.txt");
		madLib [1] = new MadLib("mermaidMadLib.txt");
		madLib [2] = new MadLib("psychologyMadLib.txt");
		
		wordList [0] = new WordList("nouns.txt");
		wordList [1] = new WordList("verbs.txt");
		wordList [2] = new WordList("adjectives.txt");
		wordList [3] = new WordList("adverbs.txt");
		
		for (int i = 0; i<=2; i++){
			System.out.print(madLib[i]);
			System.out.println();
			System.out.println();	
			while (madLib[i].hasMoreBlanks()){
				String type = madLib[i].getNextType();
				if (type.compareTo("noun")==0){
					String random = wordList[0].getRandomWord();
					madLib[i].fillNextBlank(random);
				}else if( type.compareTo("verb")==0){
					String random = wordList[1].getRandomWord();
					madLib[i].fillNextBlank(random);	
				}else if( type.compareTo("adjective")==0){
					String random = wordList[2].getRandomWord();
					madLib[i].fillNextBlank(random);
				}else if( type.compareTo("adverb")==0){
					String random = wordList[3].getRandomWord();
					madLib[i].fillNextBlank(random);
				}
			}
		System.out.println(madLib[i]);
		System.out.println();		
		}


	}
}