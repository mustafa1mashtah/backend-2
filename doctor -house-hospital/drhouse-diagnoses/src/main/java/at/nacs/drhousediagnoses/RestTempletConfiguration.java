package at.nacs.drhousediagnoses;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempletConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
