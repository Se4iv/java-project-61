package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int GAMESCOUNT = 3;
    public static void processGame(String[][] qustionsandanswers, String gamerules) {
        String username = Cli.greeting();
        System.out.println(gamerules);
        for (String[] next : qustionsandanswers) {
            System.out.println("Question: " + next[0]);
            String answer = new Scanner(System.in).next();
            System.out.println("Your answer: " + answer);
            if (answer.equalsIgnoreCase(next[1])) {
                java.lang.System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + next[1] + "'.\n"
                        + "Let's try again, " + username + "!");
                return;
            }

        }
        System.out.println("Congratulations, " + username + "!");

    }
}

