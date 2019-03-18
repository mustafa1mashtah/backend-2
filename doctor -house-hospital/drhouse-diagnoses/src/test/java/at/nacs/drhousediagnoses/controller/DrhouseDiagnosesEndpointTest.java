package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.DrHause;
import at.nacs.drhousediagnoses.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DrhouseDiagnosesEndpointTest {


    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    DrHause drHause;


    String url = "/patients";

    @ParameterizedTest
    @CsvSource({
            "runningnose,cold",
            "confusion,programming",
            "lost,none"

    })
    void test(String symptoms, String diagnosis) {
        Patient patient = new Patient();
        patient.setSymptoms(symptoms);

        String actual = testRestTemplate.postForObject(url, patient, Patient.class).getDiagnosis();

        Assertions.assertThat(actual).isEqualTo(diagnosis);
    }
}


