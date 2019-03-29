package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class DrhouseadmissionEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private Patient patient = new Patient();


    String url = "/patients";

    @Test
    void addInfo() {

        System.out.println(patient);
        Patient patient1 = restTemplate.postForObject(url, patient, Patient.class);
        System.out.println(patient1);

        Assertions.assertThat(patient1.getId()).isNotBlank();
    }
}