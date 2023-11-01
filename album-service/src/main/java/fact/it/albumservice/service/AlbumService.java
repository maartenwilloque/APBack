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
import java.util.stream.Stream;

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

            Album album3 = new Album();
            album3.setAlbumId("4");
            album3.setYear(1991);
            album3.setTitle("Metallica");
            album3.setBandId("METALLICA");

            albumRepository.save(album3);

            List<Song> songs3 = new ArrayList<>();

            songs3.add(new Song(34L, "Enter Sandman", 331, "spotify-id-1", album3));
            songs3.add(new Song(35L, "Sad But True", 334, "spotify-id-2", album3));
            songs3.add(new Song(36L, "The Unforgiven", 387, "spotify-id-3", album3));
            songs3.add(new Song(37L, "Wherever I May Roam", 404, "spotify-id-4", album3));
            songs3.add(new Song(38L, "Nothing Else Matters", 388, "spotify-id-5", album3));
            songs3.add(new Song(39L, "Of Wolf and Man", 250, "spotify-id-6", album3));
            songs3.add(new Song(40L, "The God That Failed", 305, "spotify-id-7", album3));
            songs3.add(new Song(41L, "My Friend of Misery", 427, "spotify-id-8", album3));

            songRepository.saveAll(songs3);

            Album album4 = new Album();
            album4.setAlbumId("5");
            album4.setYear(1999); // Set the release year of the "There Is Nothing Left to Lose" album
            album4.setTitle("There Is Nothing Left to Lose"); // Set the album title
            album4.setBandId("FOOFIGHTERS"); // Set the band ID

            albumRepository.save(album4);

            List<Song> songs4 = new ArrayList<>();

            songs4.add(new Song(42L, "Stacked Actors", 254, "spotify-id-9", album4));
            songs4.add(new Song(43L, "Breakout", 203, "spotify-id-10", album4));
            songs4.add(new Song(44L, "Learn to Fly", 230, "spotify-id-11", album4));
            songs4.add(new Song(45L, "Gimme Stitches", 193, "spotify-id-12", album4));
            songs4.add(new Song(46L, "Generator", 194, "spotify-id-13", album4));
            songs4.add(new Song(47L, "Aurora", 313, "spotify-id-14", album4));
            songs4.add(new Song(48L, "Live-In Skin", 228, "spotify-id-15", album4));
            songs4.add(new Song(49L, "Next Year", 242, "spotify-id-16", album4));
            songs4.add(new Song(50L, "Headwires", 250, "spotify-id-17", album4));
            songs4.add(new Song(51L, "Ain't It the Life", 268, "spotify-id-18", album4));
            songs4.add(new Song(52L, "M.I.A.", 259, "spotify-id-19", album4));

            songRepository.saveAll(songs4);

            Album album5 = new Album();
            album5.setAlbumId("6");
            album5.setYear(2002);
            album5.setTitle("One by One");
            album5.setBandId("FOOFIGHTERS");

            albumRepository.save(album5);

            List<Song> songs5 = new ArrayList<>();

            songs5.add(new Song(53L, "All My Life", 263, "spotify-id-20", album5));
            songs5.add(new Song(54L, "Low", 290, "spotify-id-21", album5));
            songs5.add(new Song(55L, "Have It All", 284, "spotify-id-22", album5));
            songs5.add(new Song(56L, "Times Like These", 264, "spotify-id-23", album5));
            songs5.add(new Song(57L, "Disenchanted Lullaby", 283, "spotify-id-24", album5));
            songs5.add(new Song(58L, "Tired of You", 318, "spotify-id-25", album5));
            songs5.add(new Song(59L, "Halo", 238, "spotify-id-26", album5));
            songs5.add(new Song(60L, "Lonely as You", 291, "spotify-id-27", album5));
            songs5.add(new Song(61L, "Overdrive", 394, "spotify-id-28", album5));
            songs5.add(new Song(62L, "Burn Away", 273, "spotify-id-29", album5));
            songs5.add(new Song(63L, "Come Back", 347, "spotify-id-30", album5));

            songRepository.saveAll(songs5);

            Album album6 = new Album();
            album6.setAlbumId("7");
            album6.setYear(2005);
            album6.setTitle("In Your Honor");
            album6.setBandId("FOOFIGHTERS");

            albumRepository.save(album6);

            List<Song> songs6 = new ArrayList<>();

            songs6.add(new Song(56L, "In Your Honor", 245, "spotify-id-31", album6));
            songs6.add(new Song(57L, "No Way Back", 198, "spotify-id-32", album6));
            songs6.add(new Song(58L, "Best of You", 267, "spotify-id-33", album6));
            songs6.add(new Song(59L, "DOA", 231, "spotify-id-34", album6));
            songs6.add(new Song(60L, "Hell", 222, "spotify-id-35", album6));
            songs6.add(new Song(61L, "The Last Song", 226, "spotify-id-36", album6));
            songs6.add(new Song(62L, "Free Me", 255, "spotify-id-37", album6));
            songs6.add(new Song(63L, "Resolve", 324, "spotify-id-38", album6));
            songs6.add(new Song(64L, "The Deepest Blues Are Black", 234, "spotify-id-39", album6));
            songs6.add(new Song(65L, "End Over End", 303, "spotify-id-40", album6));

            songRepository.saveAll(songs6);

            Album album7 = new Album();
            album7.setAlbumId("8");
            album7.setYear(1999);
            album7.setTitle("Californication");
            album7.setBandId("REDHOTCHILIPEPPERS");

            albumRepository.save(album7);

            List<Song> songs7 = new ArrayList<>();

            songs7.add(new Song(66L, "Around the World", 238, "spotify-id-41", album7));
            songs7.add(new Song(67L, "Parallel Universe", 259, "spotify-id-42", album7));
            songs7.add(new Song(68L, "Scar Tissue", 205, "spotify-id-43", album7));
            songs7.add(new Song(69L, "Otherside", 253, "spotify-id-44", album7));
            songs7.add(new Song(70L, "Get on Top", 218, "spotify-id-45", album7));
            songs7.add(new Song(71L, "Californication", 326, "spotify-id-46", album7));
            songs7.add(new Song(72L, "Easily", 204, "spotify-id-47", album7));
            songs7.add(new Song(73L, "Porcelain", 167, "spotify-id-48", album7));
            songs7.add(new Song(74L, "Emit Remmus", 247, "spotify-id-49", album7));
            songs7.add(new Song(75L, "I Like Dirt", 140, "spotify-id-50", album7));
            songs7.add(new Song(76L, "This Velvet Glove", 216, "spotify-id-51", album7));
            songs7.add(new Song(77L, "Savior", 227, "spotify-id-52", album7));
            songs7.add(new Song(78L, "Purple Stain", 239, "spotify-id-53", album7));
            songs7.add(new Song(79L, "Right on Time", 167, "spotify-id-54", album7));
            songs7.add(new Song(80L, "Road Trippin'", 222, "spotify-id-55", album7));

            songRepository.saveAll(songs7);

            Album album8 = new Album();
            album8.setAlbumId("9");
            album8.setYear(2002);
            album8.setTitle("By the Way");
            album8.setBandId("REDHOTCHILIPEPPERS");

            albumRepository.save(album8);

            List<Song> songs8 = new ArrayList<>();

            songs8.add(new Song(81L, "By the Way", 216, "spotify-id-56", album8));
            songs8.add(new Song(82L, "Universally Speaking", 249, "spotify-id-57", album8));
            songs8.add(new Song(83L, "This Is the Place", 242, "spotify-id-58", album8));
            songs8.add(new Song(84L, "Dosed", 177, "spotify-id-59", album8));
            songs8.add(new Song(85L, "Don't Forget Me", 297, "spotify-id-60", album8));
            songs8.add(new Song(86L, "The Zephyr Song", 229, "spotify-id-61", album8));
            songs8.add(new Song(87L, "Can't Stop", 255, "spotify-id-62", album8));
            songs8.add(new Song(88L, "I Could Die for You", 143, "spotify-id-63", album8));
            songs8.add(new Song(89L, "Midnight", 271, "spotify-id-64", album8));
            songs8.add(new Song(90L, "Throw Away Your Television", 185, "spotify-id-65", album8));
            songs8.add(new Song(91L, "Cabron", 214, "spotify-id-66", album8));
            songs8.add(new Song(92L, "Tear", 261, "spotify-id-67", album8));
            songs8.add(new Song(93L, "On Mercury", 235, "spotify-id-68", album8));
            songs8.add(new Song(94L, "Minor Thing", 197, "spotify-id-69", album8));
            songs8.add(new Song(95L, "Warm Tape", 234, "spotify-id-70", album8));
            songs8.add(new Song(96L, "Venice Queen", 413, "spotify-id-71", album8));

            songRepository.saveAll(songs8);

            Album album9 = new Album();
            album9.setAlbumId("10");
            album9.setYear(2006);
            album9.setTitle("Stadium Arcadium");
            album9.setBandId("REDHOTCHILIPEPPERS");

            albumRepository.save(album9);

            List<Song> songs9 = new ArrayList<>();

            songs9.add(new Song(97L, "Dani California", 243, "spotify-id-72", album9));
            songs9.add(new Song(98L, "Snow (Hey Oh)", 330, "spotify-id-73", album9));
            songs9.add(new Song(99L, "Charlie", 234, "spotify-id-74", album9));
            songs9.add(new Song(100L, "Stadium Arcadium", 311, "spotify-id-75", album9));
            songs9.add(new Song(101L, "Hump de Bump", 238, "spotify-id-76", album9));
            songs9.add(new Song(102L, "She's Only 18", 188, "spotify-id-77", album9));
            songs9.add(new Song(103L, "Slow Cheetah", 297, "spotify-id-78", album9));
            songs9.add(new Song(104L, "Torture Me", 175, "spotify-id-79", album9));
            songs9.add(new Song(105L, "Strip My Mind", 279, "spotify-id-80", album9));
            songs9.add(new Song(106L, "Especially in Michigan", 251, "spotify-id-81", album9));
            songs9.add(new Song(107L, "Warlocks", 255, "spotify-id-82", album9));
            songs9.add(new Song(108L, "C'mon Girl", 179, "spotify-id-83", album9));
            songs9.add(new Song(109L, "Wet Sand", 311, "spotify-id-84", album9));
            songs9.add(new Song(110L, "Hey", 285, "spotify-id-85", album9));
            songs9.add(new Song(111L, "Desecration Smile", 308, "spotify-id-86", album9));
            songs9.add(new Song(112L, "Tell Me Baby", 237, "spotify-id-87", album9));
            songs9.add(new Song(113L, "Hard to Concentrate", 276, "spotify-id-88", album9));
            songs9.add(new Song(114L, "21st Century", 282, "spotify-id-89", album9));
            songs9.add(new Song(115L, "She Looks to Me", 234, "spotify-id-90", album9));
            songs9.add(new Song(116L, "Readymade", 212, "spotify-id-91", album9));
            songs9.add(new Song(117L, "If", 230, "spotify-id-92", album9));
            songs9.add(new Song(118L, "Make You Feel Better", 271, "spotify-id-93", album9));
            songs9.add(new Song(119L, "Animal Bar", 226, "spotify-id-94", album9));
            songs9.add(new Song(120L, "So Much I", 231, "spotify-id-95", album9));
            songs9.add(new Song(121L, "Storm in a Teacup", 184, "spotify-id-96", album9));
            songs9.add(new Song(122L, "We Believe", 207, "spotify-id-97", album9));
            songs9.add(new Song(123L, "Turn It Again", 225, "spotify-id-98", album9));
            songs9.add(new Song(124L, "Death of a Martian", 229, "spotify-id-99", album9));

            songRepository.saveAll(songs9);
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

    public BandWithAlbumResponse getBandWithAlbum(String bandId){
        List<Album> albumsList = albumRepository.findAll().stream().filter(album -> album.getBandId().equals(bandId)).toList();
        List<AlbumDto> albums = albumsList.stream().map(album -> new AlbumDto(album.getAlbumId(),album.getTitle(),album.getYear())).toList();
        BandResponse band = getBand(bandId);

        BandWithAlbumResponse band1 = new BandWithAlbumResponse();
        band1.setAlbums(albums);
        band1.setName(band.getName());
        band1.setNationality(band.getNationality());
        band1.setBandId(band.getBandId());
        band1.setMembers(band.getMembers());
        return band1;
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
    private BandResponse getBand(String Id){
        return webClient.get()
                .uri("http://"+bandServiceBaseURL+"/api/band/{Id}",Id)
                .retrieve()
                .bodyToMono(BandResponse.class)
                .block();
    }
}
