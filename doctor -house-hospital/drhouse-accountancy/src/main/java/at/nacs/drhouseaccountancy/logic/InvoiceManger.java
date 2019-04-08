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

    public Invoice buildInvoice(PatientDTO patientDTO, Patient patient) {
        Invoice invoice = new Invoice();
        double cost = calculator.calculateCost(patientDTO);

        invoice.builder()
                .patient(patient)
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .cost(cost)
                .timestamp(LocalDateTime.now())
                .paid(false).build();

        setTreatmentOrMedicineAndKind(invoice, patientDTO);
        return invoice;
    }


    private Invoice setTreatmentOrMedicineAndKind(Invoice invoice, PatientDTO patientDTO) {
        String treatment = patientDTO.getTreatment();
        if (!Objects.equals(treatment, null)) {
            return invoice.builder()
                    .provided(treatment)
                    .kind(Kind.TREATMENT)
                    .build();
        }
        String medicine = patientDTO.getMedicine();
        return invoice.builder()
                .provided(medicine)
                .kind(Kind.MEDICINE)
                .build();
    }
}
