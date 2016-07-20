/**
* This class is a child class of Item. It keeps track of which items are perishable
* This class also takes in the name of the item and its price before tax. The items 
* in this class have the same tax value. 
* @author D'MiriaCollins
*@version 1.0
*/
public class GroceryItem extends Item{
 private static double GROCERY_TAX_RATE=0.025;
 private boolean perishable;
/**
* Constructs a method that takes in the name, price, and whether the item is 
* perishable or not.
* @param name of the grocery item
* @param price of the grocery item
* @param perishable is whether the item is perishable or not.
*/

 public GroceryItem(String name, double price, boolean perishable){
  super(name, price, GROCERY_TAX_RATE);
  this.perishable = perishable;
 }
/**
* Constructs a method that inherits the Item toString along with its own toString.
* @return the toString from Item and GroceryItem
*/	
 public String toString(){
  String rot = "";
  if (perishable){
   rot = "yes";
  } else {
   rot = "no";
  }
  return super.toString()+"  Perishable: "+rot;
 }
}
