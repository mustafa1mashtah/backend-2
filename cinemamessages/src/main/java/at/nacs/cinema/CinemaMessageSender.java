package at.nacs.cinema;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaMessageSender {
    @Bean
    ApplicationRunner send(TextMessageSender textMessageSender) {
        return args -> {
            textMessageSender.getMessages().stream()
                    .forEach(System.out::println);

        };

    }
}
