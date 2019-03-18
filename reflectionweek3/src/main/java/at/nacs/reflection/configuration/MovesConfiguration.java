package at.nacs.reflection.configuration;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("game")
public class MovesConfiguration {

    @Setter
    private Map<Integer, String> moves;

    @Bean
    Map<Integer, String> moves() {
        return moves;
    }
}
