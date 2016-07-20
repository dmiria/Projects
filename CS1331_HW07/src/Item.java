/**
* This class represents the things to buy in a store. This 
* contains what the item is, how much the item  will cost, 
* the tax rate on the item.
* 
* @author D'Miria Collins
*@version 1.0
*
*/
import java.text.*;

public class Item {
 private static double ITEM_TAX_RATE=0.09;
 private String name;
 private double price, taxRate;
/**
* Constructs a method that takes in the name of the item, the price 
* of the item and the tax on the item. 
* 
* @param name  
* @param price
* @param tax rate
*/

 public Item(String name, double price, double taxRate){
  this.name = name;
  this.price = price;
  this.taxRate = taxRate;
 }
/**
* Constructs a method that takes in the name of the item and the price of the item.
* @param name of the item
* @param price of the item
*/

 public Item(String name, double price){
  this.name = name;
  this.price = price;
  taxRate = ITEM_TAX_RATE;
 }
/**
* This method returns the price of the item.
* @return the price of the item
*/
 public double getPrice(){
  return price;
 }
/**
* This method return the price of the item after tax
* @return the price with tax
*/
 public double getPriceAfterTax(){
  return price*(1+taxRate);
 }
/**
* This method gets a String representation of the Item
* @return the name of the item
*/
 public String toString(){
  NumberFormat nf = NumberFormat.getCurrencyInstance();
  return "Item Name: "+ name + "  Price: "+nf.format(price);
 }
}
