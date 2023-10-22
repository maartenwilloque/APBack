package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
