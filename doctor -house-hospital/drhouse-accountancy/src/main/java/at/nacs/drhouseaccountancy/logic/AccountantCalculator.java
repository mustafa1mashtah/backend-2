package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountantCalculator {
    private final Map<String, Double> costs;

    public double calculateCost(PatientDTO patientDTO) {
        String treatment = patientDTO.getTreatment();
        if (!Objects.equals(treatment, null)) {
            return costs.get(treatment);
        }
        String medicine = patientDTO.getMedicine();
        return costs.get(medicine);
    }
}
