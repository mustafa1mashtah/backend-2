package at.nacs.drhouseaccountancy.Endpoint;

import at.nacs.drhouseaccountancy.Domain.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class AccountancyEndpoint {
    private final Accountant accountant;

    @PostMapping
    PatientDTO postOne(@RequestBody PatientDTO patientDTO) {
        return accountant.invoice(patientDTO);
    }
}
