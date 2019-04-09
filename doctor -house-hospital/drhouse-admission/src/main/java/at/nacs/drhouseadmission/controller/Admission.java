package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Admission {
    private final DiagnosesClient client;


    public Patient setId(Patient patient) {
        String id = UUID.randomUUID().toString();
        patient.setId(id);
        return patient;
    }

    public Patient post(Patient patient) {
        setId(patient);
        return client.sendToDiagnoses(patient);
    }

}
