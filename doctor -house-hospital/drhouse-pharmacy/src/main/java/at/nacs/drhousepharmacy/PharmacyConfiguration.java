package at.nacs.drhousepharmacy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@ConfigurationProperties("info")
public class PharmacyConfiguration {
    @Setter
    @Getter
    private Map<String, String> medicine;
}
