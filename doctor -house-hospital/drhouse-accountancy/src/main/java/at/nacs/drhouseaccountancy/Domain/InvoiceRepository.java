package at.nacs.drhouseaccountancy.Domain;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
