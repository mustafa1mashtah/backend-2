package at.nacs.trickster;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TricksterEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    Trickster trickster;


    @Test
    void startGame() {
        String url = "/play";

        String actual = testRestTemplate.getForObject(url, String.class);
        String expected = "The game has started!";

        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    void sayResult() {
        String url = "/choose";
        Boolean actual = testRestTemplate.getForObject(url + "/1", Boolean.class);
        Assertions.assertThat(actual).isNotNull();
    }
}