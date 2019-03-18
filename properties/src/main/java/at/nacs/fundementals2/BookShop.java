package at.nacs.fundementals2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("store")
public class BookShop {

    @Setter
    @Getter
    private Map<String, Integer> books;

}
