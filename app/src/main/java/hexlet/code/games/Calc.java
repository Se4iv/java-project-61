package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Calc {
    public static final String RULE = "What is the result of the expression?";
    private static final int LESSTHEN = 3; //для определения знака
    private static final int MORETHEN = 2; //для определения знака
    public static int getFirstnumber() {
        return firstnumber;
    }

    public static void setFirstnumber(int firstnumber1) {
        Calc.firstnumber = firstnumber1;
    }

    private static int firstnumber;

    public static int getSecondnumber() {
        return secondnumber;
    }

    public static void setSecondnumber(int secondnumber1) {
        Calc.secondnumber = secondnumber1;
    }

    private static int secondnumber;

    public static char getSign() {
        return sign;
    }

    public static void setSign(char sign1) {
        Calc.sign = sign1;
    }

    private static char sign;

    private static final int MULTIPLIER = 25;

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            setFirstnumber(Random.generateNumber(MULTIPLIER));
            setSecondnumber(Random.generateNumber(MULTIPLIER));
            setSign(generateSign());
            // Добавляем массив выражения и правильного ответа
            array[i] = new String[]{getFirstnumber() + " " + getSign() + " "
                    + getSecondnumber(),
                    getResult(getFirstnumber(), getSecondnumber(), getSign())};
        }
        //передаем управление в секцию вопросов и ответов
        Engine.processGame(array, scanner, username, "Calc");
    }

    private static char generateSign() {
        int i = Random.generateNumber(MULTIPLIER);
        if (i < MULTIPLIER / LESSTHEN) {
            return '+';
        } else if  (i < MULTIPLIER / LESSTHEN * MORETHEN) {
            return  '-';
        } else {
            return '*';
        }
    }

    private static String getResult(int number1, int number2, char sign1) {
        int result = 0;
        switch (sign1) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            default:
                break;
        }
        return String.valueOf(result);
    }
}
