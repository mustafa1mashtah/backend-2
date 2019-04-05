package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistance.Person;
import at.nacs.socialnetwork.persistance.PersonRepository;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;


@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class PersonManagerTest {
    @Autowired
    PersonRepository repository;

    @Autowired
    PersonManager manager;

    @Setter
    Person person1;

    @Setter
    Person person2;

    @Setter
    Person person3;

    @BeforeEach
    void before() {
        repository.deleteAll();
        repository.save(person1);
        repository.save(person2);
    }

    @Test
    void getAll() {
        List<Person> actual = manager.getAll();
        Assertions.assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void getAllWithNoFriends() {
        List<Person> actual = manager.getAllWithNoFriends();
        Assertions.assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void getAllWithOneFriend() {
        manager.saveOne(person3);
        List<Person> friendsFor3 = manager.getAll().get(2).getFriends();
        friendsFor3.add(person2);
        person3.setFriends(friendsFor3);
        manager.saveOne(person3);
        List<Person> actual = manager.getAllWithOneFriend();
        Assertions.assertThat(actual.size()).isEqualTo(1);
    }


    @Test
    void saveOne() {
        Person actual = manager.saveOne(person3);
        Assertions.assertThat(actual.getId()).isNotNull();
    }

    @Test
    void connectTwo() {
        Long id1 = manager.getAll().get(0).getId();
        Long id2 = manager.getAll().get(1).getId();

        manager.connectTwo(id1, id2);
        int numberOfPerson1Friends = manager.getAll().get(0).getFriends().size();
        int numberOfPerson2Friends = manager.getAll().get(1).getFriends().size();

        Assertions.assertThat(numberOfPerson1Friends).isEqualTo(1);
        Assertions.assertThat(numberOfPerson2Friends).isEqualTo(1);
    }

    @Test
    void disconnectTwo() {
        Long id1 = manager.getAll().get(0).getId();
        Long id2 = manager.getAll().get(1).getId();

        manager.disconnectTwo(id1, id2);
        int numberOfPerson1Friends = manager.getAll().get(0).getFriends().size();
        int numberOfPerson2Friends = manager.getAll().get(1).getFriends().size();

        Assertions.assertThat(numberOfPerson1Friends).isEqualTo(0);
        Assertions.assertThat(numberOfPerson2Friends).isEqualTo(0);
    }
}