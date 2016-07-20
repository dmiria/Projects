/**
 * This class contains the logic for a Rock, Paper, Scissors game.
 * It determines who won based on the choices of rock, paper, or scissors.
 * It contains constants for rock, paper, and scissors.
 *
 * @author D'Miria Collins
 * @version 1.0 2/15/13
 */
public class RPSGame{
	private RPSPlayer player1;
	private RPSPlayer player2;
	
	public RPSGame(RPSPlayer player1, RPSPlayer player2){
		this.player1 = player1;
		this.player2 = player2;
	}	

//import java.util.Random;

	public String pickWinner(){ 
	//Random generator = new Random();
	 
	String ROCK = "rock";
   String PAPER = "paper";
   String SCISSORS = "scissors";
	String winner;
		
		
	String player1Choice = player1.getChoice();
	String player2Choice = player2.getChoice();
		
		
		while (player1Choice.equals(PAPER)){
			if (player2Choice.equals(SCISSORS)){
				player2.changeScore();
				winner = player2.getName();
				return winner;

			}else	if(player2Choice.equals(PAPER)){
				player1.getScore();
				player2.getScore();
				return "it's a tie";
			}else{//(player2Choice.equals(ROCK)){
				player1.changeScore();
				winner = player1.getName();
				return winner;

			}
		}
		while (player1Choice.equals(SCISSORS)){
			if ( player2Choice.equals(SCISSORS)){
				player1.getScore();
				player2.getScore();
				return "it's a tie";
			}else	if(player2Choice.equals(PAPER)){
				player1.changeScore();
				winner = player1.getName();
				return winner;

			}else{//(player2Choice.equals(ROCK)){
				player2.changeScore();
				winner = player2.getName();
				return winner;
			}
		}
		while(player1Choice.equals(ROCK)){
			if ( player2Choice.equals(SCISSORS)){
				player1.changeScore();
				winner = player1.getName();
				return winner;
			}else	if(player2Choice.equals(PAPER)){
				player2.changeScore();
				winner = player2.getName();
				return winner;
			}else{//(player2Choice.equals(ROCK)){			
				player1.getScore();
				player2.getScore();
				return "it's a tie";
								
			}
		}

		return "you don't know how to play this game";
		}
}
