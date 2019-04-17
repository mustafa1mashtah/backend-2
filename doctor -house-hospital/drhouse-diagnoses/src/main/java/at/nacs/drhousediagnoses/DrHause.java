package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DrHause {
    private final Map<String, String> diagnosises;

    public Patient getDiagnosis(Patient patient) {
        String symptoms = patient.getSymptoms();
        String diagnosis = diagnosises.getOrDefault(symptoms, "none");
        patient.setDiagnosis(diagnosis);
        return patient;
    }
}
