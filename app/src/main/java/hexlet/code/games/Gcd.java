package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Gcd {
    public static final String RULE = "Find the greatest common divisor of given numbers.";
    public static int getFirstnumber() {
        return firstnumber;
    }

    public static void setFirstnumber(int firstnumber1) {
        Gcd.firstnumber = firstnumber1;
    }

    private static int firstnumber;

    public static int getSecondnumber() {
        return secondnumber;
    }

    public static void setSecondnumber(int secondnumber1) {
        Gcd.secondnumber = secondnumber1;
    }

    private static int secondnumber;
    private static final int MULTIPLIER = 100;

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            setFirstnumber(Random.generateNumber(MULTIPLIER));
            setSecondnumber(Random.generateNumber(MULTIPLIER));
            array[i] = new String[]{getFirstnumber() + " "
                    + getSecondnumber(), getResult(getFirstnumber(), getSecondnumber())};
        }
        Engine.processGame(array, scanner, username, "Gcd");
    }

    private static String getResult(int number1, int number2) {
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
        return String.valueOf(minumber);
    }
}
