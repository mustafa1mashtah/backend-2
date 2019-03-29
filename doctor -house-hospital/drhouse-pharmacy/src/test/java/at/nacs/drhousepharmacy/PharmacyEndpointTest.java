package at.nacs.drhousepharmacy;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("info1")
class PharmacyEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Setter
    @Getter
    Patient patient;

    @SpyBean
    ApothecaryManeger manger;

    @MockBean
    PharmacyRepository repository;

    private String url = "/patients";

    @Test
    void post() {
        testRestTemplate.postForObject(url, patient, Patient.class);
        Mockito.verify(manger).postOne(Mockito.any());

    }
}