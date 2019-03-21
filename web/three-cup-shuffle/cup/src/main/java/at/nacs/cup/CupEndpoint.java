package at.nacs.cup;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CupEndpoint {
    private final Cup cup;

    @GetMapping
    Boolean hasCoin() {
        return cup.isCoin();
    }

    @PutMapping
    void placeCoin(){
        cup.setCoin(true);
    }

    @DeleteMapping
    void removeCoin(){
        cup.setCoin(false);
    }


}
