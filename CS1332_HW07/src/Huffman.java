import java.util.*;



/**
 * @author D'MiriaCollins
 * 
 */

class EncodedString{

	public void concat(EncodedString s) {
		// TODO Auto-generated method stub
		
	}

	public void zero() {
		// TODO Auto-generated method stub
		
	}

	public void one() {
		// TODO Auto-generated method stub
		
	}

	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}}

class Node{

	public Object left;
	public Object right;
	public Character character;
	public int frequency;

	public Node(Character key, Integer value) {
		// TODO Auto-generated constructor stub
	}

	public Node(Node l, Node r) {
		// TODO Auto-generated constructor stub
	}}

public class Huffman {
	
	private static Map<Character, EncodedString> huff;

	
	/**
	 * Builds a frequency map of characters for the given string.
	 * 
	 * This should just be the count of each character.
	 * 
	 * @param s
	 * @return
	 */
	public static Map<Character, Integer> buildFrequencyMap(String s) {
		Map<Character,Integer> huff = new HashMap<Character,Integer>();
		for(char character : s.toCharArray()) {
			Integer count = huff.get(character);
			if(count == null) {
				count = 0;
			}
			huff.put(character, count + 1);
		}
		return huff;
	}
	
	/**
	 * Build the Huffman tree using the frequencies given.
	 * 
	 * The frequency map will not necessarily come from the buildFrequencyMap() method.
	 * 
	 * @param freq
	 * @return
	 */
	public static Node buildHuffmanTree(Map<Character, Integer> freq) {
		PriorityQueue<Node> huff = new PriorityQueue<Node>();
		Set<Map.Entry<Character,Integer>> huffman = freq.entrySet();
		for (Map.Entry<Character,Integer> entry : huffman) {
			huff.add(new Node(entry.getKey(), entry.getValue()));
		}
		while (huff.size() > 1) {
			Node l = huff.remove();
			Node r = huff.remove();
			Node p = new Node(l,r);
			huff.add(p);
		}
		return huff.peek();
	}
	/**
 	 * Traverse the tree and extract the encoding for each character in the tree
 	 * 
 	 * The tree provided will be a valid huffman tree but may not come from the buildHuffmanTree() method.
 	 * 
 	 * @param tree
 	 * @return
 	 */
 	public static Map<Character, EncodedString> buildEncodingMap(Node tree) {
 		huff = new HashMap<Character, EncodedString>();
 		treeTraversal(new EncodedString(), tree);
 		return huff;
 	}
	
	
	/**
	 * Helper method for buildEncodingMap method.
	 *
	 * @param theString
	 * @param current
	 * 
	 */
	private static void treeTraversal(EncodedString s, Node n) {
		EncodedString list = new EncodedString();
		EncodedString list2 = new EncodedString();

		list.concat(s);
		list2.concat(s);
		
		if(n.left == null && n.right == null) {
			huff.put(n.character, list);
		}
		
		if(n.left != null) {
			list.zero();
			treeTraversal(list, n.left);
		}
		
		if(n.right!= null) {
			list2.one();
			treeTraversal(list2, n.right);
		}
		
		
	}
	
 	
	private static void treeTraversal(EncodedString list, Object left) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Encode each character in the string using the map provided.
	 * 
	 * If a character in the string doesn't exist in the map ignore it.
	 * 
	 * The encoding map may not necessarily come from the buildEncodingMap() method, but will be correct
	 * for the tree given to decode() when decoding this method's output.
	 * 
	 * @param encodingMap
	 * @param s
	 * @return
	 */
	public static EncodedString encode(Map<Character, EncodedString> encodingMap, String s) {
		EncodedString list = new EncodedString();
		
		for (char character : s.toCharArray()) {
			if(encodingMap.containsKey(character)) {
				list.concat(encodingMap.get(character));
			}
		}
		return list;
	}
	
	/**
	 * Decode the encoded string using the tree provided.
	 * 
	 * The encoded string may not necessarily come from encode, but will be a valid string for the given tree.
	 * 
	 * (tip: use StringBuilder to make this method faster -- concatenating strings is SLOW)
	 * 
	 * @param tree
	 * @param es
	 * @return
	 */
	/*public static String decode(Node tree, EncodedString es) {
		StringBuilder list = new StringBuilder();
		Node n = tree;
		
		if(es.length() == 0 || tree.frequency == 1 ) {
			list.append(n.character);
		}

		
		for(byte number : es) {
			if(number == 0) {
				n = (Node) n.left;
			} else {
				n = (Node) n.right;
			}
			
			if(n.left == null && n.right == null) {
				list.append(n.character);
				n = tree;
			} 
	
		}
		return list.toString();
	}*/
}
