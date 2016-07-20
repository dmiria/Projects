import java.util.List;




/**
 * 
 * @author D'Miria Collins
 */
class Node<T extends Comparable<T>> {
	private Node<T> left, right;
	private T data;
	private int height;
	private int bF;

	Node(T data) {
		this.data = data;
		this.height = 0;
		this.bF = 0;
	}

	/**
	 * @return this Node's data
	 */

	T getData() {
		return data;
	}

	public String toString(){
		return data + " b:" + bF + " H:" + height;
	}

	/**
	 * Returns the left node
	 * 
	 * @return
	 */

	public Node<T> getLeft() {
		return left;
	}

	/**
	 * Returns the right node
	 * @return
	 */

	public Node<T> getRight() {
		return right;
	}

	/**
	 * Adds dataToAdd to this subtree.
	 * Rebalances the tree if necessary.
	 * 
	 * @param dataToAdd Must not be null. Must not already exist in the tree.
	 */
	OperationResult<T> add(T dataToAdd) {
		boolean treeWasChanged = false;
		if (right == null && dataToAdd.compareTo(data) > 0) {
			right = new Node<T>(dataToAdd);
			updateNode();
			return new OperationResult<T>(true, this);
		} else if (left == null && dataToAdd.compareTo(data) < 0) { 
			left = new Node<T>(dataToAdd);
			updateNode();
			return new OperationResult<T> (true, this);
		} else if (data.compareTo(dataToAdd) > 0) {
			OperationResult<T> temp = left.add(dataToAdd);
			left = temp.getNewRoot();
			treeWasChanged = temp.treeWasChanged();
		} else {
			OperationResult<T> temp = right.add(dataToAdd);
			right = temp.getNewRoot();
			treeWasChanged = temp.treeWasChanged();	
		}
		if (treeWasChanged == true){
			return new OperationResult<T> (true, rotate(this));
		}
		return new OperationResult<T> (false, this);
	}

	/**
	 * Adds the data of this subtree to list in order. (ie. does an in-order traversal)
	 * 
	 * @param list The list to add the data to. Must not be null.
	 */
	void addToInOrder(List<T> list) {
		if (left != null){
			left.addToInOrder(list);
		}
		list.add(data);
		if (right != null){
			right.addToInOrder(list);
		}

	}

	/**
	 * @param needle The data to look for.
	 * @return true if this Node or any subnode contains needle.
	 */
	boolean contains(T needle) {
		return containHelper(this, needle);	
	}
	/**
	 * Helps the contains method by checking the edge cases and using recursion 
	 * to see if the tree has parameter node.
	 * 
	 * @param node
	 * @param data
	 * @return
	 */

	private boolean containHelper(Node<T> node, T data) {
		if (node == null){
			return false;
		} else if (data.equals(node.getData())){
			return true;
		} else if (data.compareTo(node.getData()) > 0){
			return containHelper(node.right,data);
		} else {
			return containHelper(node.left,data);
		}
	}

	/**
	 * Removes dataToRemove from this subtree.
	 * When there are two options to use to replace a Node, uses the successor.
	 * Rebalances the tree if necessary.
	 * 
	 * @param dataToRemove Must not be null.
	 * @return The results of the remove. See the javadocs for OperationResult
	 */

	OperationResult<T> remove(T dataToRemove) {
		@SuppressWarnings("unused")
		boolean treeWasChanged = false;
		if (data.equals(dataToRemove)){
			if (left == null && right == null){
				return new OperationResult<T>(true,null);
			} else if (right == null && left != null){
				return new OperationResult<T>(true, left);
			} else if (left == null && right != null){
				return new OperationResult<T>(true,right);
			} else {
				T removedData;
				removedData = getSuccessor(right);
				OperationResult<T> temp = right.remove(removedData);
				right = temp.getNewRoot();
				data = removedData;
				return new OperationResult<T>(true, rotate(this));
			}
		} else if (data.compareTo(dataToRemove)>0){
			if (left == null){
				return new OperationResult<T>(false, null);
			}
			OperationResult<T> temp = left.remove(dataToRemove);
			left = temp.getNewRoot();
			return new OperationResult<T>(temp.treeWasChanged(),rotate(this));
		} else {
			if (right == null){
				return new OperationResult<T>(false, null);
			}
			OperationResult<T> temp = right.remove(dataToRemove);
			right = temp.getNewRoot();
			return new OperationResult<T>(temp.treeWasChanged(),rotate(this));
		}
	}


