package at.nacs.reflection.configuration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;


@SpringBootTest
class MovesConfigurationTest {

    @Autowired
    MovesConfiguration movesConfiguration;

    @ParameterizedTest
    @CsvSource({
            "2,thumb touches back" ,
            "3,little finger grab" ,
            "5, tickles over palm" ,
            "6, bro knock" ,
            "9, thousand knuckles,med",
    }
    )
    void testMoves(Integer digit,String dance) {
        Map<Integer, String> moves = movesConfiguration.moves();
        Assertions.assertEquals(dance,moves.get(digit));
    }
}