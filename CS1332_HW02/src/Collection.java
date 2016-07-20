public interface Collection<T> extends Iterable<T> {

	/**
	 * Adds 'item' to this collection.
	 * 
	 * Adds to the end of this collection if the notion of end exists for the
	 * concrete class
	 * 
	 * @param item
	 */
	public void add(T item);

	/**
	 * Clears this collection
	 * 
	 */
	public void clear();

	/**
	 * @param item
	 * @return true if this collection contains 'item', false otherwise
	 */
	public boolean contains(Object item);

	/**
	 * @return true if this collection is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Removes the first occurence 'item' from this collection, and returns what was removed
	 * 
	 * If 'item' does not exist in this collection, do not modify the
	 * collection, and return null
	 * 
	 * Note that you must return the item removed from this collection, not the
	 * parameter 'item'
	 * 
	 * @param item
	 * @return
	 */
	public T remove(Object item);

	/**
	 * @return the number of items in this collection
	 */
	public int size();

}
