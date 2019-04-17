package at.nacs.drhouseaccountancy.logic;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("info")
public class AccountancyConfiguration {
    @Setter
    private Map<String, Double> costs;

    @Bean
    Map<String, Double> costs() {
        return costs;
    }
}
