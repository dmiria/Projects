/**
 * This creates a class that defines the players
 * 
 * 
 *
 *
 * @author D'Miria Collins
 * @version 1.0 2/15/13
 */
public class RPSPlayer{
	private String name;
	private int score = 0;
	private String choice;
	
	public RPSPlayer(String name,int score){
		this.name = name;
		this.score = score;
		
	}
	public String getName(){
		return name;
	}
	public String getChoice(){
		return choice;
	}
	public void setChoice(){
		this.choice = choice;
	}
		
	public int changeScore(){
		score ++;
		return score;
	}
	public int getScore(){
		return score;
	}
}