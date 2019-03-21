package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TricksterEndpoint {
    private final Trickster trickster;

    @GetMapping("/play")
    String startGame(){
        trickster.play();
        return "The game has started!";
    }

    @GetMapping("/choose/{number}")
    Boolean sayResult(@PathVariable int number){
        return trickster.choose(number);
    }
}
