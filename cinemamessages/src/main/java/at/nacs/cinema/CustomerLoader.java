package at.nacs.cinema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@ConfigurationProperties("names")

public class CustomerLoader {

    @Getter
    @Setter
    private List<String>customers;

}
