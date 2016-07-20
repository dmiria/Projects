import java.text.*;
/**
 * This class represents an actual store where a person can shop. 
 * The class has a name and an inventory of items stored in an 
 * array. The array is the length of five.
 *@author D'MiriaCollins
 *@version 1.0
 */
public class Store {
 private Item[] inventory;
 private int count;
 private double moneyEarned;
 private String name;
	/**
	 * Constructs a method that takes in the stores name.
	 * @param name
	 */
 public Store(String name) {
  this.name = name;
  inventory = new Item[5];
  count = 0;
 }
	/**
	 * This method adds Items to the Store's inventory
	 * @param items
	 */
 public void receiveShipment(Item[] items) {
  int counter = 0;
  for (int i=0; i<inventory.length; i++) {
   if(inventory[i]!=null)
    counter++;
  }
  if(counter+items.length<inventory.length){
   for(int i=0;i<items.length;i++){
    inventory[counter+i]=items[i];
   }
  }else{
   Item[] tempInv = inventory;
   inventory = new Item[inventory.length*2];
   int j=0;
   for(int i=0; i<tempInv.length; i++){
    if(tempInv[i]!=null)
     inventory[i] = tempInv[i];
   }
   for(int i=0;i<items.length;i++){
    inventory[counter+i] = items[i];
   }
  }
 }
 	/**
	 * This method gets an Item out of inventory.
	 * @param index
	 * @return
	 */
 public Item getItem(int index) {
  Item tempItem = inventory[index];
  Item[] tempInv = new Item[inventory.length-1];
  for (int i=0; i<tempInv.length; i++){
   if (i<index){
    tempInv[i] = inventory[i];
   } else {
    tempInv[i] = inventory[i+1];
   }
  }
  inventory = tempInv;
  count--;
  return tempItem;
 }
	/**
	 * This method rings up the Customer's items and handle payment
	 * @param Customer
	 * @return
	 */
 public boolean makeASale(Customer Customer) {
  double totalCost = 0;
  Item[] customerCart = Customer.checkout();
  for (int i = 0; i < customerCart.length; i++) {
   if (customerCart[i] != null)
    totalCost += customerCart[i].getPriceAfterTax();
  }
  if (Customer.getMoney() > totalCost) {
   Customer.pay(totalCost);
   moneyEarned += totalCost;
   return true;
  } else
   return false;
 }
	/**
	 * This method determines of the Store has anymore items left to sell
	 * @return
	 */
 public boolean hasMoreItems() {
  for (int i = 0; i < inventory.length; i++)
   if (inventory[i] != null)
    return true;
  return false;
 }
	/**
	 * This method gets a String representation of the store's inventory.
	 * @return
	 */
 public String listInventory() {
  String result = "";
  for (int i = 0; i < inventory.length; i++) {
   if (inventory[i] != null)
    result += inventory[i] + ", ";
  }
  result = result.substring(0, result.length() - 2) + ".";
  return result;
 }
	/**
	 * This method gets a String representation of the stores inventory.
	 * @return
	 */	
 public String toString() {
  NumberFormat nf = NumberFormat.getCurrencyInstance();
  int itemsLeft = 0;
  for (int i = 0; i < inventory.length; i++) {
   if (inventory[i] != null)
    itemsLeft++;
  }
  String result = "The " + name + " has " + itemsLeft + " items. ";
  result += "It has made " + nf.format(moneyEarned) + " from sales.\n\n";
  result += "Currently, we have\n";
  for (int i = 0; i < inventory.length; i++) {
   if (inventory[i] != null)
    result += i + ": " + inventory[i].toString() + "\n";
  }
  return result;
 }
}
