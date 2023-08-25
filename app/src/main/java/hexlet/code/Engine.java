package hexlet.code;


import java.util.Scanner;

public class Engine {
    public static int getGamescount() {
        return gamescount;
    }

    private static final int gamescount = 3;
    private static int counttrys = 0;
    private static boolean correctanswer = true;

    public static void processGame(String[][] qustionsandanswers, Scanner scanner, String username) {
        while (isCorrectAnswer() && counttrys < getGamescount()) {
            System.out.println("Question: " + qustionsandanswers[counttrys][0]);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            setCorrectanswer(isCorrect(answer, qustionsandanswers[counttrys][1]));
            if (isCorrectAnswer()) {
                System.out.println("Correct!");
                counttrys++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + qustionsandanswers[counttrys][1] + "'.\n"
                        + "Let's try again, " + username + "!");
                break;
            }

        }
        if (counttrys == getGamescount()) {
            System.out.println("Congratulations, " + username + "!");
        }
    }

    public static boolean isCorrectAnswer() {
        return correctanswer;
    }

    public static void setCorrectanswer(boolean correctanswer1) {
        correctanswer = correctanswer1;
    }

    public static boolean isCorrect(String answer, String correct) {
        return answer.equalsIgnoreCase(correct);
    }
}

