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
    TestRestTemplate restTemplate;

    String url = "/patients";

    @Test
    void addInfo() {
        Patient patient = new Patient();
        Patient patient1 = restTemplate.postForObject(url, patient, Patient.class);

        Assertions.assertThat(patient1.getId()).isNotEmpty();
    }
}