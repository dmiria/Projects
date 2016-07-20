import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * For information on the Collection interface, see http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
 * 
 * 
 * @author D'Miria Collins
 *
 */

public class AVLTree<T extends Comparable<T>> implements Collection<T> {
	private Node<T> head;
	private int size;

	public AVLTree() {

	}

	/**
	 * Does not support duplicate data. Read the add() javadoc online for more information.
	 * Rebalances the tree if necessary.
	 */
	@Override
	public boolean add(T data) {
		if (size == 0) {
			head = new Node<T>(data);
			size++;
		} else {
			head = head.add(data).getNewRoot();
			head.updateNode();
			size++;
		}
		return true;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * @return A list of the data in the AVLTree. Will never return null.
	 */
	public List<T> inOrder() {
		List<T> l = new ArrayList<T>();
		if (isEmpty()) {
			return l;
		}
		head.addToInOrder(l);
		return l;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * @param o Must not be null.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) throws ClassCastException {
		return head.contains((T)o);
	}



	/**
	 * Rebalances the tree if necessary.
	 * 
	 * @param o Must not be null.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) throws ClassCastException {
		if (head != null) {
			OperationResult<T> temp = head.remove((T)o);
			if (temp.treeWasChanged()) {
				head = temp.getNewRoot();
				size --;
//				head.rotate();
				return true;
			}
		} 
		return false;
	}

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object each : c) {
			@SuppressWarnings("unchecked")
			T tEach = (T) each;

			if (!contains(tEach)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean treeChanged = false;

		for (T each : c) {
			treeChanged |= add(each);
		}

		return treeChanged;
	}

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean treeChanged = false;

		for (Object each : c) {
			@SuppressWarnings("unchecked")
			T tEach = (T) each;
			treeChanged |= remove(tEach);
		}

		return treeChanged;
	}

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<T> iterator() {
		return inOrder().iterator();
	}

	@Override
	public Object[] toArray() {
		return inOrder().toArray();
	}

	@Override
	public <N> N[] toArray(N[] a) {
		return inOrder().toArray(a);
	}

	public void displayTree(){
		Stack<Node<T>> globalStack = new Stack<Node<T>>();
		globalStack.push(head);
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out.println("****.................................****");
		while (isRowEmpty == false){
			Stack<Node<T>> localStack = new Stack<Node<T>>();
			isRowEmpty = true;
			for (int j = 0; j < emptyLeaf; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false){
				Node<T> temp = globalStack.pop();
				if (temp != null){
					// System.out.println(temp.getData());
					System.out.print(temp);
					localStack.push(temp.getLeft());
					localStack.push(temp.getRight());
					if (temp.getLeft() != null || temp.getRight() != null)
						isRowEmpty = false;
				}else{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < emptyLeaf * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out.println("****..................................****");
	}

}
