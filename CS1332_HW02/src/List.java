public interface List<T> extends Collection<T> {

	/**
	 * Adds 'item' at the given index. Immediately after this get('index')
	 * should return 'item', assuming 'index' was valid
	 * 
	 * @param item
	 * @param index
	 * @throws IndexOutOfBoundsException
	 *             
	 */
	public void add(T item, int index);

	/**
	 * Gets the item at 'index'
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 *             
	 */
	public T get(int index);

	/**
	 * @param item
	 * @return the index of 'item' in this list, -1 if 'item' does not exist in
	 *         this list
	 */
	public int indexOf(Object item);

	/**
	 * Removes and returns the item at 'index'
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 *             
	 */
	public T remove(int index);

}
