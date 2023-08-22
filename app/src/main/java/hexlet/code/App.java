package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "0 - Exit\n"
                + "Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) {
            System.out.println("Farewell and good luck!");
            return;
        }
        System.out.println("\nWelcome to the Brain Games!");
        String username = Cli.greeting(scanner);
        switch (choice) {
            case 1:
                break;
            case 2:
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                Even.startGame(scanner, username);
                break;
            case 3:
                System.out.println("What is the result of the expression?");
                Calc.startGame(scanner, username);
                break;
            case 4:
                System.out.println("Find the greatest common divisor of given numbers.");
                Gcd.startGame(scanner, username);
            case 0:
                System.out.println("Farewell and good luck!");
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
        System.out.println("Congratulations, " + username + "!");
        scanner.close();
    }
}
