import java.awt.Color;
import java.awt.Point;


/**
  * 
  * A singly-linked list for DotNode objects.
  * 
  */
public class DotLinkedList {
	private DotNode head;
 	private int size;
    
	/**
     * Adds the Dot to the end of the list
     * 
     * @param dot
     */
 	public void add(Dot dot){
  		DotNode temp = head; //start at head
   	DotNode current = null; 
   	if(head == null){
     		head = new DotNode(dot);
   	}else{
   		while((current = temp.next) != null)//while the thing after current is not null(until end of list
    			temp = temp.next;
   			temp.next = new DotNode(dot); //change null item at end to new Dot
   	}
   	size++;
 	}
   /**
     * Removes the Dot from the list
     * 
     * @param dot
     */
	public void remove(Dot dot){
   	DotNode start = head;
   	//DotNode remove = null;
   	if(size==1 && head.dot.equals(dot)){
     		head=null;
   	}else if(head.dot.equals(dot)){
     		start=head.next;}else{
       	while(!start.next.dot.equals(dot)){
        		start = start.next; 
      }
      start.next = start.next.next;
     }
	   size--;
 }
  
 
   /**
     * Gets the Dot at the specified index. If the index
     * does not occur within the list, return null
     * @param i
     * @return
     */
    public Dot get(int i){
      	DotNode start = head;
      	int temp = 0;
      	if(i>size-1||i<0){
        		return null;
      	}else{
        		while(temp!=i){
         		start = start.next;
         		temp++; 
        	}
        return start.dot;
      }
   
    }
    
   /**
     * Get the dot that contains the specified Point. If
     * such a dot does not exist within the list, return null.
     * 
     * @param p
     * @return
     */
    
	 public Dot getDotAtPoint(Point p){
      DotNode start = head;
      boolean doesContain = start.dot.contains(p);
      while(doesContain != true){
        start = start.next;
        doesContain = start.dot.contains(p);
      }
      return start.dot;
    }
    
    /**
     * Remove all of the dots within the list that 
     * have the specified color
     * 
     * @param c
     */
    public void removeAllByColor(Color c){
        DotNode start = head;
        for(int i = 0; i < size; i++){
        		if(start.dot.getColor().equals(c))          
           		remove(start.dot);
         		start = start.next;
        }
    }
    
   /**
     * Get the size of the list
     * @return
     */
    public int size(){
		return size;
    }
    
   /**
     * Get the number of dots that are the specified
     * color within the list.
     *
     * @return 
     */
    public int getColorCount(Color c){
    	DotNode start = head;
     	int count = 0;
     	for(int i = 0; i < size; i++){
       	if(start.dot.getColor().equals(c))          
         	count++;
    	}
     	return count;    
    }

   /**
     * Get a string representation of the list
     */
    public String toString(){
       return "There are ";
    }
    
    /**
     * Class to contain a dot and the reference to the 
     * next DotNode in the list
     * 
     */
    private class DotNode{
        private Dot dot;
        private DotNode next;
        
        /**
         * Create a new DotNode to contain the specified Dot
         * 
         * @param dot
         */
        public DotNode(Dot dot){
           this.dot = dot;
           next = null;
        }
        
        /**
         * String representation of the node. This should
         * just be the String representation of the Dot that
         * the node contains
         */
        public String toString(){
          return "There are " + " red dots, "+ " blue dots " + " green dots ";  
        }
    }
    
}
