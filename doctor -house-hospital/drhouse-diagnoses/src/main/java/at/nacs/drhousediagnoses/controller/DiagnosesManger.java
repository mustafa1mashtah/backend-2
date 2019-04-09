package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.DrHause;
import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosesManger {
    private final DrHause drHause;
    private final BedsClient bedsClient;
    private final PharmacyClient pharmacyClient;

    public Patient postOne(Patient patient) {
        Patient patientWithDiagnoses = drHause.getDiagnosis(patient);
        if (sentToBeds(patient)) {
            return bedsClient.sendToBeds(patientWithDiagnoses);
        }
        return pharmacyClient.sendToPharmacy(patientWithDiagnoses);
    }

    private boolean sentToBeds(Patient patient) {
        return patient.getDiagnosis().equalsIgnoreCase("none");
    }
}
