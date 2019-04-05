package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.Kind;
import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvoiceManger {
    private final AccountantCalculator calculator;

    public Invoice buidInvoice(PatientDTO patientDTO, Patient patient) {
        Invoice invoice = new Invoice();
        invoice.setPatient(patient);
        invoice.setSymptoms(patientDTO.getSymptoms());
        invoice.setDiagnosis(patientDTO.getDiagnosis());
        double cost = calculator.calculateCost(patientDTO);
        invoice.setCost(cost);
        invoice.setTimestamp(LocalDateTime.now());
        invoice.setPaid(false);
        setTreatmentOrMedicineAndKind(invoice, patientDTO);
        return invoice;
    }


    private Invoice setTreatmentOrMedicineAndKind(Invoice invoice, PatientDTO patientDTO) {
        String treatment = patientDTO.getTreatment();
        if (!Objects.equals(treatment, null)) {
            invoice.setProvided(treatment);
            invoice.setKind(Kind.TREATMENT);
            return invoice;
        }
        String medicine = patientDTO.getMedicine();
        invoice.setProvided(medicine);
        invoice.setKind(Kind.MEDICINE);
        return invoice;
    }
}
