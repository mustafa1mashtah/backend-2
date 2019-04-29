package mathematics_solution;

public class CyclicNumberGenerator {
    private static final int NUMBER_OF_DIGITS = 6;
    private static final int MAXIMUM_RANG_NUMBER = (int) Math.pow(10, NUMBER_OF_DIGITS);

    public static Integer generate() {
        double rationalNumber = (1.00 / (NUMBER_OF_DIGITS + 1)) * MAXIMUM_RANG_NUMBER;
        return (int) rationalNumber;
    }
}
