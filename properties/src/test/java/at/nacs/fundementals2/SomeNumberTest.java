package at.nacs.fundementals2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SomeNumberTest {
    @Autowired
    SomeNumber someNumber;

    @Test
    void getNumber() {
        int number = someNumber.getNumber();
        Assertions.assertEquals(369, number);
    }
}