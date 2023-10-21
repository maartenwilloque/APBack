package fact.it.albumservice.service;

import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.dto.SongDto;
import fact.it.albumservice.model.Album;
import fact.it.albumservice.model.Song;
import fact.it.albumservice.repository.AlbumRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AlbumService {

    @PostConstruct
    public void init(){
        Album album = new Album();
        album.setAlbumId("1");
        album.setYear(1991);
        album.setTitle("Nevermind");
        album.setBandId("Nirvana");

        albumRepository.save(album);
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1L,"Smells Like Teen Spirit", 299, "spotify-link-1",album));
        songs.add(new Song(2L,"In Bloom", 251, "spotify-link-2",album));
        album.setSongs(songs);
    }

    private final AlbumRepository albumRepository;
    private final WebClient webClient;

    @Value("${bandService.baseurl}")
    private String bandServiceBaseURL;

    @Value("${userService.baseurl}")
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

    public List<AlbumResponse> getAlbums() {
        List<Album> albums = albumRepository.findAll();



        return albums.stream().map(album -> new AlbumResponse(album.getAlbumId(),album.getTitle(),album.getYear(),album.getSongs())).collect(Collectors.toList());
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
