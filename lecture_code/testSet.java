import java.util.HashSet;
import java.util.Set;

public class testSet {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<>();
        // all performed separatly
        s1.addAll(s2); // union

        s1.retainAll(s2); // intersection

        s1.removeAll(s2); // difference
    }
}