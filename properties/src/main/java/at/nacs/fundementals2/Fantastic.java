package at.nacs.fundementals2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component


public class Fantastic {
    @Getter
    @Value("${configration.sentence}")
    private String sentence;
}
