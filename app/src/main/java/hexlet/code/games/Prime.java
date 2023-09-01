package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Random;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;
import java.util.function.Predicate;

public class Prime {
    public static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
        61, 67, 71, 73, 79, 83, 89, 97, 101};

    private static Predicate<Integer> predicate = t -> ArrayUtils.contains(PRIMES, t);
    private static int randomnumber;

    private static final int MULTIPLIER = PRIMES[PRIMES.length - 1];

    public static int getRandomnumber() {
        return randomnumber;
    }

    public static void setRandomnumber(int randomnumber1) {
        Prime.randomnumber = randomnumber1;
    }

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            setRandomnumber(Random.generateNumber(MULTIPLIER));
            array[i] = new String[]{String.valueOf(getRandomnumber()), getResult(getRandomnumber())};
        }
        Engine.processGame(array, scanner, username, "Prime");
    }

    private static String getResult(int number) {
        return predicate.test(number) ? "yes" : "no";
    }
}
