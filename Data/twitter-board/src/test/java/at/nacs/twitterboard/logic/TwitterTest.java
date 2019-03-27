package at.nacs.twitterboard.logic;

import at.nacs.twitterboard.Tweet;
import at.nacs.twitterboard.TweetRepository;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class TwitterTest {
    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    Twitter twitter;

    @Setter
    Tweet tweet;

    @BeforeEach
    void before() {
        tweetRepository.save(tweet);
    }

    @AfterEach
    void after() {
        tweetRepository.deleteAll();
    }

    @Test
    void getAllOrderdByTimestamp() {
        List<Tweet> tweets = twitter.getAllOrderdByTimestamp();
        Tweet actualTweet = tweets.get(0);
        Assertions.assertThat(actualTweet).isEqualTo(tweet);
    }

    @Test
    void getAllForUserOrderdByTimestamp() {
        List<Tweet> tweets = twitter.getAllForUserOrderdByTimestamp("mustafa");
        Tweet actualTweet = tweets.get(0);

        Assertions.assertThat(actualTweet).isEqualTo(tweet);
    }

    @Test
    void saveOne() {
        Tweet actualTweet = twitter.saveOne(tweet);

        Assertions.assertThat(actualTweet.getId()).isNotEmpty();

        Assertions.assertThat(actualTweet).isEqualTo(tweet);
    }

    @Test
    void addOneLike() {
        String id = tweet.getId();
        Optional<Tweet> tweet1 = twitter.addOneLike(id);
        Tweet actualTweet = tweet1.get();
        int actualLikes = actualTweet.getLikes();

        Assertions.assertThat(actualLikes).isEqualTo(1);
    }

    @Test
    void addOneComment() {
        String id = tweet.getId();
        Optional<Tweet> tweet1 = twitter.addOneComment(id, "hi");
        Tweet actualTweet = tweet1.get();
        String comment = actualTweet.getComments().get(0);

        Assertions.assertThat(comment).isEqualTo("hi");
    }
}