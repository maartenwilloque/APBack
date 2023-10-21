package fact.it.bandservice.repository;

import fact.it.bandservice.model.BandMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BandMemberRepository extends MongoRepository<BandMember, String> {
}
