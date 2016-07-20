import java.util.Arrays;
import java.util.Comparator;

/** 
 * 
 * @author D'Miria Collins
 * 
 * This is an implementation of a max binary heap that is backed by an array.
 * This means the largest item will be at the root.
 *
 * This implementation will accept a comparator object that can be used to
 * define an ordering of the items contained in this heap, other than the
 * objects' default compareTo method (if they are comparable). This is useful if
 * you wanted to sort strings by their length rather than their lexicographic
 * ordering. That's just one example.
 * Null should be treated as positive infinity if no comparator is provided. If
 * a comparator is provided, you should let it handle nulls, which means it
 * could possibly throw a NullPointerException, which in this case would be
 * fine.
 *
 * If a comparator is provided that should always be what you use to compare
 * objects. If no comparator is provided you may assume the objects are
 * Comparable and cast them to type Comparable<T> for comparisons. If they
 * happen to not be Comparable you do not need to handle anything, and you can
 * just let your cast throw a ClassCastException.
 */
public class BinaryHeap<T> implements Heap<T> {
	/**
	 * This the current size/number of elements in the heap
	 */
	private int size;

	/**
	 * This is the Comparator that will be used order the elements in the heap
	 */
	private Comparator<T> comp;

	/**
	 * This is the array used to back the heap.
	 */
	private T[] data;

	/**
	 * Default constructor, this should initialize data to a default size (11 is
	 * normally a good choice)
	 * 
	 * This assumes that the generic objects are Comparable, you will need to
	 * cast them when comparing since there are no bounds on the generic
	 * parameter
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		this.data = (T[]) new Object [11];
		this.size = 0;
	}

	/**
	 * Constructor that accepts a custom comparator to use with this heap. Also
	 * initializes data to a default size.
	 * 
	 * When a comparator is provided it should be preferred over the objects'
	 * compareTo method
	 * 
	 * If the comparator given is null you should attempt to cast the objects to
	 * Comparable as if a comparator were not given
	 * 
	 * @param comp
	 */
	public BinaryHeap(Comparator<T> comp) {
		this();
		if (comp != null){
			this.comp = comp;
		} else {
			this.comp = new Comparator <T>(){
				@SuppressWarnings("unchecked")
				public int compare(T o1, T o2){
					return ((Comparable<T>) o1).compareTo(o2);
				}
			};	
		}
	}



	@SuppressWarnings("unchecked")
	public String toString(){
		T[] anArray = (T[]) new Object [size];
		for (int i = 0; i < size; i++){
			anArray[i] = data[i];
		}

		return Arrays.toString(anArray);
	}

	/**
	 * The first element will be added to index 0 of the array.
	 * If the array becomes full, resize.
	 */

	@Override
	public void add(T item) {
		if ( size == 0) {
			data[0] = item;
			size++;
		} else if ( size < data.length ) {
			size++;
			data[size-1] = item;
			swimHelper(data, size-1);
		} else {
			resize();
			add(item);
		}
	}

	/**
	 * 
	 * @param anArray
	 * @param sizeNum
	 */

	@SuppressWarnings("unchecked")
	private void swimHelper(T[] anArray, int sizeNum) {
		int parent = (sizeNum - 1 )/2;
		if ( sizeNum == 0 ) return;
		if ( anArray[sizeNum] == null || anArray[sizeNum].equals(null)
				|| ((Comparable<T>) anArray[sizeNum]).compareTo(anArray[parent]) > 0) {
			T tempValue = anArray[parent];
			anArray[parent] = anArray[sizeNum];
			anArray[sizeNum] = tempValue;
			sizeNum = parent;
			swimHelper(anArray,sizeNum);
		}		
	}

	/**
	 * Checks the data array to determine if its empty
	 */

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	/**
	 * @throw NullPointerException if list is empty
	 */
	@Override
	public T peek() {
		if (size == 0){
			throw new NullPointerException ();
		} else {
			return data [0];
		}
	}

	/**
	 * Return null if list is empty.
	 */
	@Override
	public T remove() {
		if (isEmpty()) {
			return null;
		} else {
			T info = data[0];
			data[0] = data[size-1];
			size--;
			if ( size > 0) {
				data[size] = null;
				sinkHelper(data,0);
			}
			return info;
		}
	}

	/**
	 * 
	 * @param anArray 
	 * @param index	
	 */
	@SuppressWarnings("unchecked")
	private void sinkHelper(T[] anArray, int index) {
		int leftN = index*2+1;
		int rightN = index*2+2;

		if ( index > size/2 || leftN >= size ) {
			return;
		}
		int otherIndex = index;

		if (anArray[leftN] == null && anArray[rightN] != null ) {
			otherIndex = rightN; 
		} else if (anArray[leftN] != null && anArray[rightN] == null ) {
			otherIndex = leftN;
		} else if (anArray[leftN] == null && anArray[rightN] == null ) {
			return;
		} else {
			if (((Comparable<T>) anArray[leftN]).compareTo(anArray[rightN]) > 0) {
				otherIndex = leftN;
			} else if (((Comparable<T>) anArray[leftN]).compareTo(anArray[rightN]) < 0) {
				otherIndex = rightN;
			}
		}

		if ( anArray[index] == null || anArray[index].equals(null)
				||(otherIndex == leftN )){
			T temp = anArray[leftN];
			anArray[leftN] = anArray[index]; 
			anArray[index] = temp;
			sinkHelper(anArray,leftN);			
		} else if ( otherIndex == rightN ) {
			T temp = anArray[rightN];
			anArray[rightN] = anArray[index]; 
			anArray[index] = temp;
			sinkHelper(anArray,rightN);			
		} else {
			return;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public void resize (){
		if (data != null){
			T[] newArray = (T[]) new Object [data.length*2];	
			for(int i=0; i< data.length; i++){
				newArray[i] = data[i];
			}
			data = newArray;
		}
	}

	/**
	 *
	 * @return sorted list of elements in the heap
	 */

	@SuppressWarnings("unchecked")
	public T[] heapSort() {
		T[] aArray = (T[]) new Object [data.length];
		T[] bArray = (T[]) new Object [data.length];
		T[] cArray = (T[]) new Object [data.length];
		int noteSize = 0;

		for (int i = 0; i< data.length; i++){
			aArray[i] = data[i];
			noteSize++;
		}

		for (int i = 0; i< data.length; i++){
			T temp = remove();
			bArray[i] = temp;
		}

		for (int i = 0; i< noteSize; i++){
			cArray[i] = bArray[(noteSize-1)-i];
		}

		data = aArray;
		return cArray;
	}
}
