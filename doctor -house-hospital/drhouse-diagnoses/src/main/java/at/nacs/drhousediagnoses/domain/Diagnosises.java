package at.nacs.drhousediagnoses.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("info")
public class Diagnosises {
    @Setter
    @Getter
    private Map<String, String> diagnosises;
}
