package nacs.at.themorseencoderui.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.themorseencoderui.view.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class EncoderClient {
    private final RestTemplate restTemplate;

    @Value("${encode.url}")
    private String url;

    public String sendToEncoder(Message message) {
        return restTemplate.postForObject(url, message.getPlaintext(), String.class);
    }
}
