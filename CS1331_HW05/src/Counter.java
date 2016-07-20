public class Counter{
	private String itemName;
	private int count;
	public static int totalCount;
	
	public Counter(String itemName, int count){
		this.itemName = itemName;
		this.count = count;
		totalCount = totalCount+count;
	}
	public void reset(){
		totalCount = totalCount -count;
		count = 0;
		
	}
	public int changeCount(boolean increment, int amount){
		if (increment){
			count = count + amount;
			totalCount = totalCount+ amount;
		}else{
			count = count - amount;
			totalCount = totalCount - amount; 
		}	
		return count;
	}	
	public int changeCount(boolean increment){
		changeCount(increment, 1);
		return count;
	}
	
	public int getCount(){
		return count;
	}
	public static int getTotalCount(){
		return totalCount;
	}
}
	
	

		
		