package hexlet.code;


import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    public static final int GAMESCOUNT = 3;
    public static void processGame(String[][] qustionsandanswers, Scanner scanner, String username, String gamename) {
        getGameRules(gamename); //
        for (String[] next : qustionsandanswers) {
            System.out.println("Question: " + next[0]);
            String answer = scanner.next();
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
    private static void getGameRules(String gamename) {
        switch (gamename) {
            case "Even":
                System.out.println(Even.RULE);
                break;
            case "Calc":
                System.out.println(Calc.RULE);
                break;
            case "Gcd":
                System.out.println(Gcd.RULE);
                break;
            case "Progression":
                System.out.println(Progression.RULE);
                break;
            case "Prime":
                System.out.println(Prime.RULE);
                break;
            default:
                break;
        }
    }
}

