package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Calc {
    public static int getFirstnumber() {
        return firstnumber;
    }

    public static void setFirstnumber(int firstnumber) {
        Calc.firstnumber = firstnumber;
    }

    private static int firstnumber;

    public static int getSecondnumber() {
        return secondnumber;
    }

    public static void setSecondnumber(int secondnumber) {
        Calc.secondnumber = secondnumber;
    }

    private static int secondnumber;

    public static char getSign() {
        return sign;
    }

    public static void setSign(char sign) {
        Calc.sign = sign;
    }

    private static char sign;

    private static int miltiplier = 25;

    public static int getMiltiplier() {
        return miltiplier;
    }

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.getGamescount()][];
        int result = 0;
        for (int i = 0; i < Engine.getGamescount(); i++) {
            setFirstnumber(Random.generateNumber(getMiltiplier()));
            setSecondnumber(Random.generateNumber(getMiltiplier()));
            setSign(Random.generateSign(getMiltiplier()));
            switch (getSign()) {
                case '+':
                    result = getFirstnumber() + getSecondnumber();
                    break;
                case '-':
                    result = getFirstnumber() - getSecondnumber();
                    break;
                case '*':
                    result = getFirstnumber() * getSecondnumber();
                    break;
                default:
                    break;
            }
            // Добавляем массив выражения и правильного ответа
            array[i] = new String[]{getFirstnumber() + " " + getSign() + " "
                    + getSecondnumber(),
                    String.valueOf(result)};
        }
        //передаем управление в секцию вопросов и ответов
        Engine.processGame(array, scanner, username);
    }
}
