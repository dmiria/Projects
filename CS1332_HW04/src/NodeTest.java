import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

public class NodeTest {

	//@Before
	public void setUp() throws Exception {
	}

	
	//@Test
	public void size1Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
//		tree.displayTree();
		assertEquals("Expected 1", 1, tree.size());	
	}
	
	//@Test
	public void size2Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
//		tree.displayTree();
		assertEquals("Expected 1", 2, tree.size());
	}
	
	//@Test
	public void size3Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
//		tree.displayTree();
		assertEquals("Expected 1", 3, tree.size());
	}
	
	//@Test
	public void clear1Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.clear();
//		tree.displayTree();
		assertEquals("Expected 0", 0, tree.size());
	}
	
	//@Test
	public void clear3Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.clear();
//		tree.displayTree();
		assertEquals("Expected 0", 0, tree.size());
	}
	
	//@Test
	public void isEmptyFalseTest() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.isEmpty();
//		tree.displayTree();
		assertEquals("Expected false", false, tree.isEmpty());	
	}
	
	//@Test
	public void isEmptyTrueTest() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.isEmpty();
//		tree.displayTree();
		assertEquals("Expected false", true, tree.isEmpty());	
	}
	
	//@Test
	public void inOrder1Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(5);
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(20);
//		tree.displayTree();
		assertEquals("Expected",list, tree.inOrder());
	}


	//@Test
	public void inOrder2Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(123);
		tree.add(111);
		tree.add(56);
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(111);
		list.add(56);
//		tree.displayTree();
		assertNotSame("Expected",list, tree.inOrder());
	}
	private void assertNotSame(String string, List<Integer> list, List<Integer> inOrder) {
		// TODO Auto-generated method stub
		
	}


	//@Test
	public void notInOrder3Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(123);
		tree.add(111);
		tree.add(56);
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(2);
		list.add(4);
//		tree.displayTree();
		assertNotSame("Expected 5, 10, 20",list, tree.inOrder());
	}
	
	//@Test
	public void removeTest() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.remove(10);
//		tree.displayTree();
		assertEquals("Expected 2", 2, tree.size());	
	}
	
	private void assertEquals(String string, int i, int size) {
		// TODO Auto-generated method stub
		
	}


	//@Test
	public void remove2Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(30);
		tree.remove(10);
//		tree.displayTree();
		assertEquals("Expected 3", 3, tree.size());		
	}
	//@Test
	public void remove3Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(30);
		tree.remove(5);
//		tree.displayTree();
		assertEquals("Expected 3", 3, tree.size());		
	}
	//@Test
	public void remove4Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(30);
		tree.remove(20);
//		tree.displayTree();
		assertEquals("Expected 3", 3, tree.size());		
	}
	//@Test
	public void removeMoreTest() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(30);
		tree.add(1);
		tree.add(18);
		tree.add(0);
		tree.add(100);
//		tree.remove(20);
		tree.displayTree();
		assertEquals("Expected 8", 8, tree.size());		
	}
	
	//@Test
	public void rotate1Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(15);
//		tree.displayTree();
		assertEquals("Expected 3", 3, tree.size());		
	}
	
	//@Test
	public void rotate2Test() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(0);
		tree.add(5);
//		tree.displayTree();
		assertEquals("Expected 3", 3, tree.size());		
	}
	
	//@Test
	public void rotate3Test(){
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		assertEquals("Expected True", true, tree.contains(10));
	}
	
	//@Test
	public void contains1Test(){
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
//		tree.displayTree();
		assertEquals("Expected True", true, tree.contains(20));
	}
	
	//@Test
	public void contains3Test(){
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
//		tree.displayTree();
		assertEquals("Expected True", true, tree.contains(30));
	}
	
	//@Test
	public void contains1FalseTest(){
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		assertEquals("Expected False", false, tree.contains(5));
		assertFalse(tree.contains(5));
	}

	//@Test
	public void contains2FalseTest(){
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(20);
		tree.add(15);
//		tree.displayTree();
		assertEquals("Expected False", false, tree.contains(5));
		assertFalse(tree.contains(5));
	}


	private void assertFalse(boolean contains) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(String string, boolean b, boolean contains) {
		// TODO Auto-generated method stub
		
	}
	
	private void assertEquals(String string, List<Integer> list, List<Integer> inOrder) {
		// TODO Auto-generated method stub
		
	}
}
