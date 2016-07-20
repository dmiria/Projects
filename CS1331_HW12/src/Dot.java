import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Dot {
    private static final int DIAMETER = 20;
    private Point point;
    private Color color;
    
   /**
     * Create a new dot at the specified point with the 
     * specified color - note, the point should be the CENTER 
     * of the dot
     * 
     * @param point
     * @param color
     */
	public Dot(Point point, Color color){
   //this.point = point;
   	this.color = color;
   	this.point =new Point((int)(point.getX()-DIAMETER/2),(int)(point.getY())-DIAMETER/2);
  
    }
    
   /**
     * Draw the dot on the graphics object - remember, the point
     * is the dot's center
     * 
     * @param g
     */
    public void draw(Graphics g){
    	g.setColor(color);
     	g.fillOval((int)point.getX(),(int)point.getY(),DIAMETER,DIAMETER);
    }
    
   /**
     * Determine if the given point is within the dot
     * 
     * @param p
     * @return
     */
    public boolean contains(Point p){
    	return point.distance(p) <= point.distance(point.getX()+DIAMETER/2,point.getY());
    }
    
   /**
     * Determine if the dot is equal to the object. To be equal,
     * the object must be a dot, and it must be at the same location 
     * and have the same color
     * 
     * @return boolean
     */
    public boolean equals(Object o){
  		if(o instanceof Dot)
    		return (((Dot)o).getColor().equals(color)) && (((Dot)o).getPoint().equals(point));
 			return false;
 	}
    
   /**
     * Get the color of the dot
     * 
     * @return
     */
    public Color getColor(){
       return color;
    }
    
   /**
     * Get the location of the dot
     * 
     * @return
     */
    public Point getPoint(){
        return point;
    }
    
   /**
     * Get a string representation of the dot - this should contain
     * the color of the dot and it's location. If the color is Red, Green, or Blue,
     * it should state that. Otherwise, it should just have the values of rgb for the
     * unknown colors (Hint: Color has a useful toString for getting the rgb values)
     * 
     * @return String
     */
    public String toString(){
    	String string; 
		if (color.toString().equals("Red")){
			string = "Red dot at " + point;
		 }else if (color.toString().equals("Green")){
		  	string = "Green dot at " + point;
		 }else if (color.toString().equals("Blue")){
		  	string = "Blue dot at " + point;
		 }else{
		  	string = color.toString() + " at " + point;
		 }
		 return string;
    }
}
