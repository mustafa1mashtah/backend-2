package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncoderEndpoint {

    private final EncoderClient encoderClient;

    @PostMapping
    String get(@RequestBody String message) {

       return Arrays.asList(message.replaceAll(" ", "").split(""))
                .stream()
                .map(e -> encoderClient.getMessage(e))
                .collect(Collectors.joining());
    }
}
