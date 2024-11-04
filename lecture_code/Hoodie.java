import java.util.EnumSet;
import java.util.Set;

public class Hoodie {
    private Set<Size> sizes;

    public void setAvailableSizes(Set<Size> sizes) {
        this.sizes = sizes;
    }

    public enum Size {
        S, M, L, XL
    }

    public static void main(String[] args) {
        Hoodie hood = new Hoodie();

        hood.setAvailableSizes(EnumSet.of(Size.S, Size.M));
    }

}
