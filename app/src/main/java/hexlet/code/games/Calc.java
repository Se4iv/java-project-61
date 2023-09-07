package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomNum;

public class Calc {
    public static final String RULE = "What is the result of the expression?";
    private static final int MULTIPLIER = 25;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void startGame() {
        String[][] array = new String[Engine.GAMESCOUNT][];
        for (int i = 0; i < Engine.GAMESCOUNT; i++) {
            int firstnumber = RandomNum.generateNumber(MULTIPLIER);
            int secondnumber = RandomNum.generateNumber(MULTIPLIER);
            String sign = OPERATORS[RandomNum.generateNumber(OPERATORS.length) - 1];
            // Добавляем массив выражения и правильного ответа
            array[i] = new String[]{firstnumber + " " + sign + " "
                    + secondnumber,
                    String.valueOf(calculateResult(firstnumber, secondnumber, sign))};
        }
        //передаем управление в секцию вопросов и ответов
        Engine.processGame(array, RULE);
    }

    private static Integer calculateResult(int number1, int number2, String sign1) {
        switch (sign1) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            default:
                return null;
        }
    }
}
