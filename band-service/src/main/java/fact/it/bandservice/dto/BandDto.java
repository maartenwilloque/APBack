package fact.it.bandservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandDto {
    private String bandId;
    private String name;
    private String nationality;
}
