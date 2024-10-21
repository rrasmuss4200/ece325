import java.util.List;

public class Box<N extends Number> {
    private N contents;

    public void setContents(N contents) {
        this.contents = contents;
    }

    public N getContents() {
        return this.contents;
    }

    public static void printAll(List<Number> list) {
        for(Number n : list) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        System.out.println("yes");
        Box<Number> boxNum = new Box<>();
        Box<Integer> boxInt = new Box<>(); // yes

    }
}