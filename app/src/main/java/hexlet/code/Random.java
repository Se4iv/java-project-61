package hexlet.code;

public class Random {

    public static int generateNumber(int multiplier) {
        int result = (int) Math.round((Math.random()) * multiplier);
        return result == 0 ? 1 : result; //генерация без 0
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
