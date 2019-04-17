package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountant {
    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceManger invoiceManger;

    public PatientDTO invoice(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setUuid(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patientRepository.save(patient);
        Invoice invoice = invoiceManger.buildInvoice(patientDTO, patient);
        invoiceRepository.save(invoice);
        return patientDTO;
    }

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public void putPaid(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            Invoice invoice1 = invoice.get();
            invoice1.setPaid(true);
            invoiceRepository.save(invoice1);
        }
    }
}
