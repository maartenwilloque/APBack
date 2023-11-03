package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private String albumId;
    private String title;
    private int Year;
}
