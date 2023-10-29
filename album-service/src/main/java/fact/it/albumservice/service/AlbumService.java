package fact.it.albumservice.service;

import fact.it.albumservice.dto.*;
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
    public void LoadData(){
        if(albumRepository.count()<= 0) {
            Album album = new Album();
            album.setAlbumId("1");
            album.setYear(1991);
            album.setTitle("Nevermind");
            album.setBandId("NIRVANA");
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


            Album album1 = new Album();
            album1.setAlbumId("2");
            album1.setYear(1989);
            album1.setTitle("Bleach");
            album1.setBandId("NIRVANA");
            albumRepository.save(album1);
            List<Song> songs1 = new ArrayList<>();
            Song song1 = new Song();
            songs1.add(song1);

            // Load songs into the list
            songs1.add(new Song(13L, "Blew", 166, "spotify-blew", album1));
            songs1.add(new Song(14L, "Floyd the Barber", 120, "spotify-floyd", album1));
            songs1.add(new Song(15L, "About a Girl", 166, "spotify-about-a-girl", album1));
            songs1.add(new Song(16L, "School", 138, "spotify-school", album1));
            songs1.add(new Song(17L, "Love Buzz", 178, "spotify-love-buzz", album1));
            songs1.add(new Song(18L, "Paper Cuts", 206, "spotify-paper-cuts", album1));
            songs1.add(new Song(19L, "Negative Creep", 134, "spotify-negative-creep", album1));
            songs1.add(new Song(20L, "Scoff", 136, "spotify-scoff", album1));
            songs1.add(new Song(21L, "Swap Meet", 143, "spotify-swap-meet", album1));
            songs1.add(new Song(22L, "Mr. Moustache", 130, "spotify-mr-moustache", album1));
            songs1.add(new Song(23L, "Sifting", 191, "spotify-sifting", album1));
            songRepository.saveAll(songs1);


            Album album2 = new Album();
            album2.setAlbumId("3");
            album2.setYear(1999);
            album2.setTitle("Enema of the State");
            album2.setBandId("BLINK182");
            albumRepository.save(album2);
            List<Song> songs2 = new ArrayList<>();
            Song song2 = new Song();
            songs2.add(song2);

            songs2.add(new Song(24L, "Dumpweed", 161, "spotify:track:xyz123", album2));
            songs2.add(new Song(25L, "Don't Leave Me", 144, "spotify:track:xyz124", album2));
            songs2.add(new Song(26L, "Aliens Exist", 182, "spotify:track:xyz125", album2));
            songs2.add(new Song(27L, "Going Away to College", 185, "spotify:track:xyz126", album2));
            songs2.add(new Song(28L, "What's My Age Again?", 149, "spotify:track:xyz127", album2));
            songs2.add(new Song(29L, "Dysentery Gary", 122, "spotify:track:xyz128", album2));
            songs2.add(new Song(30L, "Adam's Song", 243, "spotify:track:xyz129", album2));
            songs2.add(new Song(31L, "All the Small Things", 186, "spotify:track:xyz130", album2));
            songs2.add(new Song(32L, "The Party Song", 135, "spotify:track:xyz131", album2));
            songs2.add(new Song(33L, "Mutt", 123, "spotify:track:xyz132", album2));
            songs2.add(new Song(34L, "Wendy Clear", 144, "spotify:track:xyz133", album2));

            songRepository.saveAll(songs2);

        }
    }



    @Value("${bandService.baseurl}")
    private String bandServiceBaseURL;

    @Value("${userService.baseurl}")
    private String userServiceBaseUrl;

    public AlbumResponse getAlbum(long Id) {
        Album album = albumRepository.getReferenceById(Id);
        AlbumResponse albumResponse = new AlbumResponse();
        albumResponse.setAlbumId(album.getAlbumId());
        albumResponse.setBand(getBand(album.getBandId()));
        albumResponse.setYear(album.getYear());
        albumResponse.setTitle(album.getTitle());
        albumResponse.setSongs(mapToSongDto(album.getSongs()));
        albumResponse.setRating(getAverageRating(album.getAlbumId()).getScore());



        return albumResponse;
    }

    public List<AlbumResponse> getAlbums() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map(album -> new AlbumResponse(
                album.getAlbumId(),
                album.getTitle(), album.getYear(),getBand(album.getBandId()),
                mapToSongDto(album.getSongs()), getAverageRating(album.getAlbumId()).getScore())).
                toList();
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

    public  RatingResponse getAverageRating(String albumId){
        return webClient.get().uri("http://"+userServiceBaseUrl+"/api/rating/average/{Id}",albumId).retrieve().bodyToMono(RatingResponse.class).block();
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
    public BandResponse getBand(String Id){
        return webClient.get()
                .uri("http://"+bandServiceBaseURL+"/api/band/{Id}",Id)
                .retrieve()
                .bodyToMono(BandResponse.class)
                .block();
    }
}
