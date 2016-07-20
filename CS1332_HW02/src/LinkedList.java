import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 
 * @author D'Miria Collins
 *
 * The API for LinkedList can be found here
 * http://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 */
public class LinkedList<T> implements List<T> {
	private Node<T> head,tail;
	private int size;


	public LinkedList(){
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public void add(T item) {
		add(item,size);
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(Object item) {

		if (head == null) {
			return false;
		} else {
			Node<T> current = head;
			while (current != null) {
				if (current.data == null || current.data == item || current.data.equals(item)) {
					return true;
				} else {
					current = current.next;
				}
			}
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		if (head == null && tail == null){
			return true;
		}
		return false;
	}

	@Override
	public T remove(Object item) {
		if (head == null && tail == null) {
			return null;
		}
		if (size == 1) {
			if (head.data.equals(item)) {
				T currentData = head.data;
				head = null;
				tail = null;
				size = 0;
				return currentData;
			} else {
				return null;
			}
		} else {
			if (head.data.equals(item)) {
				T currentData = head.data;
				head = head.next;
				head.prev = null;
				size--;
				return currentData;
			} else if (tail.data.equals(item)) {
				T currentData = tail.data;
				tail = tail.prev;
				tail.next = null;
				size--;
				return currentData;
			} else {
				Node<T> current = head;
				T currentData = null;
				while (current != null) {
					if (current.data.equals(item)) {
						currentData = current.data;
						current.prev.next = current.next;
						current.next.prev = current.prev;
						current.prev = null;
						current.next = null;
						current = null;
						size--;
						return currentData;
					}
					current = current.next;
				}
				return null;	
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Returns an iterator able to iterate over the list
	 * 
	 * @return the iterator for the list
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	@SuppressWarnings("hiding")
	private class LinkedListIterator<T> implements Iterator<T>{
		@SuppressWarnings("unchecked")
		private Node<T> node = (Node<T>) head;
		//private int index;

		@Override
		public boolean hasNext() {
			if (node == null){
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			T current = node.data;
			node = node.next;
			return current;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	@Override
	public void add(T item, int index) {
		Node<T> addNode = new Node<T>(item);
		Node<T> current = head;
		int count = 0;
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		if (index == 0){
			if (head == null){
				//create a new Node 
				head = addNode;
				tail = addNode;
				size++;
			}else{
				//create a new node and attach to front
				addNode.next = head;
				head.prev = addNode;
				head = addNode;
				size++;
			}

		}else if(index == size){
			if(head == null){
				head = addNode;
				tail = addNode;
				size++;
			}else{
				addNode.prev = tail;
				tail.next = addNode;
				tail = addNode;
				size++;			
			}
		}else{
			while (count < index){
				count ++;
				current = current.next;	
			}
			addNode.next = current;
			addNode.prev = current.prev;
			current.prev.next = addNode;
			current.prev = addNode;
			size ++;

		}

	}

	@Override
	public T get(int index) {
		int counter = 0;
		Node<T> current = head;
		if ((index >= size) || (index < 0)) {
			throw new IndexOutOfBoundsException();
		}
		while (counter != index) {
			counter++;
			current = current.next;
		}
		return current.data;
	
	}

	@Override
	public int indexOf(Object item) {
		if (head == null  || tail == null || !contains(item)) {
			return -1;
		} else {
			Node<T> current = head;
			int counter = 0;
			if(current.data.equals(item)) {
				return 0;
			}
			while (current != null) {
				if(current.data == item||current.data.equals(item)) {
					return counter;
				}
				current = current.next;
				counter++;
			}
			return -1;
		}
	}

	@Override
	public T remove(int index) {
		int count = 0;
		Node<T> node = head;
		T temp;
		if (isEmpty()){
			throw new IndexOutOfBoundsException ();
		}else if(index >= size || index < 0){
			throw new IndexOutOfBoundsException("out of bounds exception");
		}else{ 
			if (size == 1){
				temp = head.data;
				head = null;
				tail = null;
				size--;
				return temp;
			}else if(index == 0){
				temp = head.data;
				head = head.next;
				size--;
				return temp;
			}else if(index == size - 1){
				temp = tail.data;
				tail = tail.prev;
				size--;
				return temp;
			}else{	
				while (count != index){
					count++;
					node = node.next;
				}
				node.next.prev = node.prev;
				node.prev.next = node.next;
				node.prev = null;
				node.next = null;
				size--;
				return node.data;
			}
		}
	}


	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		if (head == null){ 
			throw new NoSuchElementException ();
		}else{
			return head.data;
		}
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		if (tail == null){
			throw new NoSuchElementException ("exception because the element is null");
		}else{
			return tail.data;
		}
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		add(item, 0);
	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		add(item, size);
	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		Node<T> node = head;
		T tempNode;
		if (isEmpty() == true){
			throw new NoSuchElementException ("exception");
		}else if(size == 1){
			head = null;
			tail = null;
			size--;
			return node.data;
		}else{
			tempNode = node.data;
			node.next.prev = null;
			head = node.next;
			size--;
			return tempNode;
		}
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		Node<T> node = tail;
		T tempNode;
		if (isEmpty() == true){
			throw new NoSuchElementException("exception");
		}else if (size ==1){
			head = null;
			tail = null;
			size--;
			return node.data;			
		}else{
			tempNode = tail.data;
			node.prev.next = null;
			//node.next = null;
			tail = node.prev;
			size--;
			return tempNode;
		}
	}

	/**
	 * Gets the node pointed to by head, if this doesn't exist return null
	 * 
	 * @return Node pointed to by head or null
	 */
	public Node<T> getHead(){
		if (head != null){
			return head;
		}
		return null;
	}

	/**
	 * Replace the current linked list with the linked list where 'head' is it's head. 
	 * 
	 * *HINT* You are replacing your current linked list with the linked list
	 *  where the variable 'head' is the head. This is not the same as adding head to the front
	 *  of the linked list. Think about which variables in your LinkedList you have to change
	 *  when you replace the current LinkedList with another one.
	 *  
	 */
	public void replaceUsingHead(Node<T> head){
		this.head = head;
		Node<T> current = head;
		int counter = 1;
		while (current.next != null) {
			current = current.next;
			counter++;
		}
		size = counter;
		tail = current;
	}


	/**
	 * Gets the node pointed to by tail, if this doesn't exist return null
	 * 
	 * @return Node pointed to by tail or null
	 */
	public Node<T> getTail(){
		if (tail != null){
			return tail;
		}
		return null;
	}

	/**
	 * Replace the current linked list with the linked list where 'tail' is it's tail. 
	 * 
	 * *HINT* You are replacing your current linked list with the linked list
	 *  where the variable 'tail' is the tail. This is not the same as adding tail to the end
	 *  of the linked list.Think about which variables in your LinkedList you have to change
	 *  when you replace the current LinkedList with another one.
	 */
	public void replaceUsingTail(Node<T> tail){
		this.tail = tail;
		Node<T> current = tail;
		int count = 1;

		while (current.prev !=null){
			count ++;
			current = current.prev;
		}
		size = count;
		head = current;
	}

}
