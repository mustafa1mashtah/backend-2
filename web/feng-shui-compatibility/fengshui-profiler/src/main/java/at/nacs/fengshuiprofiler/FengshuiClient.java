package at.nacs.fengshuiprofiler;

import at.nacs.fengshuiprofiler.Domain.Match;
import at.nacs.fengshuiprofiler.Domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@Service
@RequiredArgsConstructor
public class FengshuiClient {
    private final RestTemplate restTemplate;
    private final Profile profile;
    private final Match match;

    public Profile getProfile(LocalDate birthday) {
        String url = "http://localhost:9005/sign/" + birthday.toString();
        String sign = restTemplate.getForObject(url, String.class);
        profile.setSign(sign);
        profile.setBirthday(birthday);
        return profile;
    }

    private Match setLoveAndSignCompatibility(LocalDate birthday1, LocalDate birthday2) {
        String url1 = "http://localhost:9005/compatibility/sign/" + birthday1.toString() + "/" + birthday2.toString();
        String signCompatibility = restTemplate.getForObject(url1, String.class);
        String url2 = "http://localhost:9005/compatibility/love/" + birthday1.toString() + "/" + birthday2.toString();
        String loveCompatibility = restTemplate.getForObject(url2, String.class);
        match.setSignCompatibility(signCompatibility);
        match.setLoveCompatibility(loveCompatibility);
        return match;
    }

    public Match setMatch(LocalDate birthday1, LocalDate birthday2) {
        Profile profile1 = getProfile(birthday1);
        Profile profile2 = getProfile(birthday2);
        match.setProfile1(profile1);
        match.setProfile2(profile2);
        setLoveAndSignCompatibility(birthday1, birthday2);
        return match;
    }
}
