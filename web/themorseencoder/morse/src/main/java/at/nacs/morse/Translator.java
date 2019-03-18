package at.nacs.morse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("code")
public class Translator {
    @Setter
    @Getter
    private Map<String, String> morseCode;
}
