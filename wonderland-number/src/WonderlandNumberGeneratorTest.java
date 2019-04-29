import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WonderlandNumberGeneratorTest {

    @Test
    void testGenerate() {
        WonderlandNumberGenerator wonderlandNumberGenerator = new WonderlandNumberGenerator();
        int actual = wonderlandNumberGenerator.GenerateWonderlandNumber();
        int expected = 142857;

        Assertions.assertEquals(actual, expected);
    }
}