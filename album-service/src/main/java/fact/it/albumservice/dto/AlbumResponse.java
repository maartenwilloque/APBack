package fact.it.albumservice.dto;

import fact.it.albumservice.model.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponse {
    private String albumId;
    private String title;
    private int Year;
    //private BandResponse band;
    private List<Song> songs;

}
