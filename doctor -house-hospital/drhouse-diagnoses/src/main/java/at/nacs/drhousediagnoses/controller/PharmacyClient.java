package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class PharmacyClient {
    private final RestTemplate restTemplate;

    @Value("${pharmacys.pharmacyUrl}")
    private String pharmacyUrl;

    public Patient sendToPharmacy(Patient patient) {
        return restTemplate.postForObject(pharmacyUrl, patient, Patient.class);
    }

}
