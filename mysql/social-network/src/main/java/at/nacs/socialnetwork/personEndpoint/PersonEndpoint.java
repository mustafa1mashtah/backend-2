package at.nacs.socialnetwork.personEndpoint;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistance.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonEndpoint {
    private final PersonManager manager;

    @GetMapping
    List<Person> getAll() {
        return manager.getAll();
    }

    @GetMapping("/friends/with")
    List<Person> getAllWithOneFriend() {
        return manager.getAllWithOneFriend();
    }

    @GetMapping("/friends/without")
    List<Person> getAllWithOutFriends() {
        return manager.getAllWithNoFriends();
    }

    @PostMapping
    Person saveOne(@RequestBody Person person) {
        return manager.saveOne(person);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void connectTwo(@PathVariable Long id1, @PathVariable Long id2) {
        manager.connectTwo(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void disconnectTwo(@PathVariable Long id1, @PathVariable Long id2) {
        manager.disconnectTwo(id1, id2);
    }
}
