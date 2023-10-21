package fact.it.bandservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandResponse {
    private String bandId;
    private String name;
    private String nationality;
    private List<BandMemberDto> members;
}
