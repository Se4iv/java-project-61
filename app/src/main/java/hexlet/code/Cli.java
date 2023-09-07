package hexlet.code;

import java.util.Scanner;
public class Cli {

    public static String greeting() {
        System.out.print("May I have your name? ");
        String username = new Scanner(System.in).next();
        System.out.println("Hello, " + username + "!");
        return username;
    }
}
