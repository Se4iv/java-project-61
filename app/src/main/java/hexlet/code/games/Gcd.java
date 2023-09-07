package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomNum;

public class Gcd {
    public static final String RULE = "Find the greatest common divisor of given numbers.";
    private static final int MULTIPLIER = 100;

    public static void startGame() {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int firstnumber = RandomNum.generateNumber(MULTIPLIER);
            int secondnumber = RandomNum.generateNumber(MULTIPLIER);
            array[i] = new String[]{firstnumber + " "
                    + secondnumber, String.valueOf(calculateGcd(firstnumber, secondnumber))};
        }
        Engine.processGame(array, RULE);
    }

    private static int calculateGcd(int number1, int number2) {
        int maxnumber = Math.max(number1, number2);
        int minumber = Math.min(number1, number2);
        int mod;
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
