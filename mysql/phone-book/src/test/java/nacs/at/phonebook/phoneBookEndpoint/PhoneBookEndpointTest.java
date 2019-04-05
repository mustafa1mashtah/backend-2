package nacs.at.phonebook.phoneBookEndpoint;

import lombok.Setter;
import nacs.at.phonebook.Persistance.Contact;
import nacs.at.phonebook.Persistance.ContactRepository;
import nacs.at.phonebook.logic.ContactManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset")
class PhoneBookEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Setter
    Contact contact1;

    @Setter
    Contact contact2;

    @MockBean
    ContactRepository repository;

    @SpyBean
    ContactManager manager;

    private String url = "/contacts";

    @Test
    void getAll() {
        restTemplate.getForObject(url, Contact[].class);
        verify(manager).getAll();

    }

    @Test
    void saveOne() {
        restTemplate.postForObject(url, contact1, Contact.class);
        verify(manager).saveOne(any());
    }

    @Test
    void getByAddress() {
        String address = "fake";
        restTemplate.getForObject(url + "/address/" + address, Contact[].class);
        verify(manager).getByAddress(anyString());
    }
}