package at.nacs.twitterboard.logic;

import at.nacs.twitterboard.Tweet;
import at.nacs.twitterboard.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Twitter {
    private final TweetRepository tweetRepository;


    public List<Tweet> getAllOrderdByTimestamp() {
        return tweetRepository.findByOrderByTimestampDesc();
    }

    public List<Tweet> getAllForUserOrderdByTimestamp(String user) {
        return tweetRepository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet saveOne(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        return tweetRepository.save(tweet);
    }

    public Optional<Tweet> addOneLike(String id) {
        Optional<Tweet> tweet = tweetRepository.findById(id);
        if (tweet.isEmpty()) {
            return Optional.empty();
        }
        Tweet tweet1 = tweet.get();
        int likes = tweet1.getLikes();
        tweet1.setLikes(likes + 1);
        tweetRepository.save(tweet1);
        return Optional.of(tweet1);
    }

    public Optional<Tweet> addOneComment(String id, String comment) {
        Optional<Tweet> tweet = tweetRepository.findById(id);
        if (tweet.isEmpty()) {
            return Optional.empty();
        }
        Tweet tweet1 = tweet.get();
        List<String> comments = tweet1.getComments();
        comments.add(comment);
        tweetRepository.save(tweet1);
        return Optional.of(tweet1);
    }
}
