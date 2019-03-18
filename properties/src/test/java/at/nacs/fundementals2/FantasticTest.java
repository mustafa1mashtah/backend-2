package at.nacs.fundementals2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FantasticTest {

    @Autowired
    Fantastic fantastic;

    @Test
    void getSentence() {
        String sentence = fantastic.getSentence();
        Assert.assertEquals("fantastic", sentence);
    }
}