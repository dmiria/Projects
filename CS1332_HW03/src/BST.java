import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author D'Miria Collins
 * 
 * @date 5/28/2013
 */
public class BST<T extends Comparable<T>> {

	private Node<T> root;
	private int size = 0;
	private ComparatorMethod comp = new ComparatorMethod();
	private T removedData;
	
	
	/**
	 * Adds a data entry to the BST
	 * 
	 * null is positive infinity
	 * 
	 * @param data The data entry to add
	 */

	public void add(T data) {
		root = helperMethod(root, data);
		size ++;

	}
	/**
	 * Recursive method that adds and implements the 
	 * comparator method to compare the node data and 
	 * the data entered.
	 * 
	 * @return new node added into the tree
	 * 
	 */

	private Node<T> helperMethod(Node<T> n, T data){
		if (n == null){
			return new Node<T>(data);
		}
		if(comp.compare(data, n.getData())<0){
			n.setLeft(helperMethod(n.getLeft(), data));
			return n;
		}else{
			n.setRight(helperMethod(n.getRight(), data));
			return n;
		}
	}

	/**
	 * Adds each data entry from the collection to this BST
	 * Read the collections api if you have questions 
	 * 
	 * 
	 * @param c
	 */

	public void addAll(Collection<? extends T> c) {
		for (T dataNum: c){
			add(dataNum);
		}
	}

	/**
	 * Removes a data entry from the BST
	 * 
	 * null is positive infinity
	 * 
	 * @param data The data entry to be removed
	 * @return The removed data entry (null if nothing is removed)
	 */
	public T remove(T data) {
		root = removeHelper(root, data);
		
		return removedData;
	}
	
	/**
	 * The remove helper method recursively removes
	 * a data entry from the BST.
	 * 
	 * @param n
	 * @param data
	 * @return
	 */
	
	private Node<T> removeHelper(Node<T> n ,T data){
		if (n == null){
			removedData = null;
			return null;
		}
		
		if (comp.compare(data, n.getData())==0){
			if (n.getLeft() == null){
				size--;
				removedData = n.getData();
				return n.getRight();

			}else if (n.getRight()== null){
				size--;
				removedData = n.getData();
				return n.getLeft();
			}else{
				size--;
				removedData = n.getData();
				return getSuccessor(n);
			}
		}else if (comp.compare(data, n.getData())< 0){
			n.setLeft(removeHelper(n.getLeft(),data));

		}else{
			n.setRight(removeHelper(n.getRight(),data));
		}
		return n;
	}
	
	/**
	 * A helper method that helps the helper. It helps 
	 * iterate through the BST
	 * 
	 * @param n
	 * @return
	 */
	
	private Node<T> getSuccessor (Node<T> node){
		//parent
		Node<T> temp = null;
		Node<T> successor = node.getRight();
				
		while (successor.getLeft() != null){
			temp = successor;
			successor = successor.getLeft();
		}
		node.setData(successor.getData());
		
		if (temp == null){
			node.setRight(successor.getRight());
			
		}else{
			temp.setLeft(successor.getRight());
		}
		
		return node;
	}


	/**
	 * Checks if the BST contains a data entry
	 * 
	 * null is positive infinity
	 * 
	 * @param data The data entry to be checked
	 * @return If the data entry is in the BST 
	 */
	public boolean contains(T data) {
		return containHelper(root, data);

	}
	
	/**
	 * Contains helper that checks the tree to see 
	 * if the tree contains the parameter.
	 * 
	 * @param
	 * @return 
	 */

	private boolean containHelper(Node<T> n, T data){
		if (n == null){
			return false;
		}
		if (comp.compare(data, n.getData())==0){
			return true;
		}else if (comp.compare(data, n.getData())<0){
			return containHelper(n.getLeft(), data);
		}else{
			return containHelper(n.getRight(), data);
		}

	}

	/**
	 * Finds the pre-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in pre-order
	 */
	
	public List<T> preOrder() {
		List <T> list  = new LinkedList <T> ();
		preOrderHelper(list, root);
		return list;
	}
	/**
	 * PreOrder helper method that helps traverse throught the 
	 * tree 
	 * 
	 * @param
	 * @return
	 */
	private void preOrderHelper(List<T> list, Node<T> n){
		if (n == null){
			return;
		}
		list.add(n.getData());
		preOrderHelper(list, n.getLeft());
		preOrderHelper(list, n.getRight());
		
	}

	/**
	 * Finds the in-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in in-order
	 */
	public List<T> inOrder() {
		List <T> list  = new LinkedList <T> ();
		inOrderHelper(list, root);
		return list;
	}
	/**
	 * InOrder helper method that helps traverse through the 
	 * BST.
	 * 
	 * @param list
	 * @param n
	 */
	
	private void inOrderHelper(List<T> list, Node<T> n){
		if (n == null){
			return;
		}
		inOrderHelper(list, n.getLeft());
		list.add(n.getData());
		inOrderHelper(list, n.getRight());	
	}
	

	/**
	 * Finds the post-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in post-order
	 */
	public List<T> postOrder() {
		List <T> list  = new LinkedList <T> ();
		postOrderHelper(list, root);
		return list;
	}
	/**
	 * Postorder helper that helps traverse through the
	 * BST.
	 * 
	 * @param list, n
	 * @param n
	 */
	
	private void postOrderHelper(List<T> list, Node<T> n){
		if (n == null){
			return;
		}
		postOrderHelper(list, n.getLeft());
		postOrderHelper(list, n.getRight());
		list.add(n.getData());
	}

	/**
	 * Checks to see if the BST is empty.
	 * This is trivial since you have a size variable
	 * 
	 * @return If the BST is empty or not
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Clears this BST
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * @return the size of this BST
	 */
	public int size() {
		return size;
	}

	/**
	 * First clears this BST, then reconstructs the BST that is
	 * uniquely defined by the given preorder and inorder traversals.
	 * Draw this out on paper, it will make it much easier to code.
	 * 
	 * (When you finish, this BST should produce the same preorder and
	 * inorder traversals as those given)
	 * 
	 * @param preorder a preorder traversal of the BST to reconstruct
	 * @param inorder an inorder traversal of the BST to reconstruct
	 */
	public void reconstruct(List<? extends T> preorder, List<? extends T> inorder) {
		if (preorder == null && inorder == null){
			return;
		}
		clear();
		addAll(preorder);
	}


	/*
	 * The following methods are for grading, do not modify them
	 */

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static class Node<K extends Comparable<K>> {

		private K data;
		private Node<K> left, right;

		public Node(K data) {
			setData(data);
		}

		public K getData() {
			return data;
		}

		public void setData(K data) {
			this.data = data;
		}

		public Node<K> getLeft() {
			return left;
		}

		public void setLeft(Node<K> left) {
			this.left = left;
		}

		public Node<K> getRight() {
			return right;
		}

		public void setRight(Node<K> right) {
			this.right = right;
		}
	}

	private class ComparatorMethod implements Comparator <T>{
		public int compare(T a, T b){
			if (a == null && b == null){
				return 0;
			}else if (a == null){
				return 1;
			}else if (b == null){
				return -1;
			}else{
				return a.compareTo(b);
			}
		}
	}
}
