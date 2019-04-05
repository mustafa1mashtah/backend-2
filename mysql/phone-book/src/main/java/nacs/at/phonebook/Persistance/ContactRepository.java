package nacs.at.phonebook.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByAddress_NameLike(String name);
}
