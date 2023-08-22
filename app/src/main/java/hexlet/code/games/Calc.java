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

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[3][];
        int result = 0;
        for (int i = 0; i < 3; i++) {
            setFirstnumber(Random.generateNumber() / 4);
            setSecondnumber(Random.generateNumber() / 4);
            setSign(Random.generateSign());
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
