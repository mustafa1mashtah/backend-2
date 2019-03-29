package at.nacs.drhousebeds;

import at.nacs.drhousebeds.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Nurse {
    private final BedsConfiguration beds;

    public Patient getTreatment(Patient patient){
        String diagnosis = patient.getDiagnosis();
        String treatment = beds.getTreatments().getOrDefault(diagnosis, "no hope");
        patient.setTreatment(treatment);
        return patient;
    }
}
