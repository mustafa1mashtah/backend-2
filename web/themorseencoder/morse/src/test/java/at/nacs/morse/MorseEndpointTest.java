package at.nacs.morse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MorseEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/morse";

    @ParameterizedTest
    @CsvSource({
            "B,-...",
            "C,-.-.",
            "9,----.",
            "/,NOT SUPPORTED"
    })
    void encode(String letter,String expected) {
        String actual = testRestTemplate.postForObject(url, letter, String.class);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}