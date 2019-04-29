package verifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class SameDigitsVerifierTest {

    @ParameterizedTest
    @CsvSource({
            "123,1234,false",
            "123,12,false",
            "123,124,false",
            "112345,123345,false",
            "123,231,true",
            "142857,285714,true"
    })
    void testSameDigits(int firstNumber, int secondNumber, boolean expected) {
        boolean actual = SameDigitsVerifier.verify(firstNumber, secondNumber);

        Assertions.assertEquals(actual, expected);
    }
}