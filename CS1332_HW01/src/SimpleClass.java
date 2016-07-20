import java.util.Comparator;

/**
 * @author D'Miria Collins
 */
public class SimpleClass {

    /**
     * This method just adds two numbers. This method is just for reference, you
     * do not need to add anything to this. We have this for the sample JUnit
     * test cases we have provided for you.
     * @param a
     * @param b
     * @return addition of the two numbers
     */
    public static int addNumbers(int a, int b){
        return a+b;
    }
    /**
     * This method just checks if two ints are the same. This method is just for reference, you
     * do not need to add anything to this. We have this for the sample JUnit
     * test cases we have provided for you.
     * @param a
     * @param b
     * @return if two numbers are equal or not
     */
    public static boolean sameNumbers(int x, int y){
        return x==y;
    }

    /**
     * This method will just return "Hello World"
     * @return the string "Hello World"
     *
     *Example : hello()
     *Return Value : Hello World
     */
    public static String hello() {
        return "Hello World";
    }
    
    /**
     * This method concatenates "Hello" with another string and returns that
     * @param name someone's name
     * @return the string "Hello " + name
     *
     *Example : hello("Saman")
     *Return Value : Hello Saman
     *
     */
    public static String hello(String name) {
        return "Hello " + name;
    }
    
    /**
     * this is how you use generic types in static methods
     * 
     * @param thing something of type T
     * @return the string "Hello " + thing
     *
     *Example : helloThing(1)
     *Return Value : Hello 1
     *
     *Example : helloThing("Akbar")
     *Return Value : Hello Akbar
     */
    public static <T> String helloThing(T thing) {
        return "Hello " + thing;
    }
    
    
    /**
     * you should always use .equals() when checking equality, NOT == or .compareTo()
     * 
     * @param a
     * @param b
     * @return true if the objects are equal, check using the equals method
     *
     *Example : same("abcde","ABCDE")
     *Return Value : false
     *
     *Example : same("ABCDE","ABCDE")
     *Return Value : true
     *
     *Example: same(null, null)
     *Return Value : true
	 *
     *Example: same("yoohaha", null)
     *Return Value : false
     *
     *Example: same(null, "muhaha")
     *Return Value : false
     *
     */
    public static boolean same(String a, String b) {
    	if (a.equals(b)){
    		return true;
    	}
    	return false;
    }
    
    /**
     * this is how you use a generic that is comparable
     * 
     * @param a (assume never null)
     * @param b (assume never null)
     * @return true if a < b, check by using compareTo
     *
     * Example strictlyLess(1,2)
     * return true
     * 
     * Don't worry about null checking
     */
    public static <T extends Comparable<T>> boolean strictlyLess(T a, T b) {
        if (a.compareTo(b)< 0){
        	return true;
        }
    	return false;
    }
    
    /**
     * this is how you use a comparator
     * @param <T>
     * 
     * @param a
     * @param b
     * @param comparator
     * @return true if a < b, check using the comparator
     *
     *Example : strictlyLess(1,2)
     *Return Value : true
     *
     *Don't worry about null checking
     */
      	
    
    public static <T> boolean strictlyLess(T a, T b, Comparator<T> comparator) {
    	if (comparator.compare(a,b)<0){
    		return true;
    	}
    	return false;
    }
    
}