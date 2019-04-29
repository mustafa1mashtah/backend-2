package verifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ResultingNumbersGeneratorTest {

    @Test
    void testGenerate() {
        List<Integer> actual = ResultingNumbersGenerator.generate(2);
        List<Integer> expected = Arrays.asList(4, 6, 8, 10, 12);
        Assertions.assertEquals(actual, expected);
    }
}