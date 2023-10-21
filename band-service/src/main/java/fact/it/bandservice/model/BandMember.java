package fact.it.bandservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BandMember {
    private String firstName;
    private String lastName;
    private String nickName;
    private String instrument;
}
