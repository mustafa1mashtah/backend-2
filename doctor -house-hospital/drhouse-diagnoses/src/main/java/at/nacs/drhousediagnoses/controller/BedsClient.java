package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class BedsClient {
    private final RestTemplate restTemplate;

    @Value("${beds.bedsUrl}")
    private String bedsUrl;

    public Patient sendToBeds(Patient patient) {
        return restTemplate.postForObject(bedsUrl, patient, Patient.class);
    }
}
