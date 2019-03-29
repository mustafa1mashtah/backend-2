package at.nacs.drhousepharmacy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Apothecary {
    private final PharmacyConfiguration pharmacy;

    public Patient getMedicine(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        String treatment = pharmacy.getMedicine().getOrDefault(diagnosis, "no hope");
        patient.setMedicine(treatment);
        return patient;
    }
}
