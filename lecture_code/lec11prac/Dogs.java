public class Dogs extends Canines implements Pet {

    public boolean likesMe() {
        return Math.random() > 0.05;
    }
    
    @Override
    public String pet() {
        return "Petting dogs";
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Bark");
    }
}
