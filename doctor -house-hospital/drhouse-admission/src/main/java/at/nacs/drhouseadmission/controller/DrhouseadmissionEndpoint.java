package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class DrhouseadmissionEndpoint {
    private final AdmissionClient client;


    @PostMapping
    Patient addInfo(@RequestBody Patient patient) {
        return client.setId(patient);
    }
}
