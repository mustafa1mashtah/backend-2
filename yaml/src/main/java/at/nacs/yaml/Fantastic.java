package at.nacs.yaml;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component


public class Fantastic {
    @Getter
    @Value("${configration.sentence}")
    private String sentence;
}
