package at.nacs.drhousebeds;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@ConfigurationProperties("info")
public class BedsConfiguration {

    @Setter
    @Getter
    private Map<String, String> treatments;
}
