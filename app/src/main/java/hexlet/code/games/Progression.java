package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Arrays;
import java.util.Scanner;

public class Progression {
    public static final String RULE = "What number is missing in the progression?";
    private static final int STARTMULTIPLIER = 100;
    private static final int DIFFERENCEMULTIPLIER = 7;
    private static final int LENGTHMULTIPLIER = 5;
    private static final int MINLENGTHMULTIPLIER = 5;


    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];

        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int startnumber = Random.generateNumber(STARTMULTIPLIER);
            int difference = Random.generateNumber(DIFFERENCEMULTIPLIER);
            int length = Random.generateNumber(LENGTHMULTIPLIER) + MINLENGTHMULTIPLIER;
            int missingposition = Random.generateNumber(length);
            int[] result = getResult(startnumber, difference, length);
            int missednumber = result[missingposition];
            array[i] = new String[]{Arrays.toString(result).replace(",", "")
                    .replace(String.valueOf(missednumber), ".."), String.valueOf(missednumber)};
        }

        Engine.processGame(array, scanner, username, "Progression");
    }

    private static int[] getResult(int number1, int diff, int len) {
        int[] result = new int[len];
        int nextnumber = number1;
        for (int j = 0; j < len; j++) {
            result[j] = nextnumber;
            nextnumber += diff;
        }
        return result;
    }
}
