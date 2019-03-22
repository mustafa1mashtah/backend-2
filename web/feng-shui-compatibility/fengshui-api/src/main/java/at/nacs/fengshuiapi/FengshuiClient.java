package at.nacs.fengshuiapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

@RestController
@Service
@RequiredArgsConstructor
public class FengshuiClient {
    private final RestTemplate restTemplate;
    private final SignTranslator signTranslator;

    public Sign getSign(LocalDate birthday) {
        int year = birthday.getYear();
        int month = birthday.getMonthValue();
        int day = birthday.getDayOfMonth();

        String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=B538ayCmaAM3AeG2e104dN4b7520e0EB81Z63498&year="
                + year + "&month=" + month + "&day=" + day;
        return restTemplate.getForObject(url, Sign.class);

    }

    public Sign getSignCompatibility(LocalDate birthday1, LocalDate birthday2) {
        Map<String, String> signMap = signTranslator.getSignMap();
        String sign1 = signMap.get(getSign(birthday1).getResult());
        String sign2 = signMap.get(getSign(birthday2).getResult());

        String url = "https://fengshui-api.com/api/v1/findSignCompatibility?token=B538ayCmaAM3AeG2e104dN4b7520e0EB81Z63498&sign=" + sign1
                + "&sign2=" + sign2;
        return restTemplate.getForObject(url, Sign.class);
    }

    public Sign getLoveCompatibility(LocalDate birthday1, LocalDate birthday2) {
        int year = birthday1.getYear();
        int month = birthday1.getMonthValue();
        int day = birthday1.getDayOfMonth();
        int year2 = birthday2.getYear();
        int month2 = birthday2.getMonthValue();
        int day2 = birthday2.getDayOfMonth();

        String url = "https://fengshui-api.com/api/v1/findLoveCompatibility?token=B538ayCmaAM3AeG2e104dN4b7520e0EB81Z63498&year="
                + year + "&month=" + month + "&day=" + day + "&year2=" + year2 + "&month2=" + month2 + "&day2=" + day2;
        return restTemplate.getForObject(url, Sign.class);
    }
}
