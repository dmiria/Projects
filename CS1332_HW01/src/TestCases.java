import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

/** 
 * SampleTestCases makes some test cases and tests them!
 * 
 * What is @Test? you need to have @Test above a method declaration if you want JUnit to use that
 * method as a test case.
 * 
 * Note that the String parameter in the following assertTrue, assertFalse, assertEquals, 
 * and assertNull methods is optional.
 * If you put the String it will show the string if the test case fails if you don't
 * provide the String, it will simply flag the test as failed and won't show any 
 * message.
 * 
 * @author saman
 * 
 */
public class TestCases {

	/**
	 * Testing addNumbers(int, int) method
	 * 
	 * retVal holds the result of adding two integers passed in as parameters
	 * into addNumbers(int,int) method.
	 * 
	 * assertEquals(String message, Object expected, Object actual) checks the
	 * actual value against the expected value, if they are equal the test will
	 * pass, if they are not equal the test won't pass and the message will be
	 * shown.
	 * 
	 * Note: the String message parameter is optional.
	 */
	@Test
	public void testAddNumbers() {
		int retval = SimpleClass.addNumbers(10, -8);
		assertEquals("10 + (-8) is supposed to be 2 ", 2, retval);
	}

	/**
	 * Testing sameNumbers(int, int) method
	 * 
	 * retVal holds true if the parameters of sameNumbers(int,int) method are
	 * equal, and holds false otherwise. If condition is true the test will
	 * pass, if the condition is false the test won't pass and the message will
	 * be shown.
	 * 
	 * assertTrue(String message, boolean condition) checks if condition is
	 * true.
	 * 
	 */
	@Test
	public void testSameNumbers0() {
		boolean retval0 = SimpleClass.sameNumbers(1, 1);
		assertTrue(
				"true expected, but the sameNumbers method reuturned false",
				retval0);
	}

	/**
	 * Testing sameNumbers(int, int) method
	 * 
	 * retVal holds true if the parameters of sameNumbers(int,int) method are
	 * equal, and holds false otherwise.If condition is false the test will
	 * pass, if the condition is true the test won't pass and the message will
	 * be shown.
	 * 
	 * assertFalse(String message, boolean condition) checks if condition is
	 * false.
	 * 
	 */
	@Test
	public void testSameNumbers1() {
		boolean retval1 = SimpleClass.sameNumbers(2, 1);
		assertFalse(
				"false expected, but the sameNumbers method returned true",
				retval1);
	}

	/*****************************************
	 * Now it's your turn!
	 * Follow the instructions for each method.
	 * 
	 * 
	 * NOTE: Don't forget to put @Test above each method. If you are confused on Syntax
	 * look at the sample methods we provided and use those as references.
	 *****************************************/
	
	/**
	 * Use assertEquals to test hello() method 
	 */
	@Test
	public void testHello0(){
		String greeting = SimpleClass.hello();
		assertEquals("Hello World was expected","Hello World",greeting);
	}
	
	/**
	 * Use assertEquals to test hello(String) method
	 * 
	 */
	@Test
	public void testHello1() {
		String specificGreeting = SimpleClass.hello("Michole");
		assertEquals("Hello Michole was expected","Hello Michole", specificGreeting);
	}
	
	/**
	 * Use assertEquals to test helloThing(T) method
	 */
	@Test
	public void testHelloThing() {
		String greetThing = SimpleClass.helloThing("Abracadabra");
		assertEquals("Hello Abracadabra", greetThing);
	}
	
	/**
	 * Use assertTrue to test Same(String, String) method
	 */
	@Test
	public void testSame0() {
		boolean sameValueChecker = SimpleClass.same("happy","happy");
		assertTrue("expected true, but the same method returned false",
				sameValueChecker);
	}

	/**
	 * Use assertFalse to test Same(String, String) method
	 */
	@Test
	public void testSame1() {
		boolean sameValueChecker1 = SimpleClass.same("CS1332", "2331SC");
		assertFalse("expected false, but the same method returned true",
				sameValueChecker1);
	}

	/**
	 * Use assertTrue to test strictlyLess(T, T) method
	 */
	@Test
	public void testStrictlyLess0() {
		boolean lesserValue = SimpleClass.strictlyLess(5, 19);
		assertTrue("expected true, but the strictlyLess method returned false",
				lesserValue);
	}
	
	/**
	 * Use assertFalse to test strictlyLess(T, T) method
	 */
	@Test
	public void testStrictlyLess1() {	
		boolean lesserValue1 = SimpleClass.strictlyLess(10, 4);
		assertFalse("expected false, but the strictlyLess method returned true",
				lesserValue1);
	}
	
	/**
	 * Use assertTrue to test strictlyLess(T, T, Comparator<T>) method
	 */
	@Test
	public void testStrictlyLess2() {
		boolean lesserValue2 = SimpleClass.strictlyLess(1, 12, new ComparatorMethod());
		assertTrue("expected true, but the strictlyLess method returned false",
				lesserValue2);
	}
	
	/**
	 * Use assertFalse to test strictlyLess(T, T, Comparator<T>) method
	 */
	
	@Test
	public void testStrictlyLess3() {
		boolean lesserValue3 = SimpleClass.strictlyLess(123, 123, new ComparatorMethod());
		assertFalse("expected false, but the strictlyLess method returned true",
				lesserValue3);

	}
	
	private class ComparatorMethod implements Comparator <Integer>{
		public int compare(Integer a, Integer b){
			return a.compareTo(b);
		}
	}
}