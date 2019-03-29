package at.nacs.drhousebeds;

import at.nacs.drhousebeds.domain.Patient;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("info1")
class NurseTest {
    @Autowired
    BedsRepository repository;

    @Autowired
    Nurse nurse;

    @Setter
    Patient patient;

    @BeforeEach
    void before() {
        repository.save(patient);
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }


    @Test
    void getTreatment() {
        Patient actual = nurse.getTreatment(this.patient);
        String expected = "staytendayinbed";
        Assertions.assertThat(actual.getTreatment()).isEqualTo(expected);
    }
}