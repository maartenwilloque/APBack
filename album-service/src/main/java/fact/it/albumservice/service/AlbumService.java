package fact.it.albumservice.service;

import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.dto.BandResponse;
import fact.it.albumservice.dto.SongDto;
import fact.it.albumservice.model.Album;
import fact.it.albumservice.model.Song;
import fact.it.albumservice.repository.AlbumRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final WebClient webClient;

    @Value("${BAND_SERVICE_BASEURL: localhost:8080}")
    private String bandServiceBaseURL;

    @Value("${USER_SERVICE_BASEURL: localhost:8082}")
    private String userServiceBaseUrl;

    public AlbumResponse getAlbum(long Id){
        Album album = albumRepository.getReferenceById(Id);
        //List<SongDto> songDtoList = mapToSongDto(album.getSongs().stream().toList());
        //BandResponse band = webClient.get().uri("http://"+bandServiceBaseURL+"/api/band", uriBuilder -> uriBuilder.queryParam("bandId",album.getBandId()).build()).retrieve().bodyToMono(BandResponse.class).block();
        AlbumResponse albumResponse = new AlbumResponse();
        albumResponse.setAlbumId(album.getAlbumId());
        //albumResponse.setBand(band);
        albumResponse.setYear(album.getYear());
        albumResponse.setTitle(album.getTitle());
        albumResponse.setSongs(album.getSongs());


        return albumResponse;
    }


    private List<SongDto> mapToSongDto(List<Song> songs ){
        return songs.stream().map(song -> new SongDto(
                song.getId(),
                song.getTitle(),
                song.getDuration(),
                song.getSpotifyId()
        )).collect(Collectors.toList());
    }


}
