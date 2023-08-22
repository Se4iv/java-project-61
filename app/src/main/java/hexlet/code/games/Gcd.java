package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Gcd {
    public static int getFirstnumber() {
        return firstnumber;
    }

    public static void setFirstnumber(int firstnumber) {
        Gcd.firstnumber = firstnumber;
    }

    private static int firstnumber;

    public static int getSecondnumber() {
        return secondnumber;
    }

    public static void setSecondnumber(int secondnumber) {
        Gcd.secondnumber = secondnumber;
    }

    private static int secondnumber;
    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[3][];
        int minumber = 0;
        int maxnumber = 0;
        int mod = 0;
        for (int i = 0; i < 3; i++) {
            setFirstnumber(Random.generateNumber());
            setSecondnumber(Random.generateNumber());
            maxnumber = Math.max(getFirstnumber(), getSecondnumber());
            minumber = Math.min(getFirstnumber(), getSecondnumber());
            do {
                mod = maxnumber % minumber;
                if (mod == 0) {
                    break;
                }
                maxnumber = minumber;
                minumber = mod;
            } while (mod != 0);
            array[i] = new String[]{getFirstnumber() + " " + getSecondnumber(), String.valueOf(minumber)};
        }
        Engine.processGame(array, scanner, username);
    }
}
