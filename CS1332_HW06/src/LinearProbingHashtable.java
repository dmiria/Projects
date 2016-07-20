import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashtable<K, V> implements GradableMap<K, V> {

	/**
	 * You can change the name of this array. as far as you change the name in
	 * setArray(), getArray() and drawTable() method you are fine. we don't care
	 * about the name of this array
	 */
	private TableEntry<K, V>[] hashTable;

	private int initialCapacity;

	private int size = 0;
	/** DO NOT change the name of this variable*/
	private double loadFactor;


	/**
	 * Constructs a new, empty hashtable with the specified initial capacity and
	 * the specified load factor.
	 * 
	 * Throws: IllegalArgumentException - if the initial capacity is less than
	 * zero, or if the load factor is nonpositive.
	 **/
	@SuppressWarnings("unchecked")
	public LinearProbingHashtable(int initialCapacity, double loadFactor) {
		if (initialCapacity < 0|| loadFactor < 0){
			throw new IllegalArgumentException ();
		}
		this.loadFactor = loadFactor;
		this.initialCapacity = initialCapacity;
		hashTable = new TableEntry[initialCapacity];
	}

	/**
	 * Constructs a new, empty hashtable with the specified initial capacity and
	 * default load factor (0.75).
	 * 
	 * Throws: IllegalArgumentException - if the initial capacity is less than
	 * zero.
	 */
	@SuppressWarnings("unchecked")
	public LinearProbingHashtable(int initialCapacity) {
		if (initialCapacity < 0){
			throw new IllegalArgumentException ();
		}
		loadFactor = 0.75;
		this.initialCapacity = initialCapacity;
		hashTable = new TableEntry[initialCapacity];
	}

	/**
	 * Constructs a new, empty hashtable with a default initial capacity (11)
	 * and load factor (0.75).
	 */
	@SuppressWarnings("unchecked")
	public LinearProbingHashtable() {
		loadFactor = (float) 0.75;
		this.initialCapacity = 11;
		hashTable = new TableEntry[initialCapacity];
	}

	/** Returns the number of keys in this hashtable. */
	@Override
	public int size() {
		return size;
	}  

	/** Tests if this hashtable maps no keys to values. */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}


	/**
	 * Returns true if this hashtable maps one or more keys to this value. Note
	 * that arg0 is an Object not a generic.
	 * 
	 * This will happen in O(n). Since we don't know where the value could be,
	 * and we have to go through n element in the worst case.
	 * 
	 * Throws:NullPointerException - if the value is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean containsValue(Object arg0) {	
		if (isEmpty() == true){
			return false;
		}else if ((V)arg0 == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < hashTable.length; i++) {		
			if (hashTable[i] != null && hashTable[i].getValue().equals((V)arg0)) {
				return true;
			}
		}		
		return false;
	}

	/**
	 * Tests if the specified object is a key in this hashtable. Note that arg0
	 * is an Object not a generic.
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the key is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean containsKey(Object arg0) {
		K temp = (K) arg0;
		int index = temp.hashCode() % hashTable.length;

		if(isEmpty()== true) {
			return false;
		} else if ((K)arg0 == null) {
			throw new NullPointerException();
		} else if (hashTable[index] != null) {
			if (hashTable[index].getKey().equals((K)arg0)&& hashTable[index].isAvailable() == false){
				return true;
			}
			return false;
		} else {

			while (hashTable[index] != null){
				if (hashTable[index]!= null & hashTable[index].isAvailable()==false
						&&hashTable[index].getKey().equals((K)arg0)){
					return true;
				}
				index++;
			}
		}		
		return false;
	}


	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key. More formally, if this map contains
	 * a mapping from a key k to a value v such that (key.equals(k)), then this
	 * method returns v; otherwise it returns null. (There can be at most one
	 * such mapping.)
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the specified key is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V get(Object arg0) {
		if(isEmpty()== true) {
			return null;
		}
		if ((K)arg0 == null) {
			throw new NullPointerException();
		} else if (containsKey((K)arg0)){
			int index = arg0.hashCode()%hashTable.length;
			if (hashTable[index].getKey().equals((K)arg0) &&
					hashTable[index] != null) {
				return hashTable[index].getValue();
			}
			return null;
		} else {
			int index = arg0.hashCode()%hashTable.length;
			for (TableEntry<K,V> i = hashTable[index] ; i != null ; index++) {
				if (hashTable[index].getKey().equals((K)arg0)) {
					return hashTable[index].getValue();
				}
			}
			return null;
		}
	}

	/**
	 * Increases the capacity of and internally reorganizes this hashtable, in
	 * order to accommodate and access its entries more efficiently. This method
	 * is called automatically when the number of keys in the hashtable exceeds
	 * this hashtable's capacity and load factor.
	 */

	@SuppressWarnings("unchecked")
	protected void rehash() {
		if (loadFactor >= size/hashTable.length) {
			this.initialCapacity = (initialCapacity * 2) + 1;
			TableEntry<K,V>[] oldHash = hashTable;
			hashTable = new TableEntry[initialCapacity]; 
			for (int index = 0; index < oldHash.length; index++) {
				if(oldHash[index] != null && !oldHash[index].isAvailable()) {
					put(oldHash[index].getKey(), oldHash[index].getValue());
				}
			}
		}

	}

	/**
	 * Maps the specified key to the specified value in this hashtable. Neither
	 * the key nor the value can be null. The value can be retrieved by calling
	 * the get method with a key that is equal to the original key.
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the key or value is null
	 */

	@Override
	public V put(K key, V value) {
		int hash = key.hashCode();
		int index = key.hashCode()% hashTable.length;

		// Make sure the value is not null
		if (value == null || key == null) {
			throw new NullPointerException();
		}else if (loadFactor < (size+1)/hashTable.length) {
			// Rehash the table if the threshold is exceeded
			rehash();
		}
		// Makes sure the key is not already in the hashtable.
		for (TableEntry<K,V> i = hashTable[index] ; i != null ; index++) {
			if ((i.hashCode() == hash) && i.getKey().equals(key)) {
				V old = i.getValue();
				i.setValue(value);
				return old;
			}
		}
		
//		 Creates the new entry.
		@SuppressWarnings("unused")
		TableEntry<K,V> newVal = hashTable[index];
		hashTable[index] = new TableEntry<K,V> (key, value);
		size++;
		return null;
	}



	/**
	 * Removes the key (and its corresponding value) from this hashtable. This
	 * method does nothing if the key is not in the hashtable and returns null.
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the key is null
	 */


	@Override
	public V remove(Object key) {
		if (key == null) {
			throw new NullPointerException();
		} else if (isEmpty()== true){
			return null;
		} else if (containsKey(key)== true){
			int hashPoint = key.hashCode();
			int index = key.hashCode() % hashTable.length;
			if (index == hashPoint){
				hashTable[index].setAvailability(true);
				size--;
				return hashTable[index].getValue();
			} else {
				for (TableEntry<K,V> in = hashTable[index] ; in != null ; index++) {
					if ((in.hashCode() == hashPoint) && in.getKey().equals(key)) {
						hashTable[index].setAvailability(true);
						size--;
						return in.getValue();
					}
				}
			}			
		} else { 
			//(containsKey(key) == false)
			return null;
		}
		return null;		
	}


	/**
	 * Copies all of the mappings from the specified map to this hashtable.
	 * These mappings will replace any mappings that this hashtable had for any
	 * of the keys currently in the specified map.
	 * 
	 * This operation should run in O(n) time.
	 * 
	 * Throws: NullPointerException - if the specified map is null
	 */

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		if (otherMap == null){
			throw new NullPointerException();
		}
		for (Map.Entry<? extends K, ? extends V> hash : otherMap.entrySet()){
			put(hash.getKey(), hash.getValue());

		}
	}

	/** Clears this hashtable so that it contains no keys */
	@Override
	public void clear() {
		hashTable = new TableEntry[initialCapacity];
		size = 0;
	}

	/**
	 * Returns a Set view of the mappings contained in this map.
	 * 
	 * This operation should run in O(n) time.
	 */
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		HashSet<Map.Entry<K, V>> newSet = new HashSet<>(size);
		for (int i = 0; i< hashTable.length; i++){
			TableEntry <K,V> hash = hashTable[i];
			if (hash != null && hash.isAvailable()){
				newSet.add(hash);
			//((Map<K,V>)newSet).put(hash.getKey(), hash.getValue());
			}
		}
		return newSet;
	}

	/**
	 * which returns a java.util.Set containing the keys currently in the table.
	 * This is the first difference between our implementation and the contract
	 * of java.util.Map. In our implementation, you may simply create an
	 * instance of java.util.HashMap and add all of the keys. In the fully
	 * compliant implementation you would have to write a new class that
	 * implements java.util.Set and is backed by the hash table. See the Java
	 * API for more information about this, if you are interested. If there are
	 * no items in the hashtable return null
	 */
	@Override
	public Set<K> keySet() {
		HashSet<K> table = new HashSet<>(size);
		for (int i = 0; i< hashTable.length; i++){
			TableEntry <K,V> hash = hashTable[i];
			if (hash != null && hash.isAvailable()){
				table.add(hash.getKey());
			}
		}
		return table;
	}

	/**
	 * which returns an implementation of java.util.Collection containing all of
	 * the values in the hash table. This is the second difference between our
	 * implementation and the contract of java.util.Map. In our implementation,
	 * you may simply create an instance of java.util.ArrayList and add all of
	 * the keys. In the fully-compliant implementation you would have to write a
	 * new class that implements java.util.Collection and is backed by the hash
	 * table. See the Java API for more information about this, if you are
	 * interested.
	 */
	@Override
	public Collection<V> values() {
		ArrayList<V> temp = new ArrayList<>(size);
		for (int i = 0; i< hashTable.length; i++){
			TableEntry<K,V> hash = hashTable[i];
			if (hash != null && hash.isAvailable() == false){
				temp.add(hash.getValue());
			}
		}
		return temp;
	}

	/**
	 * 
	 * draw the hashtable with entries and availability of each entry This is
	 * just to help you visualize the Hashtable. This is not a part of grading
	 */
	public void drawTable() {
		for (int i = 0; i < hashTable.length; i++) {
			System.out.print(i + "  ");
			if (hashTable[i] == null)
				System.out.println("-------------------------");
			else
				System.out.println("key:" + hashTable[i].getKey().toString()
						+ "    valeu:" + hashTable[i].getValue().toString()
						+ "    Available?" + hashTable[i].isAvailable());
		}
		System.out
		.println("********************************************************");
		System.out.println();
	}

	/** following methods are already implemented **/
	@Override
	public TableEntry<K, V>[] getArray() {
		return hashTable;
	}

	@Override
	public void setArray(TableEntry<K, V>[] array) {
		this.hashTable = array;
	}

	@Override
	public double getLF() {
		return loadFactor;
	}

	public int getIC (){
		return initialCapacity;
	}
}
