import verifier.WonderlandNumberVerifier;

import java.util.stream.IntStream;

public class WonderlandNumberGenerator {
    private final int NUMBER_OF_DIGITS = 6;
    private final int MINIMUM_RANG_NUMBER = (int) Math.pow(10, NUMBER_OF_DIGITS - 1);
    private final int MAXIMUM_RANG_NUMBER = (int) Math.pow(10, NUMBER_OF_DIGITS);

    public int GenerateWonderlandNumber() {
        return IntStream.range(MINIMUM_RANG_NUMBER, MAXIMUM_RANG_NUMBER)
                .boxed()
                .filter(WonderlandNumberVerifier::verify)
                .findFirst().orElseThrow();
    }
}
