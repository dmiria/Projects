import java.util.Map;

public interface GradableMap<K, V> extends Map<K, V> {
	
	/********************************************************
	 * 				These methods are for grading
	 * 		Don't touch them or yeti will find you!!!!
	 ********************************************************/
	
	public TableEntry<K,V>[] getArray();
	
	public void setArray(TableEntry<K,V>[] array);

	public double getLF();
		
}
