package at.nacs.drhousebeds;

import at.nacs.drhousebeds.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class BedsEndpoint {
    private final BedsManger bedsManger;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return bedsManger.postOne(patient);
    }
}
