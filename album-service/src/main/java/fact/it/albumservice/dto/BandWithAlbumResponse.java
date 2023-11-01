package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BandWithAlbumResponse {
    private String bandId;
    private String name;
    private String nationality;
    private List<BandMemberDto> members;
    private List<AlbumDto> albums;

}
