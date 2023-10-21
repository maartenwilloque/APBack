package fact.it.albumservice.service;

import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.dto.SongDto;
import fact.it.albumservice.model.Album;
import fact.it.albumservice.model.Song;
import fact.it.albumservice.repository.AlbumRepository;
import fact.it.albumservice.repository.SongRepository;
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

    /*@PostConstruct
    public void init(){
        Album album = new Album();
        List<SongDto> songDtoList = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        songDtoList.add(new SongDto("Smells Like Teen Spirit", 299, "spotify_id_1"));
        songDtoList.add(new SongDto("In Bloom", 251, "spotify_id_2"));
        songDtoList.add(new SongDto("Come as You Are", 219, "spotify_id_3"));
        songDtoList.add(new SongDto("Breed", 183, "spotify_id_4"));
        songDtoList.add(new SongDto("Lithium", 262, "spotify_id_5"));
        songDtoList.add(new SongDto("Polly", 168, "spotify_id_6"));
        songDtoList.add(new SongDto("Territorial Pissings", 142, "spotify_id_7"));
        songDtoList.add(new SongDto("Drain You", 224, "spotify_id_8"));
        songDtoList.add(new SongDto("Lounge Act", 156, "spotify_id_9"));
        songDtoList.add(new SongDto("Stay Away", 186, "spotify_id_10"));
        songDtoList.add(new SongDto("On a Plain", 193, "spotify_id_11"));
        songDtoList.add(new SongDto("Something in the Way", 224, "spotify_id_12"));
        songDtoList.forEach(songDto ->  songs.add(saveSong(songDto)));
        album.setAlbumId("1");
        album.setYear(1991);
        album.setTitle("Nevermind");
        album.setBandId("Nirvana");
        album.setSongs(songs);
        albumRepository.save(album);
    }*/

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
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
                song.getTitle(),
                song.getDuration(),
                song.getSpotifyId()
        )).collect(Collectors.toList());
    }

    private Song saveSong(SongDto songDto){
        Song song = new Song();
        song.setDuration(songDto.getDuration());
        song.setTitle(songDto.getTitle());
        song.setSpotifyId(songDto.getSpotifyId());
        songRepository.save(song);
        return song;
    }


}
