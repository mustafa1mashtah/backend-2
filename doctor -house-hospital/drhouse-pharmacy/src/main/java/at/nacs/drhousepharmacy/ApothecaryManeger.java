package at.nacs.drhousepharmacy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApothecaryManeger {
    private final Apothecary apothecary;
    private final PharmacyRepository repository;
    //private final RestTemplate restTemplate;

    public Patient postOne(Patient patient) {
        Patient patientWithMedicine = apothecary.getMedicine(patient);
        repository.save(patientWithMedicine);
        System.out.println(patientWithMedicine);
        return patientWithMedicine;
    }
}
