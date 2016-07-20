//import java.util.Scanner;

public class MyClass {	
	/**
	 * Main method instantiated here. 
	 * 
	 * */
	public static void main(String[] args) {
		Shapes sq = new Shapes();
		//instantiate the variable of the object
		sq.setColor("blue");
		sq.setArea(500.0);
		sq.setEdges(4);
		
		sq.color();
		sq.edges(sq.getEdges());
		

	}
	
	/**
	 * methods instantiated
	 * 
	 * */
	
	void TestMethod(){
		//Example of a method in the main class.
	}
	

}
