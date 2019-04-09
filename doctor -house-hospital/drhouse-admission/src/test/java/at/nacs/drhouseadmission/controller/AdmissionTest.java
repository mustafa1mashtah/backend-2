package at.nacs.drhouseadmission.controller;

import at.nacs.drhouseadmission.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {
    @Autowired
    Admission admission;

    @MockBean
    DiagnosesClient diagnosesClient;


    @Test
    void post() {
        Patient patient = new Patient();

        Patient actual = admission.setId(patient);

        Assertions.assertThat(actual.getId()).isNotBlank();
    }
}