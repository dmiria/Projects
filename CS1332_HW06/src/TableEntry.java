import java.util.Map.Entry;

/**
 * The Class HashTableEntry.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class TableEntry<KEY,VALUE> implements Entry<KEY, VALUE> {

	/**
	 * Instantiates a new hash table entry.
	 *
	 * @param key the key
	 * @param value the value
	 */
	private KEY key;

	private VALUE value;

	private boolean available;

	public TableEntry(KEY key, VALUE value){
		this.key = key;
		this.value = value;
//		available = false;

	}


	/**
	 * Checks if the entry is available.
	 *
	 * @return true, if it is available
	 */
	public boolean isAvailable(){
		if (key == null && value == null){
			return true;
		}
		return available;
	}

	/**
	 * Sets the availability.
	 *
	 * @param isAvailable the new availability
	 */
	public void setAvailability(boolean isAvailable){
		if (isAvailable == true){
			available = true;
		}
		available = false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o){
		if (((TableEntry<KEY, VALUE>) o).getKey()== key && ((TableEntry<KEY, VALUE>) o).getValue() == value){
			return true;
		}
		return false;
	}

	@Override
	public KEY getKey() {
		return key;
	}

	/**
	 * @return the hashcode of the entry as defined in Map.Entry API (Google it!)
	 */
	@Override
	public int hashCode(){
		return key.hashCode();
	}

	@Override
	public VALUE setValue(VALUE value) {
		this.value = value;
		return value;
	}

	@Override
	public VALUE getValue() {
		return value;
	}

}
