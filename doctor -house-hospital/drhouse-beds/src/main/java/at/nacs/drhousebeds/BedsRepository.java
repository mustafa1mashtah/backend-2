package at.nacs.drhousebeds;

import at.nacs.drhousebeds.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedsRepository extends MongoRepository<Patient, String> {
}
