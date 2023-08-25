package hexlet.code;

public class Random {

    public static int generateNumber(int multiplier) {
        return (int) Math.round((Math.random() + 0.1) * multiplier);
    }

    public static char generateSign(int multiplier) {
        int i = generateNumber(multiplier);
        if (i < multiplier / 3) {
            return '+';
        } else if  (i < multiplier / 3 * 2) {
            return  '-';
        } else {
            return '*';
        }
    }
}
