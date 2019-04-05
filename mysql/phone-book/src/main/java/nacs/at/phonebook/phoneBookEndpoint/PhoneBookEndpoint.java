package nacs.at.phonebook.phoneBookEndpoint;

import lombok.RequiredArgsConstructor;
import nacs.at.phonebook.Persistance.Contact;
import nacs.at.phonebook.logic.ContactManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class PhoneBookEndpoint {
    private final ContactManager manager;

    @GetMapping
    List<Contact> getAll() {
        return manager.getAll();
    }

    @PostMapping
    Contact saveOne(@RequestBody Contact contact) {
        return manager.saveOne(contact);
    }

    @GetMapping("/address/{address}")
    List<Contact> getByAddress(@PathVariable String address) {
        return manager.getByAddress(address);
    }
}
