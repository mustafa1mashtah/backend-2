package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdmissionClient {
    private final RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    private String url;

    public Patient setId(Patient patient) {
        String id = UUID.randomUUID().toString();
        patient.setId(id);
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
