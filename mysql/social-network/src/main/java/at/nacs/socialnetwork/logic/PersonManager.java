package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistance.Person;
import at.nacs.socialnetwork.persistance.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonManager {
    private final PersonRepository repository;

    public List<Person> getAll() {
        return repository.findAll();
    }

    public List<Person> getAllWithOneFriend() {
        return repository.findAllByFriendsIsNotNull();
    }

    public List<Person> getAllWithNoFriends() {
        return repository.findAllByFriends_Empty();
    }

    public Person saveOne(Person person) {
        return repository.save(person);
    }

    public void connectTwo(Long id1, Long id2) {
        connectOne(id1, id2);
        connectOne(id2, id1);
    }

    public void disconnectTwo(Long id1, Long id2) {
        disconnectOne(id1, id2);
        disconnectOne(id2, id1);
    }

    private void connectOne(Long id1, Long id2) {
        Optional<Person> optionalPerson1 = repository.findById(id1);
        Optional<Person> optionalPerson2 = repository.findById(id2);
        optionalPerson1.get().getFriends().add(optionalPerson2.get());
        repository.save(optionalPerson1.get());
    }

    private void disconnectOne(Long id1, Long id2) {
        Optional<Person> optionalPerson1 = repository.findById(id1);
        Optional<Person> optionalPerson2 = repository.findById(id2);
        optionalPerson1.get().getFriends().remove(optionalPerson2.get());
        repository.save(optionalPerson1.get());
    }
}
