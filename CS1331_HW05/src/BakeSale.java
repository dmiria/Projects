import java.util.Scanner;

/**
 * The BakeSale class simulates a bake sale. The 
 * @author Elizabeth
 *
 */
public class BakeSale {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //make new counter objects to keep track of our items
        Counter cupcakes = new Counter("Cupcakes", 24);
        Counter brownies = new Counter("Brownies", 30);
        Counter cookies = new Counter("Cookies", 12);

        //we want our program to loop until we have sold everyhing
        while (Counter.getTotalCount() > 0) {
            System.out.print("Welcome to our bake sale! \n" +
            		"Would you like to buy something? Or do you have a delivery? ");
            
            //since we allow for people to give us deliveries and buy things, we have to 
            //keep track of this
            boolean delivery = false;
            if (scan.nextLine().toLowerCase().contains("delivery"))
                delivery = true;
            
            //handles when someone is buying something
            if (!delivery) {
                //state what we have
                System.out.println("We have " + cupcakes.getCount()
                        + " cupcakes, " + brownies.getCount()
                        + " brownies, and " + cookies.getCount() + " cookies.");
                
                System.out.print("What item would you like to buy? ");

                //get the user's choice
                String choice = scan.nextLine();

                //if they say that they want all of something, we will give it to them!
                boolean all = false;
                if (choice.contains("all"))
                    all = true;
                
                //goes through each possible item they can buy
                if (choice.contains("cupcake")) {
                    //handle the all situation
                    if (all) {
                        System.out.println("Wow! Here are all of our cupcakes :]");
                        cupcakes.reset();
                    }
                    //if they don't say they want all, they just get 1, though if we don't have any
                    //left we want to let them know
                    else 
                        if (cupcakes.getCount() > 0) {
                            System.out.println("Here you go!");
                            cupcakes.changeCount(false);
                        } 
                        else
                            System.out.println("I'm sorry, we don't have any more cupcakes :[");
                } 
                else if (choice.contains("brownie")) {
                    if (all) {
                        System.out.println("Wow! Here are all of our brownies :]");
                        brownies.reset();
                    } 
                    else
                        if (brownies.getCount() > 0) {
                            System.out.println("Here you go!");
                            brownies.changeCount(false);
                        } 
                        else
                            System.out.println("I'm sorry, we don't have any more brownies :[");
                } 
                else if (choice.contains("cookie")) {
                    if (all) {
                        System.out.println("Wow! Here are all of our cookies :]");
                        cookies.reset();
                    } 
                    else{
                        if (cookies.getCount() > 0) {
                            System.out.println("Here you go!");
                            cookies.changeCount(false);
                        } 
                        else
                            System.out.println("I'm sorry, we don't have any more cookies :[");
                    }
                } 
                else
                    System.out.println("We don't sell that.");

            } 
            //handle the delivery case
            else {
                //get what they are delivering
                System.out.print("Great! What item do you have for us? ");
                String item = scan.nextLine();

                //get how many
                System.out.print("How many do you have? ");
                int num = scan.nextInt();
                
                // this is to get rid of the new line character after you get the int
                scan.nextLine();

                //add the items to our inventory
                if (item.contains("cupcake")) {
                    cupcakes.changeCount(true, num);
                } else if (item.contains("brownie")) {
                    brownies.changeCount(true, num);
                } else if (item.contains("cookie")) {
                    cookies.changeCount(true, num);
                }

                System.out.println("Thanks!");
            }
            
            //space for formatting
            System.out.println();

        }
        
        //we're done!
        System.out.println("We sold out! Goodbye");
    }

}
