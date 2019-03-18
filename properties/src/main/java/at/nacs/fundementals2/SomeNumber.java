package at.nacs.fundementals2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class SomeNumber {
    @Getter
    @Value("${configration.number}")
    private int number;
}
