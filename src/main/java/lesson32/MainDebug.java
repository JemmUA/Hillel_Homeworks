package lesson32;

public class MainDebug {
    public static void main(String[] args) {
        final int ZERO = 0;
        final int ONE = 1;
        final int TWO = 2;
        int result;

        result = getResult(ZERO, ONE, TWO); // ctrl+m

        System.out.println(String.format("Result: %d", result));
    }

    private static int getResult(int ZERO, int ONE, int TWO) {
        int result;
        result = ONE + TWO / (ZERO + 1);
        return result;
    }
}
