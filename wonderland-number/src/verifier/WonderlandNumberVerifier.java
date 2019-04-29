package verifier;

import java.util.List;

public class WonderlandNumberVerifier {
    public static boolean verify(int originalNumber) {
        List<Integer> resultingNumbers = ResultingNumbersGenerator.generate(originalNumber);

        return resultingNumbers.stream()
                .allMatch(resultingNumber -> SameDigitsVerifier.verify(originalNumber, resultingNumber));
    }
}
