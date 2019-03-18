package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class DrhouseadmissionEndpoint {
    private final RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    private String url;


    @PostMapping
    Patient addInfo(@RequestBody Patient patient) {
        String id = UUID.randomUUID().toString();
        patient.setId(id);
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
