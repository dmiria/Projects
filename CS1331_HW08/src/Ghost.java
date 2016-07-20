import java.util.Random;

/**
 * A Ghost in the game of Pacman.
 * 
 * @author Elizabeth
 *
 */
public class Ghost extends GameEntity {
    private Random rand;
    
    /**
     * Creates a Ghost at the specified location
     * 
     * @param location the location at which the Ghost is created
     */
    public Ghost(Location location){
        super(location, PacmanGamePanel.GHOST_IMAGE);
    }
    
    /*
     * handle what happens when a ghost runs into pacman
     *
     * if pacman is invincible, the ghost should be moved back to it's
     * origin point.
     * 
     */
    @Override
    public boolean collide(GameObject object) {
         if (location.equals(object.getLocation())){
				System.out.println("i'm in this location");
				if(object instanceof Pacman){
					System.out.println("object is a pacman");
				   Pacman p = (Pacman)object;
		  			if (p.isInvincible()){
						System.out.println("invincible");
						moveToOrigin();
					}
				}
				return true;
			}
			return false;
    }

    /*
     * Ghosts move in a special way, so we need to override the move defined in
     * GameEntity.
     * 
     * When move is called, a Ghost should have an 80% chance of actually moving.
     * 
     * If it can continue going in the direction it is facing, it should move that way.
     * 
     * If not, it should pick a way to turn (right or left), and turn until it can move in 
     * the direction it is facing.
     */
    @Override
    public void move(Level level) {
        rand = new Random();
		  int randMove = rand.nextInt(10);
		  
		  if (randMove < 8){
		  	  super.move(level);
			 /* Location clone = location.clone();
		  	  clone.moveByDirection(super.getFacingDirection());
			  System.out.println(super.getFacingDirection());
		     if (!level.isValidLocation(clone)){
			     int num = rand.nextInt(2);
						if (num==0){
							turn(true);
						}
						else{
							turn(false);
						}
        	     location.moveByDirection(super.getFacingDirection());
				  System.out.println(super.getFacingDirection());
			}	*/
			}	
		  else{
		  		Location clone = location.clone();
				clone.moveByDirection(super.getFacingDirection());
		  		while(!level.isValidLocation(clone)){
						int num = rand.nextInt(2);
						if (num==0){
							turn(true);
						}
						else{
							turn(false);
						}
						clone = location.clone();
						clone.moveByDirection(super.getFacingDirection());
				}
			}	 
    }
}
