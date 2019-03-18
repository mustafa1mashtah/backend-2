package at.nacs.morse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MorseServerTest {


    @Autowired
    MorseServer morseServer;

    @Test
    void encodedLetter() {
        String actual = morseServer.encodedLetter("a");
        String expected=".-";
        Assertions.assertEquals(actual,expected);

    }
}