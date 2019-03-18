package at.nacs.fundementals2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class BookShopTest {

    @Autowired
    BookShop bookShop;

    @ParameterizedTest
    @CsvSource({
            "HarryPotter,3",
            "TheFoundation,2",
            "LordOfTheRings,4",
    }

    )
    void getBooks(String bookName, Integer copies) {
        Map<String, Integer> booksWithNumber = bookShop.getBooks();
        Assertions.assertEquals(copies, booksWithNumber.get(bookName));

    }

    @Test
    void containsTest(){
        Map<String, Integer> booksWithNumber = bookShop.getBooks();
        Assertions.assertFalse(booksWithNumber.containsKey("marhaba"));
    }

}