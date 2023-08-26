package hexlet.code.games;


import java.util.Scanner;
import java.util.function.Predicate;

import hexlet.code.Engine;
import hexlet.code.Random;
import org.apache.commons.lang3.ArrayUtils;

public class Prime {
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
        61, 67, 71, 73, 79, 83, 89, 97, 101};

    private static Predicate<Integer> predicate = t -> ArrayUtils.contains(PRIMES, t);
    private static int randomnumber;

    public static int getMultiplier() {
        return MULTIPLIER;
    }

    private static final int MULTIPLIER = PRIMES[PRIMES.length - 1];

    public static int getRandomnumber() {
        return randomnumber;
    }

    public static void setRandomnumber(int randomnumber) {
        Prime.randomnumber = randomnumber;
    }

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.getGamescount()][];
        boolean isprime;
        for (int i = 0; i < Engine.getGamescount(); i++) {
            setRandomnumber(Random.generateNumber(getMultiplier()));
            isprime = predicate.test(getRandomnumber());
            array[i] = new String[]{String.valueOf(getRandomnumber()), isprime ? "yes" : "no"};
        }
        Engine.processGame(array, scanner, username);
    }
}
