package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Even {
    public static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static int randomvalue;

    public static int getRandomvalue() {
        return randomvalue;
    }

    public static void setRandomvalue(int randomvalue1) {
        Even.randomvalue = randomvalue1;
    }

    private static final int MULTIPLIER = 1000;

    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            setRandomvalue(Random.generateNumber(MULTIPLIER));
            // Добавляем массив числа и правильного ответа
            array[i] = new String[]{String.valueOf(getRandomvalue()), getResult(getRandomvalue())};
        }
        //передаем управление в секцию вопросов и ответов
        Engine.processGame(array, scanner, username, "Even");

    }

    private static String getResult(int value) {
        return value % 2 == 0 ? "yes" : "no";
    }


}
