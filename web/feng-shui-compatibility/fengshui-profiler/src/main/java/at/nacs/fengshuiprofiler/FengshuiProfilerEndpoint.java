package at.nacs.fengshuiprofiler;

import at.nacs.fengshuiprofiler.Domain.Match;
import at.nacs.fengshuiprofiler.Domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FengshuiProfilerEndpoint {
    private final FengshuiClient fengshuiClient;


    @GetMapping("/profile/{birthday}")
    Profile getProfile(@PathVariable LocalDate birthday) {
        return fengshuiClient.getProfile(birthday);
    }

    @GetMapping("/match/{birthday1}/{birthday2}")
    Match getMatch(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return fengshuiClient.setMatch(birthday1, birthday2);
    }
}
