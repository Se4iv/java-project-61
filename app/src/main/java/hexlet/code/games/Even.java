package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomNum;

public class Even {
    public static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int MULTIPLIER = 1000;

    public static void startGame() {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int randomvalue = RandomNum.generateNumber(MULTIPLIER);
            // Добавляем массив числа и правильного ответа
            array[i] = new String[]{String.valueOf(randomvalue), isEven(randomvalue) ? "yes" : "no"};
        }
        //передаем управление в секцию вопросов и ответов
        Engine.processGame(array, RULE);

    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }


}
