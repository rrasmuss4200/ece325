import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Car implements Comparable<Car> {
    int maxSpeed;
    String make;

    public Car(String make, int maxSpeed) {
        this.make = make;
        this.maxSpeed = maxSpeed;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getMake() {
        return this.make;
    }

    public void setMaxSpeed(int i) {
        this.maxSpeed = i;
    }

    @Override
    // this method will sort by maxSpeed first, then Make after that
    public int compareTo(Car o) {
        int i = Integer.compare(maxSpeed, o.getMaxSpeed());
        if(i != 0) return i;
        return make.compareTo(o.getMake());
        }


    public static void main (String[] args) {
        ArrayList<Car> s = new ArrayList<>();
        s.add(new Car("Ferrari", 300));
        s.add(new Car("Lamborghini", 320));
        s.add(new Car("Alfa Romeo", 300));
        s.add(new Car("Jeep", 180));
        s.add(new Car("Jeep", 180));
        s.add(new Car("Alfa Romeo", 250));
        Collections.sort(s);
        System.out.println(s); // compiler doesn't know how to sort this

    }
}