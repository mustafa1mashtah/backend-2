package at.nacs.drhousepharmacy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApothecaryManeger {
    private final Apothecary apothecary;
    private final PharmacyRepository repository;
    private final RestTemplate restTemplate;

    @Value("${ccountancy.url}")
    private String url;

    public Patient postOne(Patient patient) {
        Patient patientWithMedicine = apothecary.getMedicine(patient);
        repository.save(patientWithMedicine);
        return restTemplate.postForObject(url, patientWithMedicine, Patient.class);
    }
}
