package verifier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultingNumbersGenerator {
    private static final List<Integer> multiplicationNumbers = Arrays.asList(2, 3, 4, 5, 6);

    public static List<Integer> generate(int originalNumber) {
        return multiplicationNumbers.stream()
                .map(multiplicationNumber -> multiplicationNumber * originalNumber)
                .collect(Collectors.toList());
    }
}
