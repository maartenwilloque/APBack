package fact.it.bandservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.util.List;

@Document(collection = "band")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Band {
    @Id
    private String id;
    private String bandID;
    private String name;
    private String nationality;
    private List<BandMember> bandMemberList;
}
