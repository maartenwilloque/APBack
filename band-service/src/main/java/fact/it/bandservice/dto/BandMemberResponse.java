package fact.it.bandservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandMemberResponse {
    private String firstName;
    private String lastName;
    private String nickName;
    private String instrument;
}
