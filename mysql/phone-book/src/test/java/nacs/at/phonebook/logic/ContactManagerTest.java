package nacs.at.phonebook.logic;

import lombok.Getter;
import lombok.Setter;
import nacs.at.phonebook.Persistance.Contact;
import nacs.at.phonebook.Persistance.ContactRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class ContactManagerTest {
    @Autowired
    ContactRepository repository;

    @Autowired
    ContactManager manager;

    @Setter
    @Getter
    Contact contact1;

    @Setter
    @Getter
    Contact contact2;


    @BeforeEach
    void before() {
        repository.save(contact1);
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }

    @Test
    void getAll() {
        repository.save(contact2);
        List<Contact> contacts = repository.findAll();
        int size = contacts.size();
        Assertions.assertThat(size).isEqualTo(2);
    }

    @Test
    void saveOne() {
        Assertions.assertThat(contact1.getId()).isNotNull();
    }

    @Test
    void getByAdress() {
        String address = "fake";
        manager.saveOne(contact2);
        List<Contact> actual = manager.getByAddress(address);
        Assertions.assertThat(actual.size()).isEqualTo(2);

    }
}