package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.DrHause;
import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DiagnosesManger {
    private final DrHause drHause;
    private final RestTemplate restTemplate;
    //private final Directions directions;

    @Value("${beds.bedsUrl}")
    private String bedsUrl;

    @Value("${pharmacys.pharmacyUrl}")
    private String pharmacyUrl;

    public Patient postOne(Patient patient) {
        Patient patientWithDiagnoses = drHause.getDiagnosis(patient);
        if (sentToBeds(patient)) {
            return restTemplate.postForObject(bedsUrl, patientWithDiagnoses, Patient.class);
        }
        return restTemplate.postForObject(pharmacyUrl, patientWithDiagnoses, Patient.class);
    }

    private boolean sentToBeds(Patient patient) {
        return patient.getDiagnosis().equalsIgnoreCase("none");
    }
}
