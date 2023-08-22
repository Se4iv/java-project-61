package hexlet.code;

public class Random {

    public static int generateNumber() {
        return (int) Math.round(Math.random() * 100);
    }

    public static char generateSign() {
        int i = generateNumber();
        if (i < 33) {
            return '+';
        } else if  (i < 66) {
            return  '-';
        } else {
            return '*';
        }
    }
}
