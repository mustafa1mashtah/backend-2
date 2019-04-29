package mathematics_solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicNumberGeneratorTest {

    @Test
    void testGenerate() {
        int actual = CyclicNumberGenerator.generate();
        System.out.println(actual);
        int expected = 142857;

        Assertions.assertEquals(actual, expected);
    }
}