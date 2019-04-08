package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.InvoiceRepository;
import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.Domain.PatientRepository;
import at.nacs.drhouseaccountancy.PatientDTO;
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

    public PatientDTO postOne(PatientDTO patientDTO) {
        Patient patient = setUUID(patientDTO);
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

    private Patient setUUID(PatientDTO patientDTO) {
        String id = patientDTO.getId();
        Optional<Patient> optionalPatient = patientRepository.findByUuid(id);
        if (optionalPatient.isEmpty()) {
            Patient patient = new Patient();
            patient.setUuid(id);
            return patient;
        } else {
            Patient patient = optionalPatient.get();
            patient.setUuid(id);
            return patient;
        }


    }
}
