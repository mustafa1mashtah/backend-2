package at.nacs.drhousebeds;

import at.nacs.drhousebeds.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BedsManger {
    private final Nurse nurse;
    private final RestTemplate restTemplate;
    private final BedsRepository repository;

    @Value("${ccountancy.url}")
    private String url;

    public Patient postOne(Patient patient) {
        Patient patientWithTreatment = nurse.getTreatment(patient);
        repository.save(patientWithTreatment);
        return restTemplate.postForObject(url, patientWithTreatment, Patient.class);
    }
}
