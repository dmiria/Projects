/**
 * This class uses an array to internally represent a real world shopping cart. The 
 * shopping cart will hold some items. There will be an array of five, but the array 
 * will increase according to the number of items that need to be stored. 
 * @author D'MiriaCollins
 *@version 1.0
 */
public class ShoppingCart {
 private Item[] items;
 private int count;
 	/**
	 * Constructs a method that establishes  the shopping cart array.
	 */
 public ShoppingCart() {
  items = new Item[5];
  count = 0;
 }
	/**
	 * This method adds items into the shopping cart. 
	 * @param item that will be added into the shopping cart.
	 */
 public void addItem(Item item) {
  int original = items.length;
  if (count < items.length) {
   items[count] = item;
   count++;
  } else {
   Item[] temp = items;
   items = new Item[items.length * 2];
   for (int i = 0; i < original; i++) {
    items[i] = temp[i];
   }
   count = original;
   items[count] = item;
   count++;

  }
 }
	/**
	 * This method removes the last Item added to the shopping cart.
	 * @return the array after the item has been removed.
	 */
 public Item removeLastItem(){
  Item item = null;
  int x=0;
  for (int i=items.length-1; i>=0; i--){
   if (items[i]!=null && items[i+1]==null){
    x = i;
   }
  }
  item = items[x];
  items[x] = null;
  count--;
  return item;
 }
	/**
	 * This method gets the Items in the shopping  cart.
	 * @return the items left in the cart
	 */
 public Item[] getItems() {
  return items;
 }

	/**
	 * This method gets a String representation of the shopping cart.
	 * @return the String of what is left in the cart.
	 */
 public String toString() {
  String cartItems = null;
  for (int i = 0; i < items.length; i++) {
   if (items[i] != null) {
    cartItems += items[i] + " ";
   }
  }
  return "Your cart is holding " + cartItems;
 }
}
