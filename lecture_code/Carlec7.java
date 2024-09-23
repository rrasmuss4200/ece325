public class Carlec7 {
    private int maxSpeed;
    private Integer wheels;

    public Carlec7() {
        System.out.printf("%d\n", this.maxSpeed);
        System.out.printf("%d\n", this.wheels);
    }

    public static void main(String[] args) {
        Carlec7 car = new Carlec7(); // prints 0 then null
    }
}
