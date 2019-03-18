package at.nacs.yaml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class DaysOfWeekTest {

    @Autowired
    DaysOfWeek daysOfWeek;

    @Test
    void testSizeOfList() {
        int size = daysOfWeek.getDaysOfWeek().size();
        Assertions.assertEquals(6, size);
    }

    @ParameterizedTest
    @CsvSource({
            "0, Saturday",
            "1, Sunday",
            "2, Monday",
            "3, Tuesday",
            "4, Wednesday",
            "5, Thursday",


    })
    void getDaysOfWeek(int index, String day) {
        List<String> days = daysOfWeek.getDaysOfWeek();
        String actual = days.get(index);

        Assertions.assertEquals(day, actual);


    }
}