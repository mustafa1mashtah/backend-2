package at.nacs.reflection.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class TransformerTest {

    @Autowired
    Transformer transformer;

    @ParameterizedTest
    @CsvSource({
            "195,thousand knucklestickles over palm",
            "392,little finger grabthousand knucklesthumb touches back",

    }

    )
    void transform(Integer price, String danceMoves) {
        List<String> actualDanceMoves = transformer.transform(price);
        String actualMoves = actualDanceMoves.stream().collect(Collectors.joining(""));
        Assertions.assertEquals(danceMoves, actualMoves);
    }

    @Test
    void testNoMoves(){
        List<String> moves = transformer.transform(111);
        Assertions.assertTrue(moves.isEmpty());
    }
}