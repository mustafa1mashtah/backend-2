package at.nacs.reflection.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;



@SpringBootTest

class ConvertNumberTest {

    @Autowired
     ConvertNumber convertNumber;

    @Test
    void convert() {
        List<Integer> digits = convertNumber.convert(12);
        List<Integer> expected = Arrays.asList(1,2);
        Assertions.assertEquals(expected,digits);
    }
}