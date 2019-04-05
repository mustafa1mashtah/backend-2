package at.nacs.drhouseaccountancy.Endpoint;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountancyEndpoint {
    private final Accountant accountant;

    @PostMapping("/patients")
    PatientDTO postOne(@RequestBody PatientDTO patientDTO) {
        return accountant.postOne(patientDTO);
    }

    @GetMapping("/invoices")
    List<Invoice> getAll() {
        return accountant.getAll();
    }

    @PutMapping("/invoices/{id}/paid")
    void setPaid(@PathVariable Long id) {
        accountant.putPaid(id);
    }
}
