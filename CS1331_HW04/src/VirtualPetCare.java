import java.util.Scanner;

public class VirtualPetCare {
    public static void main(String[] args) {

        //make a new Pet variable. We will actually create
        //a Pet once we know if the user wants to name it
        Pet myPet = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Virtual Pet Care! We will give you a pet to " +
        		"play with and care for until you decide to leave.");
        System.out.println();
        System.out.println("Would you like to name your pet?");
        
        //get the users response and change it to all lower case - this way,
        //if the user inputs Yes or YES or yes, it will all register
        String response = scan.next().toLowerCase();
        if (response.equals("yes") || response.equals("y")) {
            System.out.println("What would you like to name it?");
            myPet = new Pet(scan.next());
        } 
        else
            myPet = new Pet("Scooby");

        //variable to hold onto the user's input while they
        //are interacting with their pet
        char in;
        
        do {
            //make time progress for the pet
            myPet.live();

            //print out the user's options
            System.out.println("________________________________");
            System.out.println(myPet);
            System.out.println();
            System.out.println("Press p to play with " + myPet.getName()
                    + "\nPress f to feed " + myPet.getName()
                    + "\nPress t to give " + myPet.getName() + " a treat"
                    + "\nPress q to quit or press any other letter to ignore "
                    + myPet.getName());

            //get the user input - we only care about the first letter they enter
            in = scan.next().toLowerCase().charAt(0);

            //do the appropriate action based on what they input
            if (in == 'p')
                myPet.play();
            else if (in == 'f')
                myPet.feed(false);
            else if (in == 't')
                myPet.feed(true);

        } while (in != 'q'); //loop until the user presses 'q'
        
        System.out.println("Goodbye!");
    }
}