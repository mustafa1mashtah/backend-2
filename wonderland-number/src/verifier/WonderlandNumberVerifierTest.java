package verifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WonderlandNumberVerifierTest {

    @ParameterizedTest
    @CsvSource({
            "1,false",
            "22,false",
            "123,false",
            "142857,true"
    })
    void testWonderlandNumber(int number, boolean expected) {
        boolean actual = WonderlandNumberVerifier.verify(number);

        Assertions.assertEquals(actual, expected);
    }
}