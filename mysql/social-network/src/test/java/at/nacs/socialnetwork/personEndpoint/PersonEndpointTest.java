package at.nacs.socialnetwork.personEndpoint;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistance.Person;
import at.nacs.socialnetwork.persistance.PersonRepository;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset")
class PersonEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Setter
    Person person1;

    @SpyBean
    PersonManager manager;

    @MockBean
    PersonRepository repository;

    private String url = "/persons";

    @Test
    void getAll() {
        restTemplate.getForObject(url, Person[].class);
        verify(manager).getAll();
    }

    @Test
    void getAllWithOneFriend() {
        restTemplate.getForObject(url + "/friends/with", Person[].class);
        verify(manager).getAllWithOneFriend();
    }

    @Test
    void getAllWithOutFriends() {
        restTemplate.getForObject(url + "/friends/without", Person[].class);
        verify(manager).getAllWithNoFriends();
    }

    @Test
    void saveOne() {
        restTemplate.postForObject(url, person1, Person.class);
        verify(manager).saveOne(any());
    }

    @Test
    void connectTwo() {
        String url1 = url + "/" + "2" + "/friend/" + "3";
        restTemplate.put(url1, void.class);
    }

    @Test
    void disconnectTwo() {
        String url1 = url + "/" + "2" + "/unfriend/" + "3";
        restTemplate.put(url1, void.class);
    }
}