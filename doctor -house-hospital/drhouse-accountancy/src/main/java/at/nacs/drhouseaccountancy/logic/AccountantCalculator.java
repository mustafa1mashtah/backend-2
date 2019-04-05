package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountantCalculator {
    private final AccountancyConfiguration accountancyConfiguration;

    public double calculateCost(PatientDTO patientDTO) {
        String treatment = patientDTO.getTreatment();
        if (!Objects.equals(treatment, null)) {
            return accountancyConfiguration.getCosts().get(treatment);
        }
        String medicine = patientDTO.getMedicine();
        return accountancyConfiguration.getCosts().get(medicine);
    }
}
