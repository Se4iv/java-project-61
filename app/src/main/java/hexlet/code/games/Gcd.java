package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Gcd {
    public static final String RULE = "Find the greatest common divisor of given numbers.";
    private static final int MULTIPLIER = 100;

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int firstnumber = Random.generateNumber(MULTIPLIER);
            int secondnumber = Random.generateNumber(MULTIPLIER);
            array[i] = new String[]{firstnumber + " "
                    + secondnumber, String.valueOf(getResult(firstnumber, secondnumber))};
        }
        Engine.processGame(array, scanner, username, "Gcd");
    }

    private static int getResult(int number1, int number2) {
        int minumber;
        int maxnumber;
        int mod;
        maxnumber = Math.max(number1, number2);
        minumber = Math.min(number1, number2);
        do {
            mod = maxnumber % minumber;
            if (mod == 0) {
                break;
            }
            maxnumber = minumber;
            minumber = mod;
        } while (mod != 0);
        return minumber;
    }
}
