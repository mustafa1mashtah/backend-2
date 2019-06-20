package nacs.at.lectureexample.persistence.repository;

import nacs.at.lectureexample.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);

    boolean existsByUsername(String username);
}
