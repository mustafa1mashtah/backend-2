package at.nacs.polo;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT )
class PoloEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;


    String url="/polo";

    @Test
    void addMarco() {
        String message1="Marco";
        String expected="Polo";

        String actual=testRestTemplate.postForObject(url,message1,String.class);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    @Test
    void addOther() {
        String message1="hi";
        String expected="What?";

        String actual=testRestTemplate.postForObject(url,message1,String.class);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}