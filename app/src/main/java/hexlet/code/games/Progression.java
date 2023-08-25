package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;
import java.util.StringJoiner;

public class Progression {
    private static int startnumber;
    private static int difference;
    private static int missingnumber;
    private static int length;

    public static int getStartnumber() {
        return startnumber;
    }

    public static void setStartnumber(int startnumber) {
        Progression.startnumber = startnumber;
    }

    public static int getDifference() {
        return difference;
    }

    public static void setDifference(int difference) {
        Progression.difference = difference;
    }

    public static int getMissingnumber() {
        return missingnumber;
    }

    public static void setMissingnumber(int missingnumber) {
        Progression.missingnumber = missingnumber;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Progression.length = length;
    }

    private static int startmultiplier = 100;
    private  static int differencemultiplier = 7;
    private static int lengthmultiplier = 5;
    private static int minlengthmultiplier = 5;

    public static int getStartmultiplier() {
        return startmultiplier;
    }

    public static int getDifferencemultiplier() {
        return differencemultiplier;
    }

    public static int getLengthmultiplier() {
        return lengthmultiplier;
    }

    public static int getMinlengthmultiplier() {
        return minlengthmultiplier;
    }


    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.getGamescount()][];

        for (int i = 0; i < Engine.getGamescount(); i++) {
            setStartnumber(Random.generateNumber(getStartmultiplier()));
            setDifference(Random.generateNumber(getDifferencemultiplier()));
            setLength(Random.generateNumber(getLengthmultiplier()) + getMinlengthmultiplier());
            setMissingnumber(Random.generateNumber(getLength()));
            StringJoiner stringJoiner = new StringJoiner(" ");
            int nextnumber = getStartnumber();
            int missednumber = 0;
            for (int j = 0; j < getLength(); j++) {
                if (j == getMissingnumber() - 1) {
                    stringJoiner.add("..");
                    missednumber = nextnumber;
                    nextnumber += getDifference();
                } else {
                    stringJoiner.add(String.valueOf(nextnumber));
                    nextnumber += getDifference();
                }
            }
            array[i] = new String[]{String.valueOf(stringJoiner), String.valueOf(missednumber)};
        }

        Engine.processGame(array, scanner, username);
    }
}
