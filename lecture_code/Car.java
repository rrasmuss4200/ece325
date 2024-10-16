import java.io.Serializable;

public class Car implements Serializable {
    int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int i) {
        this.maxSpeed = i;
    }
}