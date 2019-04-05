package at.nacs.drhouseaccountancy.Domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient>findByUuid(String id);
}
