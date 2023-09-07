package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomNum;

public class Prime {
    public static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MULTIPLIER = 1000;

    public static void startGame() {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int randomnumber = RandomNum.generateNumber(MULTIPLIER);
            array[i] = new String[]{String.valueOf(randomnumber), isPrime(randomnumber)  ? "yes" : "no"};
        }
        Engine.processGame(array, RULE);
    }

    private static boolean isPrime(int number) {
        int i = 2;
        int j = 0;
        while (i * i <= number && j != 1) {
            if (number % i == 0) {
                j = 1;
            }
            i++;
        }
        return j != 1;
    }
}
