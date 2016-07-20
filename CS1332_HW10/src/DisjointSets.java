import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author D'MiriaCollins
 *
 * @param <T>
 */
public class DisjointSets<T> {
	
	private Map<T, Node<T>> map;
	
	/**
	 * Takes in a set of generic type objects. 
	 * Here you need to wrap each object T in a Node and then add the pair of object T and its resulting 
	 * node to a HashMap.
	 * Conceptually you can think of this step as making each node to be its own disjoint set. 
	 * Then whenever you need you can use merge function to merge these little disjoint sets.
	 */
	public DisjointSets(Set<T> set) {
		if(set != null){		
			map = new HashMap<T,Node<T>>();
			for (T object: set){
				map.put(object,new Node<T>(object));	
			}
		}
	}
	
	/**
	 * In this method you need to do path compression for object o:
	 * 1) wrap the object o in a Node
	 * 2) find the root of the disjoint set that o is attached to call it root
	 * 3) then make the root be the parent of o
	 * 
	 * @param o 	an object of type T whose root is to be found
	 * @return 		the root of the vertex taken in
	 */
	
	public T findParent(T o) {
		Node<T> root = map.get(o);
		Node<T> node = root;
		if (root.getParent() == null){
			return o;
		}
		boolean loop = true;
		while(loop){
			if(node.getParent() != null){
				node = node.getParent();
			}
			loop = false;
		}
		root.setParent(node);
		return root.data;
	} 

	
	/**
	 * points the root of the firstObject to the root of the secondObject.
	 * If they already have the same root don't do anything.
	 *  
	 * @param firstObject an object of type T who is to be merged with parameter secondObject
	 * @param firstObject an object of type T who is to be merged with parameter firstObject
	 */
	
	public void merge(T firstObject, T secondObject) {
		T a = findParent(firstObject);
		T b = findParent(secondObject);
		Node<T> first = map.get(a);
		Node<T> second = map.get(b);		
		//same root
		if(a == null || b == null || a == b){
			return;
		}		
		if (!first.equals(second)){
			first.parent = second;
//			second.setParent(first.getParent());
		}					
	}
	

	/**
	 * Basic node class for use with DisjointSet
	 */
	private class Node<T> {

		private T data;
		private Node<T> parent;

		/**
		 * set the data to be the given data and set parent to null
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
			this.parent = null;
		}

		/**
		 * set the data and parent to the given values
		 * @param data
		 * @param parent
		 */
		public Node(T data, Node<T> parent) {
			this.parent = parent;
			this.data = data;
		}

		/*implement all the setters and getters below*/
		public void setData(T data) {
			this.data = data;
		}

		public void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public T getData() {
			return data;
		}

		public Node<T> getParent() {
			return parent;
		}
	}

}