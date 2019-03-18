package at.nacs.yaml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaunaTest {

    @Autowired
    Sauna sauna;

    @Test
    void saunaTest() {
        Assertions.assertEquals(5, sauna.getAvailableSeats());
        Assertions.assertEquals(14.00, sauna.getTemperature());

    }


}