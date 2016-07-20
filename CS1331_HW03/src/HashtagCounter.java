import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HashtagCounter{
	public static void main(String[] args){
	
		try{
			Scanner fileIn = null;
			fileIn = new Scanner (new FileInputStream("hashtags.csv"));
			
			fileIn.useDelimiter(",");
			
			System.out.println("Please enter a hashtag.");
			Scanner scan = new Scanner(System.in);
			String hashtag = scan.nextLine();
			
			int search = 0;
			int hashtagCounter = 0;
			while (fileIn.hasNextLine())
			{
				String compare = fileIn.next();
				hashtagCounter = hashtagCounter+1;
				
				if (compare.equals(hashtag))
				{
					search = search + 1;
				}
			}
			
			fileIn.close();
			System.out.println("The hashtag " + hashtag + " appears " + search + " times out of a total of " + hashtagCounter + " entries."); 
		}
		catch (FileNotFoundException e)
		{
		System.out.println("File not found.");
		System.exit(0);
		}
	}
}