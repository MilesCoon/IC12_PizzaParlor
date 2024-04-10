import java.text.NumberFormat;

public class PizzaOrder {
    private static final int MAX_PIZZAS = 100;
    private int numPies;
    // Class composition: new class PizzaOrder
    // made up of objects from Pizza
    private Pizza[] pies;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    public PizzaOrder() {
        numPies = 0;
        pies = new Pizza[MAX_PIZZAS];
    }

    public boolean addPizzaToOrder(char size, boolean pepperoni, boolean sausage, boolean mushrooms, boolean vegan) {
        if (numPies >= MAX_PIZZAS) return false;

        pies[numPies++] = new Pizza(size, pepperoni, sausage, mushrooms, vegan);
        return true;
    }

    public double calcCost() {
        double cost = 0.0;
        for (int i = 0; i < numPies; i++) {
            switch (pies[i].getSize()) {
                case 'S':
                case 's':
                    cost += 8.0;
                    break;
                case 'M':
                case 'm':
                    cost += 10.0;
                    break;
                case 'L':
                case 'l':
                    cost += 12.0;
                    break;
            }
            cost += pies[i].getNumToppings();
        }
        return cost;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("\nPizza Order: Number of Pies: ").append(numPies);
        for (int i = 0; i < numPies; i++) {
            output.append("\nPie #").append(i+1).append(": ").append(pies[i].toString());
        }
        output.append("\nTotal Cost = ").append(currency.format(calcCost()));
        return output.toString();
    }

}
