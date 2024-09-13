// public class GuessGame {
//     static Player p1;
//     static Player p2;
//     static Player p3;
//     static int ans;

//     public static boolean playGame() {
//         int max = 9;
//         int min = 0;
//         int range = max - min + 1;

//         ans = (int) (Math.random() * range);
//         System.out.printf("Our players are %s, %s and %s\n", p1.name, p2.name, p3.name);
//         System.out.println("I am thinking of a number between 0 and 9...");

//         while (p1.number != ans && p2.number != ans && p3.number != ans) {
//             System.out.printf("%s guessed: %d", p1.name, p1.number);
//             System.out.printf("%s guessed: %d", p2.name, p2.number);
//             System.out.printf("%s guessed: %d", p3.name, p3.number);

//             if (p1.number == ans || p2.number == ans && p3.number == ans) {
//                 System.out.println("We have a winner!");
//                 System.out.printf("%s")
//             } else {
//                 System.out.println("Let's try again.");

//             }
//         }

//     }
// }

// In class solution
public class GuessGame {
    Player p1;

    public void startGame() {
        p1 = new Player("CP");
        int guessP1 = 0;
        int targetNumber = (int) (Math.random() * 10);

        while(true) {
            p1.guess();
            guessP1 = p1.number;
            System.out.println(p1.name + " guessed: " + guessP1);
            if(guessP1 == targetNumber){
                System.out.println("We have a winner!");
                break; // Should not break to check answers of other players
            }
            else
                System.out.println("Let's try again.");
        }
    }
}