package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongResponse {
    private String title;
    private int duration;
    private String spotifyId;
    private AlbumDto album;

}
