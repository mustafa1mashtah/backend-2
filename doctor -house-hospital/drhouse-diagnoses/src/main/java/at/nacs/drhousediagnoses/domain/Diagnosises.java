package at.nacs.drhousediagnoses.domain;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("info")
public class Diagnosises {
    @Setter
    private Map<String, String> diagnosises;

    @Bean
    public Map<String, String> diagnosises() {
        return diagnosises;
    }
}
