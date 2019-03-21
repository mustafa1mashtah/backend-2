package at.nacs.cup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
public class Cup {
    @Getter
    @Setter
    private boolean coin;
}
