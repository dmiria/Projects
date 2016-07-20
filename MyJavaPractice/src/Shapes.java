/**
 * Creating a new class to call in the main method
 * Adding attributes or behaviors of the object.
 * 
 * */

public class Shapes {
	/**
	 * Constructors
	 * Attributes & Behaviors - as many as you want 
	 * Good practice to keep them private and access them using getters and setters.
	 * */
	private int edges;
	private String shape;
	private String color;
	private double area;
	private double perimeter;
	
	//must be the same name as the class
	//Parameters can initialize attributes.
	Shapes(int e, String s, String c, Double a, Double p){
		//constructors
		this.edges = e;
		this.shape = s;
		this.color = c;
		this.area = a;
		this.perimeter = p;
		
	}
	//Constructed with nothing instantiated
	//Objects can be added as I go.
	Shapes(){ 
		this.setColor("magenta");
	}
	
	
	/**
	 * Methods
	 * */
	String color(){
		System.out.println(color);
		return color;
	}

	void edges(int edges){
		if (edges <=2){
			System.out.println("Not a shape");
		} else if (edges == 3){
			System.out.println("Triangle");
		} else if (edges == 4){
			if (square()){
				System.out.println("Square");
			} else {
				System.out.println("Rectangle");
			}
		} else {
			System.out.println("unknown");
		}
	}

	boolean square(){
		return true;
	}

	/**Getters & Setters*/
	public int getEdges(){
		return edges;
	}
	public void setEdges(int i){
		this.edges = i;
	}
	
	public String getShape(){
		return shape;
	}
	
	public void setShape(String s){
		this.shape = s;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String c){
		this.color = c;
	}
	
	public double getArea(){
		return area;
	}
	
	public void setArea(Double a){
		this.area = a;
	}
	
	public double getPerimeter(){
		return perimeter;
	}
	
	public void setPerimeter(Double p){
		this.perimeter = p;
	}
}
