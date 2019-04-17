package nacs.at.themagic8ball.view.model;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
@ConfigurationProperties("info")
public class MessageConfiguration {
    @Setter
    private List<String> messages;

    @Bean
    List<String> messages() {
        return messages;
    }
}
