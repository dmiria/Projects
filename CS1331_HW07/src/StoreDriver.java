import java.util.Scanner;
import java.text.*;
/*
*This method takes in the customer and store and runs the drive
*to prompt the user to add or remove their items from the cart
*to the inventory. It prints out the statements to let the user
* make a decision in the store.
*@author D'Miria Collins
*@version 1.0
*
*/
public class StoreDriver {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String user = "";
  int userIndex = 0;
  
  NumberFormat nf = NumberFormat.getCurrencyInstance();
  Store store1 = new Store("Tenacious TA's Tradehouse");
  Customer bill = new Customer("Bill", 36.00);
  GroceryItem coffee = new GroceryItem("Coffee", 1.00, true);
  SoftwareItem smb = new SoftwareItem("Super Mario Bros", 10.00,
    "Super Nintendo");
  Item sdp = new Item("Software Design Practices", 20.00);
  GroceryItem scone = new GroceryItem("Scone", 2.50, false);
  GroceryItem gummies = new GroceryItem("Gummy Snacks", 1.00, false);
  Item deMarkers = new Item("Dry Erase Markers", 6.00);

  Store store2 = new Store("Super Student Store");
  Customer alice = new Customer("Alice", 30.00);
  SoftwareItem bejeweled = new SoftwareItem("Bejeweled", 10.00, "Windwos");
  Item mysteryNovel = new Item("Mystery Novel", 12.00);
  GroceryItem pasta = new GroceryItem("Pasta Sauce", 2.50, false);
  GroceryItem yogurt = new GroceryItem("Yogurt", 1.00, true);
  Item cup = new Item("Cup", 6.00);
  SoftwareItem tetris = new SoftwareItem("iTetris", 5.00, "Mac OS X");

  Store[] stores = { store1, store2 };
  Customer[] customer = { bill, alice };
  Item[] shipment1 = { coffee, smb, sdp, scone, gummies, deMarkers };
  Item[] shipment2 = { bejeweled, mysteryNovel, pasta, yogurt, cup,
    tetris };
  store1.receiveShipment(shipment1);
  store2.receiveShipment(shipment2);

  for (int i = 0; i < stores.length; i++) {
   System.out.println("Welcome!");
   do {
    System.out
      .println("------------------------------------------------------");
    System.out.println(stores[i].toString());
    System.out
      .println("If you would like to buy something, enter the number"
        + " that corresponds with he item to add it to your cart.");
    System.out
      .println("If you do not see anything you would like, enter -1");
    userIndex = scan.nextInt();
    if (userIndex != -1) {
     customer[i].addToCart(stores[i].getItem(userIndex));
     System.out.println(customer[i].toString());
     System.out
       .println("If you would like to checkout, please type 'yes'");
     System.out
       .println("If you would like to abandon your shopping cart, please type 'leave'");
     System.out
       .println("If you would like to remove the last item from your cart, please type 'remove'");
     System.out
       .println("If you would like to add more items, please type another word or letter");
     user = scan.next();
     System.out.println("\n");
     if (user.equals("yes")) {
      boolean done = stores[i].makeASale(customer[i]);
      if (done) {
       System.out.println("Thank you for your purchase! You have "
           + nf.format(customer[i].getMoney())
           + ". Would you like to keep shopping?");
       customer[i].reset();
       user = scan.next();
      } else {
       customer[i].keepShopping(false);
       System.out.println("\n\nGoodbye!");
      }
      if (user.equals("no")) {
       System.out.println("\nGoodbye!");
       customer[i].keepShopping(false);
      }
     } else if (user.equals("leave")) {
      System.out.println("\nGoodbye!");
      stores[i].receiveShipment(customer[i].checkout());
      customer[i].keepShopping(false);
     } else if (user.equals("remove")) {
      Item[] removedItem = { customer[i].removeLastItem() };
      stores[i].receiveShipment(removedItem);
     } else {
      user = "continue";
      customer[i].keepShopping(true);
     }
    } else {
     customer[i].keepShopping(false);
    }
   } while (customer[i].isShopping() && stores[i].hasMoreItems());
  }
 }
}