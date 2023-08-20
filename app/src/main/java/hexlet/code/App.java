package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit\n"
                + "Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("\nWelcome to the Brain Games!");
        switch (choice) {
            case 1:
                Cli.greeting(scanner);
                break;
            case 2:
                Even.game(scanner);
                break;
            case 0:
                System.out.println("Farewell and good luck!");
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
        scanner.close();
    }
}
