package at.nacs.fengshuiapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("symbol")
@Data
@RequiredArgsConstructor
public class SignTranslator {

    private final Map<String, String> signMap;
}
