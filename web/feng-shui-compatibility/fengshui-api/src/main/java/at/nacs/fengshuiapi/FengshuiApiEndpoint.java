package at.nacs.fengshuiapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FengshuiApiEndpoint {
    private final FengshuiClient fengshuiClient;

    @GetMapping("/sign/{birthday}")
    Sign get(@PathVariable LocalDate birthday) {
        return fengshuiClient.getSign(birthday);
    }

    @GetMapping("/compatibility/sign/{birthday1}/{birthday2}")
    Sign getSignCompatibility(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return fengshuiClient.getSignCompatibility(birthday1, birthday2);
    }

    @GetMapping("/compatibility/love/{birthday1}/{birthday2}")
    Sign getLoveCompatibility(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return fengshuiClient.getLoveCompatibility(birthday1, birthday2);
    }

}
