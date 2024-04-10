public class Pizza {
    // Fields
    private boolean mushrooms, pepperoni, sausage, vegan;
    private char size;

    // Constructor
    public Pizza(char size, boolean pepperoni, boolean sausage, boolean mushrooms, boolean vegan) {
        this.size = size;
        this.pepperoni = pepperoni;
        this.sausage = sausage;
        this.mushrooms = mushrooms;
        this.vegan = vegan;
    }

    public char getSize() {
        return size;
    }

    public int getNumToppings() {
        int count = 0;
        if (pepperoni) count++;
        if (sausage) count++;
        if (mushrooms) count++;
        if (vegan) count++;

        return count;
    }

    // toString()
    public String toString() {
        String output = "Pizza [Size=" + size;
        if (pepperoni) output += ", Pepperoni";
        if (sausage) output += ", Sausage";
        if (mushrooms) output += ", Mushrooms";
        if (vegan) output += ", Vegan";

        output += "]";
        return output;
    }
}
