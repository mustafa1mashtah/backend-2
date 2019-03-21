package at.nacs.cup;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class CupEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    Cup cup;

    String url = "/coin";

    @Test
    void hasCoin() {
        Boolean actual = testRestTemplate.getForObject(url, Boolean.class);
        Assertions.assertThat(actual).isEqualTo(false);

    }

    @Test
    void placeCoin() {
        testRestTemplate.put(url, Cup.class);
        Boolean actual = testRestTemplate.getForObject(url, Boolean.class);
        Assertions.assertThat(actual).isEqualTo(true);


    }

    @Test
    void removeCoin() {
        testRestTemplate.delete(url);
        Boolean actual = testRestTemplate.getForObject(url, Boolean.class);
        Assertions.assertThat(actual).isEqualTo(false);

    }
}