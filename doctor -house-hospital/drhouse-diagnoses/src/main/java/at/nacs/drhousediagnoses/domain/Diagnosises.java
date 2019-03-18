package at.nacs.drhousediagnoses.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("info")
public class Diagnosises {
    @Setter
    @Getter
    private Map<String, String> diagnosises;
}
