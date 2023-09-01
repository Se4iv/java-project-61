package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;
import java.util.StringJoiner;

public class Progression {
    public static final String RULE = "What number is missing in the progression?";
    private static int startnumber;
    private static int difference;
    private static int missingnumber;
    private static int length;

    public static int getStartnumber() {
        return startnumber;
    }

    public static void setStartnumber(int startnumber1) {
        Progression.startnumber = startnumber1;
    }

    public static int getDifference() {
        return difference;
    }

    public static void setDifference(int difference1) {
        Progression.difference = difference1;
    }

    public static int getMissingnumber() {
        return missingnumber;
    }

    public static void setMissingnumber(int missingnumber1) {
        Progression.missingnumber = missingnumber1;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length1) {
        Progression.length = length1;
    }

    private static final int STARTMULTIPLIER = 100;
    private static final int DIFFERENCEMULTIPLIER = 7;
    private static final int LENGTHMULTIPLIER = 5;
    private static final int MINLENGTHMULTIPLIER = 5;


    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];

        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            setStartnumber(Random.generateNumber(STARTMULTIPLIER));
            setDifference(Random.generateNumber(DIFFERENCEMULTIPLIER));
            setLength(Random.generateNumber(LENGTHMULTIPLIER) + MINLENGTHMULTIPLIER);
            setMissingnumber(Random.generateNumber(getLength()));
            array[i] = getResult(getStartnumber(), getDifference(), getLength(), getMissingnumber());
        }

        Engine.processGame(array, scanner, username, "Progression");
    }

    private static String[] getResult(int number1, int diff, int len, int missnumber) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        int nextnumber = number1;
        int missednumber = 0;
        for (int j = 0; j < len; j++) {
            if (j == missnumber - 1) {
                stringJoiner.add("..");
                missednumber = nextnumber;
                nextnumber += diff;
            } else {
                stringJoiner.add(String.valueOf(nextnumber));
                nextnumber += diff;
            }
        }
        return new String[]{String.valueOf(stringJoiner), String.valueOf(missednumber)};
    }
}
