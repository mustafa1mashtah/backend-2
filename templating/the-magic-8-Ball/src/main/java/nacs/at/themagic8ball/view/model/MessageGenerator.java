package nacs.at.themagic8ball.view.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MessageGenerator {
    private final List<String> messages;
    private final Random random = new Random();

    public String getMessage() {
        return messages.get(random.nextInt(messages.size()));
    }
}
