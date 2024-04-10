import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int choice;
        char size;
        boolean pepperoni, sausage, mushrooms, vegan;
        Scanner keyboard = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        PizzaOrder myOrder = new PizzaOrder();

        do {
            System.out.println("~~~Welcome to MiraCosta's Pizza Parlor~~~");
            System.out.println("Enter (1) to order a Pizza");
            System.out.println("Enter (2) to view order");
            System.out.println("Enter (3) to checkout");
            choice = keyboard.nextInt();
            System.out.println();
            keyboard.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("What size pizza would you like (S, M, L)?");
                    size = keyboard.next().toUpperCase().charAt(0);
                    if (size != 'S' && size != 'M' && size != 'L') {
                        System.err.println("Pizza size must be S, M, or L");
                        break;
                    }
                    System.out.println("Please enter your toppings:");
                    System.out.print("Pepperoni (Y/N)? ");
                    pepperoni = keyboard.next().toUpperCase().startsWith("Y");
                    System.out.print("Sausage   (Y/N)? ");
                    sausage = keyboard.next().toUpperCase().startsWith("Y");
                    System.out.print("Mushrooms (Y/N)? ");
                    mushrooms = keyboard.next().toUpperCase().startsWith("Y");
                    System.out.print("Vegan     (Y/N)? ");
                    vegan = keyboard.next().toUpperCase().startsWith("Y");

                    myOrder.addPizzaToOrder(size, pepperoni, sausage, mushrooms, vegan);

                    break;

                case 2:
                    System.out.println(myOrder);
                    break;

                case 3:
                    System.out.println("Please pay " + currency.format(myOrder.calcCost()) + " at the counter.");
                    System.out.println("Thanks for visiting MiraCosta's Pizza Parlor!");
                    break;
            }
            System.out.println();
        } while (choice != 3);

        keyboard.close();
    }

}
