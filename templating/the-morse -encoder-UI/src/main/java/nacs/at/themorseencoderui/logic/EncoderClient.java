package nacs.at.themorseencoderui.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.themorseencoderui.view.model.Message;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class EncoderClient {
    private final RestTemplate restTemplate;

    public String sendToEncoder(Message message) {
        return restTemplate.postForObject("http://localhost:9000/encode", message.getPlaintext(), String.class);
    }
}
