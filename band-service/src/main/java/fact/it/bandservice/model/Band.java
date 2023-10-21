package fact.it.bandservice.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "band")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Band {
    @Id
    private String id;
    private String bandID;
    private String name;
    private String nationality;
    @DBRef
    private List<BandMember> bandMembers;
}
