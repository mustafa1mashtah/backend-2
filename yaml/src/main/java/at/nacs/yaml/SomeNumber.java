package at.nacs.yaml;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class SomeNumber {
    @Getter
    @Value("${find.number}")
    private int number;
}
