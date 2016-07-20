import java.util.Random;

public class Pet{
	//instance fields should be private
	private String name;
	private int happiness = 100;
	private int hunger = 0;
		
//constructor
	public Pet(String name, int happiness, int hunger){
		//signiture is Dog(String, int,int)
		this.name = name;
		this.happiness = happiness;
		this.hunger = hunger;
	}
	public Pet(String name){
		this.name = name;
	}
	public void play(){
		if (happiness >90){
			happiness = (100 - happiness) + happiness;
		}else{
			happiness += 10 ;
		}
		System.out.println("Playtime!! Happiness "+ happiness);		
	}
	public void feed(boolean treat){
		if (true){
			if (happiness > 90){
				happiness = (100 - happiness) + happiness;		
			}else{
				happiness += 10;
			}
			if (hunger >=10){
				hunger = hunger - 10	;
			}
		}
		if (false){
			if (hunger >=10){
				hunger = hunger - 10;
				//System.out.println("You just fed your pet.");
			}
		}
		System.out.println("Yumm! More? Happiness "+ happiness + " Hunger: " + hunger);
	}							
	public void live(){
		Random rand = new Random();
		int number = rand.nextInt(100);
		if (number <= 60){
			if (hunger <90){
				hunger = hunger + 10;
			}
		}
		if (number >= 40){
			if (happiness > 10){
				happiness = happiness - 10;	
			}
		}
	}
	public String toString(){
		return "Pet name: " + name + "\nHappiness: " + happiness 
					+ "\nHunger: " + hunger;
	}		
	public String getName(){
		return name;
	}
}