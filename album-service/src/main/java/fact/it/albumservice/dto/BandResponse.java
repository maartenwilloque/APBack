package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BandResponse {
    private String id;
    private String bandID;
    private String name;
    private String nationality;
    private List<BandMemberDto> bandMembers;
}
