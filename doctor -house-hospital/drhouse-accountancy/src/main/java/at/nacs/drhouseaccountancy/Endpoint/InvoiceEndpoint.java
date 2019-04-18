package at.nacs.drhouseaccountancy.Endpoint;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceEndpoint {
    private final Accountant accountant;

    @GetMapping
    List<Invoice> getAll() {
        return accountant.getAll();
    }

    @PutMapping("/{id}/paid")
    void setPaid(@PathVariable Long id) {
        accountant.putPaid(id);
    }
}
