package at.nacs.yaml;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("dance")

public class Ballerinas {

    @Getter
    @Setter
    private List<Ballerina> ballerinas;
}
