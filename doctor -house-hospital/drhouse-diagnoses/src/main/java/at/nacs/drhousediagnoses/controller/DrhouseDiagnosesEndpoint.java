package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.DrHause;
import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class DrhouseDiagnosesEndpoint {
    private final DrHause drHause;

    @PostMapping()
    Patient add(@RequestBody Patient patient) {
        System.out.println(drHause.getDiagnosis(patient));
        return drHause.getDiagnosis(patient);
    }
}
