package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        String[] rightchoice = {"0", "1", "2", "3", "4", "5", "6"};
        if (choice.equals("0")) {
            System.out.println("Farewell and good luck!");
            return;
        }
        if (!ArrayUtils.contains(rightchoice, choice)) {
            System.out.println("Wrong input! Please try start game again");
            return;
        }
        System.out.println("\nWelcome to the Brain Games!");
        String username = Cli.greeting(scanner);
        switch (choice) {
            case "2":
                Even.startGame(scanner, username);
                break;
            case "3":
                Calc.startGame(scanner, username);
                break;
            case "4":
                Gcd.startGame(scanner, username);
                break;
            case "5":
                Progression.startGame(scanner, username);
                break;
            case "6":
                Prime.startGame(scanner, username);
            default:
                break;
        }
        scanner.close();
    }
}
