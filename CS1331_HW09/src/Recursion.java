/**
 * A class with different types
 * of recursive problems
 *
 * @author Michole Washington
 *
 */
public class Recursion{
	/**
	 * Returns the number of handshakes it will
	 * take for a certain number of people to shake
	 * everyone else's hands
	 *
	 * @param hands the number of persons
	 * @return the number of handshakes
	 */
	public static int handshake(int hands){
		if (hands > 0){
			return handshake(hands-1)+(hands-1);
		}else{
			return 0;
		}
	}
	/**
	 * Returns the numbers in a
	 * hailstone sequence.
	 *
	 * @param number the number to "hailstone"
	 * @return 1 
	 */
	public static int hailstone(int number){
		System.out.println(number);
		if (number > 1){
			if (number%2==0){
				return hailstone(number/2);
			}else{
				return hailstone(3*number+1);
			}
		}
		return 1;
	}
	public static void main(String[] args){
		
		System.out.println(handshake(5));
		System.out.println(handshake(218));
		System.out.println(handshake(333));
		
		/*
		System.out.println(hailstone(5));
		System.out.println();
		System.out.println(hailstone(40));
		System.out.println();
		System.out.println(hailstone(29));
		*/
	}
}