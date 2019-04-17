package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class EncoderClient {

    private final RestTemplate restTemplate;

    @Value("${morse.url}")
    private String url;

    public String getMessage(String letter) {
        return restTemplate.postForObject(url, letter, String.class);
    }
}
