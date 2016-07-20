import java.text.*;
/**
 * This class represents the person who is doing the shopping. The Customer 
 * class keeps track of the customer's name, the items in the shopping cart, 
 * how much money the customer has, and whether the customer is still shopping.
 *@author D'MiriaCollins
 *@version 1.0
 */


public class Customer {
 private String name;
 private ShoppingCart cart;
 private double money;
 private boolean shopping;
/**
* Constructs the name of the customer and how much money they have.
* @param name of the customer
* @param money they have
*/

 public Customer(String name, double money) {
  this.name = name;
  this.money = money;
  cart = new ShoppingCart();
  shopping = true;
 }
/**
* This method adds an item to the Customer's cart.
* @param item
*/
 public void addToCart(Item item) {
  cart.addItem(item);
 }
/**
* This method removes the last item added to the Customer's cart. It must 
* be able to work repeatedly. Remove from an empty cart will do nothing.
* @return
*/
 public Item removeLastItem() {
  return cart.removeLastItem();
 }
/**
* This method gets the contents if the Customer's shopping cart for checkout.
* @return
*/
 public Item[] checkout() {
  return cart.getItems();
 }
	/**
	 * This method removes the correct amount of money when asked to pay.
	 * @param cost of the item
	 * @return true if the customer can afford the item.
	 */
 public boolean pay(double cost) {
  if (money > cost) {
   money -= cost;
   return true;
  }
  return false;
 }
	/**
	 * This method sets whether or not the Customer wishes to keep shopping.
	 * @param shopping
	 */
 public void keepShopping(boolean shopping) {
  this.shopping = shopping;
 }
 	/**
	 * This method determines if the customer is still shopping
	 * @return true if the customer is shopping
	 */
 public boolean isShopping() {
  return shopping;
 }
	/**
	 * This method gets the amount of money the customer has.
	 * @return money the customer has.
	 */
 public double getMoney() {
  return money;
 }
	/**
	 * This method gets a String representation of the Customer 
	 * with money and shopping cart items.
	 * @return
	 */
 public String toString() {
  NumberFormat numFormat = NumberFormat.getCurrencyInstance();
  String result = name + ", you currently have " + numFormat.format(money)
    + ".\nThe items in your cart are:\n";
  Item[] items = this.checkout();
  for (int i = 0; i < items.length; i++) {
   if (items[i] != null)
    result += items[i].toString() + "\n";
  }
  return result;
 }
 /**
 *This method sets the entire array to null.
 **/
 public void reset() {
  for (int i = 0; i < cart.getItems().length; i++) {
   if (cart.getItems()[i] != null) {
    cart.getItems()[i] = null;
   }
  }
 }
}
