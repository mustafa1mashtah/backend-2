package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DiagnosesClient {
    private final RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    private String url;

    public Patient sendToDiagnoses(Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
