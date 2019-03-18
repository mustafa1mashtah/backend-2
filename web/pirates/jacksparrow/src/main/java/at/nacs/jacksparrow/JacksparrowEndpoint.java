package at.nacs.jacksparrow;

import at.nacs.jacksparrow.domain.DeadMansChest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/deadmanschest")
@RequiredArgsConstructor
public class JacksparrowEndpoint {

    private final RestTemplate restTemplate;

    @Value("${tiadalma.url}")
    private String url;

    @GetMapping
    DeadMansChest get() {
        String dutchmanUrl = restTemplate.getForObject(url, String.class);
        return restTemplate.getForObject(dutchmanUrl, DeadMansChest.class);
    }
}
