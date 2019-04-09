package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.controller.BedsClient;
import at.nacs.drhousediagnoses.controller.PharmacyClient;
import at.nacs.drhousediagnoses.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DrHauseTest {

    @Autowired
    DrHause drHause;

    @MockBean
    BedsClient bedsClient;

    @MockBean
    PharmacyClient pharmacyClient;

    @ParameterizedTest
    @CsvSource({
            "runningnose,cold",
            "confusion,programming",
            "lost,none"

    })
    void testGetDiagnosis(String symptoms, String diagnosis) {
        Patient patient = new Patient();
        patient.setSymptoms(symptoms);

        String actual = drHause.getDiagnosis(patient).getDiagnosis();

        Assertions.assertThat(actual).isEqualTo(diagnosis);
    }
}