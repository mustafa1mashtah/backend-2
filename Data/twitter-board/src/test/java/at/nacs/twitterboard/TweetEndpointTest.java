package at.nacs.twitterboard;

import at.nacs.twitterboard.logic.Twitter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset")
class TweetEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Setter
    Tweet tweet;

    @SpyBean
    Twitter twitter;

    @MockBean
    TweetRepository tweetRepository;

    private String url="/tweets";

    @Test
    void getAllOrderdByTimestamp() {
        testRestTemplate.getForObject(url,Tweet[].class);
        verify(twitter).getAllOrderdByTimestamp();
    }

    @Test
    void getAllForUserOrderdByTimestamp() {
        testRestTemplate.getForObject(url+"/user/moustafa",Tweet[].class);

        verify(twitter).getAllForUserOrderdByTimestamp(anyString());
    }

    @Test
    void post() {
        testRestTemplate.postForObject(url,tweet,Tweet.class);

        verify(twitter).saveOne(any());

    }

    @Test
    void putOneLike() {
        testRestTemplate.put(url+"/moustafa/likes",Tweet.class);

        verify(twitter).addOneLike(anyString());
    }

    @Test
    void putOnecomment() {
        testRestTemplate.put(url+"/moustafa/comments","hi",Tweet.class);

        verify(twitter).addOneComment(anyString(),anyString());
    }
}