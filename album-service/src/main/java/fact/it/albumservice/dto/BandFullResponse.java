package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandFullResponse {
    private String id;
    private String bandID;
    private String name;
    private String nationality;
    private List<BandMemberDto> bandMembers;
}
