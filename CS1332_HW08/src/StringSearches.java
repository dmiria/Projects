import java.util.ArrayList;



public class StringSearches {


	/**
	 * 
	 * @author D'Miria Collins
	 * Return the last function table. Remember to use the Character-Jump Heuristic
	 * you saw in recitation.
	 * 
	 * Here is a quick review:
	 * map[c] = needle.length() - 1 - index of the last occurrence of c
	 * If c does not exist in the table, initialize map[c] = needle.length()
	 * 
	 * Remember you can use the fill() method of the Arrays utility class to 
	 * fill in an array with some value.
	 * 
	 * THIS IS NOT THE SAME AS IT IS IN YOUR BOOK!!
	 * 
	 * @param string to be processed into the last function table
	 * @return a last function table
	 */
	public static int[] buildLastFunction(String needle) {
		int [] list = new int[Character.MAX_VALUE+1];
		if (needle == null){
			int [] temp = new int[0];
			return temp;
		}
		for(int i = 0; i< list.length;i++){
			list[i] = needle.length();			
		}
		for(int k = 0;k < list.length;k++){
			list[k] = Math.max(needle.length()-needle.lastIndexOf(k)-1,1);
		}

		return list;
	}

	/**
	 * Run Boyer-Moore on the given strings, and look for ALL occurrences of the needle in the haystack.
	 * Return an array that contains all of the indices where the needle occurs in the haystack.
	 * 
	 * Suppose that you find matches at index 4, 7, and 9. The array you return will have the 
	 * values 4, 7, 9. You must return an empty array if there are no matches
	 * 
	 * The running time will be tested, so if you implement this algorithm incorrectly, 
	 * you will lose points
	 * 
	 * @param haystack to search through for occurrences of the needle
	 * @param needle the pattern you wish to match in the haystack
	 * @return an array with all the occurrences of the needle in the haystack
	 */
	public static int[] boyerMoore(String haystack, String needle) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		//checks to see if the needle or haystack are null
		if(needle == null || haystack == null){
			int[] temp = new int[0];
			return temp;
			//checks to see if the needle is longer than the haystack
		} else if (needle.length() > haystack.length()){
			int[] temp = new int[0];
			return temp;
		}
		int[] table = buildLastFunction(needle);
		int a = needle.length()-1;
		int b = needle.length()-1;
		while(b < haystack.length()){
			if(needle.charAt(a) != haystack.charAt(b)){
				b += (needle.length()-1)+ table[haystack.charAt(b)] - a;
				a += (needle.length()-1)-a;
			} else if (a == 0){
				list.add(b);
				b += needle.length();
				a = needle.length()-1;
			} else {
				b = b-1;
				a = a-1;
			}
		}
		//Moves the arraylist into an int array
		int[] list2 = new int[list.size()];
		for (int i = 0; i < list.size();i++){
			list2[i] = list.get(i);
		}

		return list2;
	}

	/**
	 * Return the last function table for use with the KMP algorithm. Remember that table[i]
	 * is the length of the longest prefix that matches a suffix of needle.substring(0, i).
	 * 
	 * @param needle to build the prefix function from
	 * @return the prefix function
	 */
	
	public static int[] buildPrefixFunction(String needle) {
		if (needle == null){
			return new int[0];
		} else if (needle.length() == 1){
			int [] list = new int[1];
			list[0] = -1;
			return list;
		} else if(needle.length() == 0){
			int [] list = new int[0];
			return list;
		}
		int [] list = new int[needle.length()];

		list[0] = -1;
		list[1] = 0;
		int current = 2;//j
		int prefix = 0;//i
		while ( current < needle.length() ) {
			// match increment value and go to next pair
			if ( needle.charAt(prefix) == needle.charAt(current-1)) {
				prefix++;
				list[current] = prefix;
				current++;
			} else { // mismatch
				// when i != 0, set i = prefix[i] and leave current the same
				if (prefix > 0) {
					prefix = list[prefix];
					// set current = current + 1 and leave i the same
				} else {
					list[current] = 0;
					current++;
				}
			}
		}
		return list;
	}

	/**
	 * Run the Knuth-Morris-Pratt Algorithm (KMP) on the haystack. Return ALL occurances of the
	 * needle in the haystack. You must return an array that consists of all of the indices where
	 * the needle occurs in the haystack.
	 * 
	 * Suppose that you find matches at index 4, 7, and 9. The array you return will have the 
	 * values 4, 7, 9. You must return an empty array if there are no matches.
	 * 
	 * @param haystack to search through for occurrences of the needle
	 * @param needle the patttern you wish to match in the haystack
	 * @return an array with all the occurrences of the needle in they haystack
	 */
	public static int[] kmp(String haystack, String needle) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] kmp = buildPrefixFunction(needle);
		int i = 0;//needle index
		int j = 0;//haystack index
		if (haystack == null || needle == null){ 
			int [] temp = new int[0];
			return temp;
		} else if(needle.length()< 2){
			int [] temp = new int[0];
			return temp;
		}else if (needle.length()>haystack.length()){
			int [] temp = new int[0];
			return temp;
		}
		while (i < haystack.length()) {
			if (needle.charAt(j) == haystack.charAt(i)) {
				j++;
				if ( j == needle.length()) {
					list.add(i - needle.length() + 1);
					j = 0;
					i -= needle.length()-2;
				}
				i++;
			} else {
				if ( j == 0){
					i++;
				} else {
					j = kmp[j];
				}
			}
		}
		int[] list2 = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			list2[k] = list.get(k);
		}
		return list2;

	}


}
