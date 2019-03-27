package at.nacs.twitterboard;

import at.nacs.twitterboard.logic.Twitter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetEndpoint {
    private final Twitter twitter;

    @GetMapping
    List<Tweet> getAll() {
        return twitter.getAllOrderdByTimestamp();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getAllForUserOrderdByTimestamp(@PathVariable String user) {
        return twitter.getAllForUserOrderdByTimestamp(user);
    }

    @PostMapping
    Tweet post(@RequestBody Tweet tweet) {
        return twitter.saveOne(tweet);
    }

    @PutMapping("/{id}/likes")
    Tweet putOneLike(@PathVariable String id) {
        Optional<Tweet> OptionaTweet = twitter.addOneLike(id);
        if (OptionaTweet.isEmpty()) {
            return null;
        }
        return OptionaTweet.get();
    }

    @PutMapping("/{id}/comments")
    Tweet putOnecomment(@PathVariable String id, @RequestBody String comment) {
        Optional<Tweet> OptionaTweet = twitter.addOneComment(id, comment);
        if (OptionaTweet.isEmpty()) {
            return null;
        }
        return OptionaTweet.get();
    }
}
