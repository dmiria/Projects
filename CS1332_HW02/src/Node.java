/**
 * This class represents a generic linked list Node
 *
 */	

public class Node<T> {

	 Node<T> next, prev;
	 T data;
	 

	public Node(T data){
		this(data,null,null);
	}

	public Node(T data, Node prev, Node next){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}