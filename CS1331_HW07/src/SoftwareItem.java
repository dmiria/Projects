/**
 * This class is for all the software items in the store. It's another child class of item.
 * This class also has the name of  * the item, the items price and keeps track of 
 * what OS it is compatible with.
 * @author D'MiriaCollins
 *@version 1.0
 */
public class SoftwareItem extends Item{
 private static double SOFTWARE_TAX_RATE=0.15;
 private String compatibility;
/**
 * Constructs a method that inherits the Items constructor for name and price and 
 * takes in the compatibility and Software tax rate.
 * @param name of the item
 * @param price of the item
 * @param compatibility with the OS
 */	
 public SoftwareItem(String name, double price, String compatibility){
  super(name, price, SOFTWARE_TAX_RATE);
  this.compatibility = compatibility;
 }
 /**
 * Constructs a method that inherits the Item toString along with its own toString.
 * @return the toString from Item and GroceryItem
 */
 public String toString(){
  return super.toString()+"  Compatable OS: "+compatibility;
 }
}
