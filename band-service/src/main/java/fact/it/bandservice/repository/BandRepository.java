package fact.it.bandservice.repository;

import fact.it.bandservice.model.Band;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BandRepository extends MongoRepository<Band, String> {
}
