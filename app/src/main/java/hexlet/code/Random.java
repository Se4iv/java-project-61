package hexlet.code;

public class Random {
    private static final int LESSTHEN = 3; //для определения знака
    private static final int MORETHEN = 2; //для определения знака

    public static int generateNumber(int multiplier) {
        int result = (int) Math.round((Math.random()) * multiplier);
        return result == 0 ? 1 : result; //генерация без 0
    }

    public static char generateSign(int multiplier) {
        int i = generateNumber(multiplier);
        if (i < multiplier / LESSTHEN) {
            return '+';
        } else if  (i < multiplier / LESSTHEN * MORETHEN) {
            return  '-';
        } else {
            return '*';
        }
    }
}
