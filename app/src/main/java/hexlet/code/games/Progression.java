package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomNum;

import java.util.Arrays;

public class Progression {
    public static final String RULE = "What number is missing in the progression?";
    private static final int STARTMULTIPLIER = 100;
    private static final int DIFFERENCEMULTIPLIER = 7;
    private static final int LENGTHMULTIPLIER = 5;
    private static final int MINLENGTHMULTIPLIER = 5;


    public static void startGame() {
        String[][] array = new String[Engine.GAMESCOUNT][];

        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int startnumber = RandomNum.generateNumber(STARTMULTIPLIER);
            int difference = RandomNum.generateNumber(DIFFERENCEMULTIPLIER);
            int length = RandomNum.generateNumber(LENGTHMULTIPLIER) + MINLENGTHMULTIPLIER;
            int missingposition = RandomNum.generateNumber(length) - 1;
            int[] result = generateProgression(startnumber, difference, length);
            int missednumber = result[missingposition];
            array[i] = new String[]{Arrays.toString(result).replace(",", "").replace("[", "")
                    .replace("]", "").replace(String.valueOf(missednumber), ".."), String.valueOf(missednumber)};
        }

        Engine.processGame(array, RULE);
    }

    private static int[] generateProgression(int number1, int diff, int len) {
        int[] result = new int[len];
        int nextnumber = number1;
        for (int j = 0; j < len; j++) {
            result[j] = nextnumber;
            nextnumber += diff;
        }
        return result;
    }
}
