package at.nacs.fundementals2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BallerinasTest {


    @Autowired
    Ballerinas ballerinas;

    @Test
    void getBallerinas() {
        int size = ballerinas.getBallerinas().size();
        Assertions.assertEquals(3, size);
    }

    @ParameterizedTest
    @CsvSource({
            "0,med",
            "1,nana",
            "2,meme",
    }

    )
    void getBooks(int position, String name) {
        List<Ballerina> actual = ballerinas.getBallerinas();
        Assertions.assertEquals(name, actual.get(position).getName());

    }
}