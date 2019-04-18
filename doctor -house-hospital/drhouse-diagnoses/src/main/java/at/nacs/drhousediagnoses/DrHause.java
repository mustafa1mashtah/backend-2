package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Diagnosises;
import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrHause {
    private final Diagnosises diagnosises;

    public Patient getDiagnosis(Patient patient) {
        String symptoms = patient.getSymptoms();
        String diagnosis = diagnosises.getDiagnosises().getOrDefault(symptoms, "none");
        patient.setDiagnosis(diagnosis);
        return patient;
    }
}
