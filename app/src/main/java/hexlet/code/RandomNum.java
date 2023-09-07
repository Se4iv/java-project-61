package hexlet.code;

public class RandomNum {
    public static int generateNumber(int multiplier) {
        int result = (int) Math.round((Math.random()) * multiplier);
        return result == 0 ? 1 : result; //генерация без 0
    }


}
