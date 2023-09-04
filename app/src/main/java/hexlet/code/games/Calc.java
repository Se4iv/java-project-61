package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Calc {
    public static final String RULE = "What is the result of the expression?";
    private static final int LESSTHEN = 3; //для определения знака
    private static final int MORETHEN = 2; //для определения знака
    private static final int MULTIPLIER = 25;

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int firstnumber = Random.generateNumber(MULTIPLIER);
            int secondnumber = Random.generateNumber(MULTIPLIER);
            char sign = generateSign();
            // Добавляем массив выражения и правильного ответа
            array[i] = new String[]{firstnumber + " " + sign + " "
                    + secondnumber,
                    String.valueOf(getResult(firstnumber, secondnumber, sign))};
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

    private static int getResult(int number1, int number2, char sign1) {
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
        return result;
    }
}
