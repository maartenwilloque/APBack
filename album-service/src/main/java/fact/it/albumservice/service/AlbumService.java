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
            album1.setYear(1999);
            album1.setTitle("The Distance to Here");
            album1.setBandId("LIVE");
            albumRepository.save(album1);
            List<Song> songs1 = new ArrayList<>();
            Song song1 = new Song();
            songs1.add(song1);

            // Load songs into the list
            songs1.add(new Song(13L, "The Dolphin's Cry", 241, "spotify_id_1", album1));
            songs1.add(new Song(14L, "The Distance", 258, "spotify_id_2", album1));
            songs1.add(new Song(15L, "Sparkle", 212, "spotify_id_3", album1));
            songs1.add(new Song(16L, "Run to the Water", 244, "spotify_id_4", album1));
            songs1.add(new Song(17L, "Sun", 225, "spotify_id_5", album1));
            songs1.add(new Song(18L, "Voodoo Lady", 199, "spotify_id_6", album1));
            songs1.add(new Song(19L, "Where Fishes Go", 248, "spotify_id_7", album1));
            songs1.add(new Song(20L, "Face and Ghost (The Children's Song)", 268, "spotify_id_8", album1));
            songs1.add(new Song(21L, "Feel the Quiet River Rage", 211, "spotify_id_9", album1));
            songs1.add(new Song(22L, "Meltdown", 236, "spotify_id_10", album1));
            songs1.add(new Song(23L, "They Stood Up for Love", 277, "spotify_id_11", album1));
            songs1.add(new Song(24L, "We Walk in the Dream", 233, "spotify_id_12", album1));
            songs1.add(new Song(25L, "Dance with You", 278, "spotify_id_13", album1));
            songRepository.saveAll(songs1);


            Album album2 = new Album();
            album2.setAlbumId("3");
            album2.setYear(1986);
            album2.setTitle("Master of Puppets");
            album2.setBandId("METALLICA");
            albumRepository.save(album2);
            List<Song> songs2 = new ArrayList<>();
            Song song2 = new Song();
            songs2.add(song2);

            songs2.add(new Song(26L, "Battery", 312, "spotify-id-1", album2));
            songs2.add(new Song(27L, "Master of Puppets", 442, "spotify-id-2", album2));
            songs2.add(new Song(28L, "The Thing That Should Not Be", 398, "spotify-id-3", album2));
            songs2.add(new Song(29L, "Welcome Home (Sanitarium)", 387, "spotify-id-4", album2));
            songs2.add(new Song(30L, "Disposable Heroes", 496, "spotify-id-5", album2));
            songs2.add(new Song(31L, "Leper Messiah", 342, "spotify-id-6", album2));
            songs2.add(new Song(32L, "Orion", 496, "spotify-id-7", album2));
            songs2.add(new Song(33L, "Damage, Inc.", 332, "spotify-id-8", album2));


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
