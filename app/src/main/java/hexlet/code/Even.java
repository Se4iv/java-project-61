package hexlet.code;

import java.util.Scanner;

public class Even {

    public static int randomvalue;
    public static String check;

    public static int counttrys = 0;

    public static boolean correctanswer = true;

    public static int getRandomvalue() {
        return randomvalue;
    }

    public static void setRandomvalue(int randomvalue) {
        Even.randomvalue = randomvalue;
    }

    public static String getCheck() {
        return check;
    }

    public static void setCheck(String check) {
        Even.check = check;
    }

    public static boolean isCorrectanswer() {
        return correctanswer;
    }

    public static void setCorrectanswer(boolean correctanswer) {
        Even.correctanswer = correctanswer;
    }

    public static int generateNumber() {
        return (int) Math.round(Math.random() * 1000);
    }

    public static boolean isCorrect(String answer, int number) {
        if (number % 2 == 0) {
            setCheck("yes");
        } else {
            setCheck("no");
        }
        return answer.toLowerCase().equals(getCheck());
    }

    public static void game(Scanner scanner) {
        String username = Cli.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (isCorrectanswer() && counttrys < 3) {
            setRandomvalue(generateNumber());
            System.out.println("Question: " + getRandomvalue());
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            setCorrectanswer(isCorrect(answer, getRandomvalue()));
            if (isCorrectanswer()) {
                System.out.println("Correct!");
                counttrys++;
            } else {
                System.out.println("Wrong! See you next time!");
                return;
            }

        }
        System.out.println("Congratulations, " + username + "!");
    }


}
