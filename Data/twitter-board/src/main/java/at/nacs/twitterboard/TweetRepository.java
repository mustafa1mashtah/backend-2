package at.nacs.twitterboard;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    List<Tweet> findByOrderByTimestampDesc();

    List<Tweet> findByUserOrderByTimestampDesc(String user);

    Tweet save(Tweet tweet);

    Optional<Tweet> findById(String id);

    void deleteAll();
}
