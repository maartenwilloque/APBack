package fact.it.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingWithAlbum {
    private int score;
    private String name;
    private AlbumDto album;
}
