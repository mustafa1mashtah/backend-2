package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.Kind;
import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.Domain.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvoiceManger {
    private final AccountantCalculator calculator;

    public Invoice buildInvoice(PatientDTO patientDTO, Patient patient) {
        double cost = calculator.calculateCost(patientDTO);

        Invoice invoice1 = Invoice.builder()
                .patient(patient)
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .cost(cost)
                .timestamp(LocalDateTime.now())
                .paid(false)
                .build();

        setTreatmentOrMedicineAndKind(invoice1, patientDTO);
        return invoice1;
    }


     Invoice setTreatmentOrMedicineAndKind(Invoice invoice, PatientDTO patientDTO) {
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
