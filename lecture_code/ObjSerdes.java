import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjSerdes {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = null;
        FileOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Car car = new Car();
        car.setMaxSpeed(100);
        try {
            oos = new FileOutputStream("output.txt");
            out = new ObjectOutputStream(oos);
            out.writeObject(car);
            fis = new FileInputStream("input.txt");
            ois = new ObjectInputStream(fis);
            // .readObject()

        }
        finally {
            if(oos != null) oos.close();
            if(out != null) out.close();
            }
        }
}
