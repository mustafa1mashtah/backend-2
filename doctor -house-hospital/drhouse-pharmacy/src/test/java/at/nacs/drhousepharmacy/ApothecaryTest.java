package at.nacs.drhousepharmacy;

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
class ApothecaryTest {
    @Autowired
    PharmacyRepository repository;

    @Autowired
    Apothecary apothecary;

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
    void getMedicine() {
        Patient actual = apothecary.getMedicine(patient);
        String expected = "killyourself";
        Assertions.assertThat(actual.getMedicine()).isEqualTo(expected);
    }
}