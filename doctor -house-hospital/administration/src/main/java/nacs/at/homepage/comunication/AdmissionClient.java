package nacs.at.homepage.comunication;

import lombok.RequiredArgsConstructor;
import nacs.at.homepage.view.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AdmissionClient {
    private final RestTemplate restTemplate;

    @Value("${admission.url}")
    private String url;

    public Patient sent(Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
