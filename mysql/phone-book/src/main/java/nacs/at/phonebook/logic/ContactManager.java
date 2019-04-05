package nacs.at.phonebook.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.phonebook.Persistance.Contact;
import nacs.at.phonebook.Persistance.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {
    private final ContactRepository repository;

    public List<Contact> getAll() {
        return repository.findAll();
    }

    public Contact saveOne(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getByAddress(String address) {
        address="%"+address+"%";
        return repository.findAllByAddress_NameLike(address);
    }
}
