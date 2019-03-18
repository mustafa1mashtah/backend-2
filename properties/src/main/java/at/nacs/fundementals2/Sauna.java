package at.nacs.fundementals2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("sauna")
@Setter
@Getter

public class Sauna {


    private int availableSeats;
    private double temperature;
}
