package at.basketball.basketball;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketballConfiguration {
    @Bean
    ApplicationRunner basketball(Screen screen) {
        return args -> {
            screen.display();

        };

    }
}
