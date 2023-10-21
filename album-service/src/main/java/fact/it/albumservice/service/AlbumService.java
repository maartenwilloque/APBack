package fact.it.albumservice.service;

import fact.it.albumservice.dto.AlbumDto;
import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.dto.SongDto;
import fact.it.albumservice.dto.SongResponse;
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
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final WebClient webClient;

    @PostConstruct
    public void init() {
        Album album = new Album();
        album.setAlbumId("1");
        album.setYear(1991);
        album.setTitle("Nevermind");
        album.setBandId("Nirvana");
        albumRepository.save(album);
        List<Song> songs = new ArrayList<>();
        Song song = new Song();
        songs.add(song);

        // Load songs into the list
        songs.add(new Song(1L, "Smells Like Teen Spirit", 299, "spotify-link-1", album));
        songs.add(new Song(2L, "In Bloom", 251, "spotify-link-2", album));
        songs.add(new Song(3L, "Come as You Are", 219, "spotify-link-3", album));
        songs.add(new Song(4L, "Breed", 183, "spotify-link-4", album));
        songs.add(new Song(5L, "Lithium", 262, "spotify-link-5", album));
        songs.add(new Song(6L, "Polly", 168, "spotify-link-6", album));
        songs.add(new Song(7L, "Territorial Pissings", 142, "spotify-link-7", album));
        songs.add(new Song(8L, "Drain You", 224, "spotify-link-8", album));
        songs.add(new Song(9L, "Lounge Act", 156, "spotify-link-9", album));
        songs.add(new Song(10L, "Stay Away", 186, "spotify-link-10", album));
        songs.add(new Song(11L, "On a Plain", 193, "spotify-link-11", album));
        songs.add(new Song(12L, "Something in the Way", 224, "spotify-link-12", album));
        songRepository.saveAll(songs);


    }


    @Value("${bandService.baseurl}")
    private String bandServiceBaseURL;

    @Value("${userService.baseurl}")
    private String userServiceBaseUrl;

    public AlbumResponse getAlbum(long Id) {
        Album album = albumRepository.getReferenceById(Id);
        //List<SongDto> songDtoList = mapToSongDto(album.getSongs().stream().toList());
        //BandResponse band = webClient.get().uri("http://"+bandServiceBaseURL+"/api/band", uriBuilder -> uriBuilder.queryParam("bandId",album.getBandId()).build()).retrieve().bodyToMono(BandResponse.class).block();
        AlbumResponse albumResponse = new AlbumResponse();
        albumResponse.setAlbumId(album.getAlbumId());
        //albumResponse.setBand(band);
        albumResponse.setYear(album.getYear());
        albumResponse.setTitle(album.getTitle());
        albumResponse.setSongs(mapToSongDto(album.getSongs()));


        return albumResponse;
    }

    public List<AlbumResponse> getAlbums() {
        List<Album> albums = albumRepository.findAll();


        return albums.stream().map(album -> new AlbumResponse(album.getAlbumId(), album.getTitle(), album.getYear(), mapToSongDto(album.getSongs()))).toList();
    }

    public List<SongResponse> getSongs() {
        List<Song> songs = songRepository.findAll();
        return mapToSongResponse(songs);
    }

    public SongResponse getSong(Long Id){
        Song song = songRepository.getReferenceById(Id);
        SongResponse songResponse = new SongResponse();
        songResponse.setTitle(song.getTitle());
        songResponse.setDuration(song.getDuration());
        songResponse.setSpotifyId(song.getSpotifyId());
        songResponse.setAlbum(mapToAlbumDto(song.getAlbum()));
        return songResponse;
    }


    private List<SongDto> mapToSongDto(List<Song> songs) {
        return songs.stream().map(song -> new SongDto(
                song.getTitle(),
                song.getDuration(),
                song.getSpotifyId()
        )).collect(Collectors.toList());
    }
    private List<SongResponse> mapToSongResponse(List<Song> songs) {
        return songs.stream().map(song -> new SongResponse(
                song.getTitle(),
                song.getDuration(),
                song.getSpotifyId(),
                mapToAlbumDto(song.getAlbum())
        )).collect(Collectors.toList());
    }
    private AlbumDto mapToAlbumDto(Album album){
        AlbumDto albumDto = new AlbumDto();
        albumDto.setYear(album.getYear());
        albumDto.setTitle(album.getTitle());
        albumDto.setAlbumId(album.getAlbumId());
        return albumDto;
    }

}
