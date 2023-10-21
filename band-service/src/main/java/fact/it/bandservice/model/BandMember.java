package fact.it.bandservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "bandMember")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BandMember {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String instrument;
}
