package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BandMemberDto {
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String instrument;
}
