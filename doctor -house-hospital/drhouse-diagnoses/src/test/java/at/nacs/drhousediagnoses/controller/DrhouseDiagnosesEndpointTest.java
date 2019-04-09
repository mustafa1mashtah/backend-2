package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.domain.Patient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DrhouseDiagnosesEndpointTest {


    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    DiagnosesManger manger;

    @MockBean
    BedsClient bedsClient;

    @MockBean
    PharmacyClient pharmacyClient;


    String url = "/patients";

    @ParameterizedTest
    @CsvSource({
            "runningnose",
            "confusion",
            "lost"

    })
    void test(String symptoms) {
        Patient patient = new Patient();
        patient.setSymptoms(symptoms);

        testRestTemplate.postForObject(url, patient, Patient.class);
        Mockito.verify(manger).postOne(Mockito.any());
    }
}


