package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class DrhouseadmissionEndpointTest {

    @Autowired
     TestRestTemplate restTemplate;

    @MockBean
    DiagnosesClient diagnosesClient;

    @SpyBean
    Admission admission;

    private Patient patient = new Patient();


    String url = "/patients";

    @Test
    void post() {
        restTemplate.postForObject(url, patient, Patient.class);
        Mockito.verify(admission).post(Mockito.any());
    }
}