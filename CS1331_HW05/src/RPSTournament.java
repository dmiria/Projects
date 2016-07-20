import java.util.Scanner;
import java.util.Random;
/**
 * This class creates the tournament and runs the main method 
 * the classes.
 * 
 * The static method allows the computer to create a random choice between
 * paper, scissors, and rock. This allows the computer to compete against the 
 * user. The user inputs their name and continues to choose rock,
 * paper or scissors to try and win the game. It also allows you to
 * determine how many games you want.
 *
 * @author D'Miria Collins
 * @version 1.0 2/15/13
 *
 * 
 */
public class RPSTournament{
	//private String rivalDecide;
	
	public static String getRivalChoice(){
		Random generator = new Random(2);
		int rivalChoice = generator.nextInt();
		if (rivalChoice == 0){
			String rivalDecide = "rock";
			return rivalDecide;
		}else if(rivalChoice == 1){
			String rivalDecide = "paper";
			return rivalDecide;
		}else{
			String rivalDecide = "scissors";
			return rivalDecide;
		} 
	}
	public static void main(String [] args){
		Scanner keyboard = new Scanner(System.in);		
		System.out.print("Please enter your name: ");
		String playerName = keyboard.nextLine();
		RPSPlayer player1 = new RPSPlayer(playerName, 0);
		RPSPlayer player2 = new RPSPlayer("Your Rival",0);
		
		
		System.out.print("Enter the number of games you wish to play: ");
		int gameNumber = keyboard.nextInt();
		
		int counter = 1;
		
		while(counter <= gameNumber){
			RPSGame newGame = new RPSGame(player1,player2);
			//String winningPlayer = newGame.pickWinner();
			//changeScore()
				
			System.out.print(playerName + ", enter your choice: "); 
			String newChoice = keyboard.next();
			
			System.out.println("Your Rival chose "+ getRivalChoice());	
			System.out.printf("Current Score: %s - %d \t Your rival - %d", playerName, player1.getScore(), player2.getScore());
			System.out.println();
			counter++;	
	}
}
}