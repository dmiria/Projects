import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Timer;

/**
 * Pacman in a game of Pacman.
 * 
 * @author Elizabeth
 *
 */
public class Pacman extends GameEntity implements Movable{
    //whether or not pacman is invincible
    private boolean invincible;
    //pacman's score
    private int score;
    //the number of lives pacman has left
    private int lives;
    
    /**
     * Creates a new Pacman with 3 lives at the given location. 
     * 
     * @param location the location at which the pacman is created
     */
    public Pacman(Location location) {
        super(location, PacmanGamePanel.PACMAN_IMAGE);
		  lives = 3;
    }
    
    /*
     *  If pacman collides with another pacman, simply return 
     *  that pacman hit something
     *  
     *  If with an item, pick up that item
     * 
     *  If with a ghost and invincible, return that pacman hit something 
     *  
     *  If with a ghost and not invincible, be eaten, lose a life, start back at origin point
     * 
     */
    @Override
    public boolean collide(GameObject object){
	 	  boolean collide = location.equals(object.getLocation());
        if (collide){
		  		if (object instanceof Pacman){
					return true;
				}
				else if (object instanceof GameItem){
					pickUpItem((GameItem)object);
					return true;
				}
				else if (object instanceof Ghost){
					if (invincible){
						return invincible;
					}
					else{
						loseLife();
					}
				}
			}
			return false;
    } 
    
    /*
     * Helper method that allows pacman to pick up the item that
     * it collided with.
     * 
     * When an item is picked up, the score should be increased and
     * invincibility handled correctly if the item is a cherry
     */
    private void pickUpItem(GameItem item){
			if (item instanceof Pellet){
				score += item.getValue();
			}
			else if(item instanceof Cherry){
				score += item.getValue();
				invincible = true;
			}
    }
    
    /**
     * Causes pacman to no longer be invincible
     */
    public void loseInvincibility(){
        invincible = false;
    }
    
    /**
     * Returns whether or not pacman is invincible
     * 
     * @return the state of pacman's invincibility 
     */
    public boolean isInvincible(){
	 	    return invincible;
    }
    
    /**
     * Causes pacman to lose a life and
     * move back to its origin point
     */
    public void loseLife(){
	    if (lives > 0){
        lives--;
		  moveToOrigin();
		 }
    }
    
    /**
     * Returns the number of lives that pacman has left
     * @return the number of lives that pacman has left
     */
    public int getLives(){
        return lives;
    }
    
    /**
     * Returns pacman's score
     * @return pacman's score
     */
    public int getScore(){
        return score;
    }

    // handles the rotation of the image depending on what direction pacman is facing
    // do not worry about how this code works :]
    @Override
    public void draw(Graphics g) {

        g.translate(location.getCol() * PacmanGamePanel.IMAGE_WIDTH
                + PacmanGamePanel.IMAGE_WIDTH / 2, location.getRow()
                * PacmanGamePanel.IMAGE_HEIGHT + PacmanGamePanel.IMAGE_HEIGHT
                / 2);

        switch (getFacingDirection()) {
            case Movable.NORTH :
                ((Graphics2D) g).rotate(-Math.PI / 2);
                break;
            case Movable.SOUTH :
                ((Graphics2D) g).rotate(Math.PI / 2);
                break;
            case Movable.WEST :
                ((Graphics2D) g).rotate(Math.PI);
                break;

        }

        g.translate(-location.getCol()*PacmanGamePanel.IMAGE_WIDTH - PacmanGamePanel.IMAGE_WIDTH / 2,
                -location.getRow()* PacmanGamePanel.IMAGE_HEIGHT - PacmanGamePanel.IMAGE_HEIGHT / 2);
        super.draw(g);
    }
    

    
}
