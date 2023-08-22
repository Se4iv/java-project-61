package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Random;

import java.util.Scanner;

public class Even {

    private static int randomvalue;

    public static int getRandomvalue() {
        return randomvalue;
    }

    public static void setRandomvalue(int randomvalue) {
        Even.randomvalue = randomvalue;
    }
    public static void startGame(Scanner scanner, String username) {
        String[][] array = new String[3][];
        for (int i = 0; i < 3; i++) {
            setRandomvalue(Random.generateNumber());
            // Добавляем массив числа и правильного ответа
            array[i] = new String[]{String.valueOf(getRandomvalue()), getRandomvalue() % 2 == 0 ? "yes" : "no"};
        }
        //передаем управление в секцию вопросов и ответов
        Engine.processGame(array, scanner, username);

    }


}