	/**
	 * 
	 * @param n
	 * @return
	 */

	private T getSuccessor (Node<T> n){
		while (n.left != null) {
			n = n.left;
		}
		updateNode();
		return n.data;
	}

	void updateNode(){
		updateNodeHeight();
		updateBalanceFactor();
	}


	/**
	 * Calculates the balance factor for the tree and updates the balance 
	 * factor when a node is added or the tree rotates.
	 * 
	 * @return
	 */

	private void updateBalanceFactor() {
		int leftH = 0;
		int rightH = 0;

		if (left == null) {
			leftH = -1;
		} else {
			leftH = left.height;
		}

		if (right == null) {
			rightH = -1;
		} else {
			rightH = right.height;
		}
		bF = leftH - rightH;
	}

	/**
	 * Calculates the height when a node is added or the tree is rotated.
	 * Is used in the add method.
	 * 
	 */

	private void updateNodeHeight() {	
		int leftH = 0;
		int rightH = 0;

		if (left == null) {
			leftH = -1;
		} else {
			leftH = left.height;
		}

		if (right == null) {
			rightH = -1;
		} else {
			rightH = right.height;
		}

		height = Math.max(leftH, rightH)+1;
	}

	/**
	 * Checks the balance factor to determine if the tree should be rotated.
	 * 
	 * @return
	 */


	private Node<T> rotate(Node<T> n) {
		updateNode();
		if(n.bF < -1){
			if (n.right.bF <= 0){
				return leftRotate(n);
			} else if (right.bF > 0){
				return rightLeftRotate(n);
			}
		}
		if (n.bF > 1){
			if (n.left.bF >=0){
				return rightRotate(n);
			} else if (n.left.bF <0){
				return leftRightRotate(n);
			}
		}
		return n;
	}



	/**
	 * Performs the right rotation that will balance the tree if the 
	 * balance factor is a certain value.
	 * 
	 * @return
	 */
	private Node<T> rightRotate(Node<T> n) {
		if (n != null){
			Node<T> newRoot = n.left;
			n.left = newRoot.right;
			newRoot.right = n;
			n.updateNode();
			newRoot.updateNode();
			return newRoot;
		}
		return n;
	}

	/**
	 * Performs a left rotation that will balance the tree if the balance
	 * factor is a certain value.
	 * 
	 * @return
	 */

	private Node<T> leftRotate(Node<T> n) {
		if (n != null){
			Node<T> newRoot = n.right;
			n.right = newRoot.left;
			newRoot.left = n;
			n.updateNode();
			newRoot.updateNode();
			return newRoot;
		}	
		return n;
	}

	/**
	 * Performs a left right rotation
	 * 
	 * @return
	 */

	private Node<T> leftRightRotate(Node<T> n) {
		Node<T> newRoot = n.left.right;
		Node<T> temp = newRoot.left;
		n.left.right = temp;
		newRoot.left = n.left;
		n.left = newRoot;
		return rightRotate(n);
	}

	/**
	 * Performs a right left rotation.
	 * 
	 * @return
	 */

	private Node<T> rightLeftRotate(Node<T> n) {
		Node<T> newRoot = n.right.left;
		Node<T> temp = newRoot.right;
		n.right.left = temp;
		newRoot.right = n.right;
		n.right = newRoot;
		return leftRotate(n);
	}


	/**
	 * Sets the data to a new value.
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Sets the left node to a different node.
	 * 
	 * @param left
	 */

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * Sets the right node to a different node.
	 * @param right
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}

}