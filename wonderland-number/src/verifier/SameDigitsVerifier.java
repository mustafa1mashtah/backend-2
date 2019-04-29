package verifier;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SameDigitsVerifier {

    public static boolean verify(int firstNumber, int secondNumber) {

        String firstNumberSorted = sortDigits(firstNumber);
        String secondNumberSorted = sortDigits(secondNumber);

        if (firstNumberSorted.equals(secondNumberSorted)) {
            return true;
        }
        return false;
    }

    private static String sortDigits(int number) {
        String[] split = Integer.valueOf(number).toString().split("");
        return Stream.of(split)
                .sorted()
                .collect(Collectors.joining());
    }
}
