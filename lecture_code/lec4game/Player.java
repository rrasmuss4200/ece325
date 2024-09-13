// public class Player {
//     static int number;
//     String name;

//     public Player(String s) {
//         name = s;
//     }

//     public static int guess() {
//         int max = 9;
//         int min = 0;
//         int range = max - min + 1;

//         number = (int) (Math.random() * range);
//     }
// }

// In class solution

public class Player {
    int number;
    String name;

    public Player(String name) {
        this.name = name;
    }

    public void guess() {
        int guess = (int) (Math.random() * 10);
        this.number = guess;
    }
}