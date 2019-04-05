package at.nacs.socialnetwork.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByFriendsIsNotNull();

    List<Person> findAllByFriends_Empty();

    Optional<Person> findById(Long id);
}
