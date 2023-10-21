package fact.it.bandservice.repository;

import fact.it.bandservice.model.Band;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BandRepository extends MongoRepository<Band, String> {
}
