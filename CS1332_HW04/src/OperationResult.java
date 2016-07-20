
/**
 * Stores information about an operation.
 * Used so that certain methods (eg. remove() and add()) can return multiple values)
 * 
 * @author JD
 */
class OperationResult<T extends Comparable<T>> {
	private boolean treeWasChanged;
	private Node<T> newRoot;
	
	/**
	 * @param treeWasChanged true if a Node was added or removed
	 * @param newRoot The Node that should be the root of this subtree in order to keep it balanced.
	 */
	OperationResult(boolean treeWasChanged, Node<T> newRoot) {
		this.treeWasChanged = treeWasChanged;
		this.newRoot = newRoot;
	}
	
	/**
	 * @return true if a Node was removed or added
	 */
	boolean treeWasChanged() { return treeWasChanged; }
	
	/**
	 * @return The Node that should be the root of this subtree in order to keep it balanced.
	 */
	Node<T> getNewRoot() { return newRoot; }
}
