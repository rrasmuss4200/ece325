import java.util.ArrayList;

public class Zoo {
    private PetStore p;
    ArrayList<Animal> inventory;

    public void addToInventory(Animal a) {
        inventory.add(a);
        if (a instanceof Pet) {
            p.addToInventory((Pet)a); // need this cast so we can access it's methods
            // done explicitly since animal doesn't know about Pet
        }

    }

    public static void main(String args[]) {
        Animal a1 = Dogs();
    }

}
