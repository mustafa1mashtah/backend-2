package at.nacs.polo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
@RequiredArgsConstructor
public class PoloEndpoint {
    private final PoloServer poloServer;


    @PostMapping
    String add(@RequestBody String message) {
        return poloServer.getResponse(message);
    }
}
