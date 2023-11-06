package fact.it.albumservice;

import fact.it.albumservice.dto.*;
import fact.it.albumservice.model.Album;
import fact.it.albumservice.model.Song;
import fact.it.albumservice.repository.AlbumRepository;
import fact.it.albumservice.repository.SongRepository;
import fact.it.albumservice.service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AlbumServiceTest {

    @InjectMocks
    private AlbumService albumService;

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private SongRepository songRepository;

    @Mock
    private WebClient webClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAlbum() {
        // Arrange
        Album album = new Album();
        album.setAlbumId("1");
        album.setYear(1991);
        album.setTitle("Nevermind");
        album.setBandId("NIRVANA");

        when(albumRepository.getReferenceById(1L)).thenReturn(album);
        when(webClient.get().uri(Mockito.anyString(), Mockito.anyString()).retrieve().bodyToMono(RatingResponse.class))
                .thenReturn(Mono.just(new RatingResponse(4.5))); // Simulate a rating response

        // Act
        AlbumResponse albumResponse = albumService.getAlbum(1L);

        // Assert
        assertEquals("1", albumResponse.getAlbumId());
        assertEquals("Nevermind", albumResponse.getTitle());
        assertEquals(1991, albumResponse.getYear());
        assertEquals("NIRVANA", albumResponse.getBand());
        assertEquals(4.5, albumResponse.getRating());
    }

    @Test
    public void testGetAlbums() {
        // Arrange
        List<Album> albums = new ArrayList<>();
        Album album1 = new Album();
        album1.setAlbumId("1");
        album1.setYear(1991);
        album1.setTitle("Nevermind");
        album1.setBandId("NIRVANA");
        albums.add(album1);

        Album album2 = new Album();
        album2.setAlbumId("2");
        album2.setYear(1999);
        album2.setTitle("The Distance to Here");
        album2.setBandId("LIVE");
        albums.add(album2);

        when(albumRepository.findAll()).thenReturn(albums);
        when(webClient.get().uri(Mockito.anyString(), Mockito.anyString()).retrieve().bodyToMono(RatingResponse.class))
                .thenReturn(Mono.just(new RatingResponse(4.5))); // Simulate a rating response

        // Act
        List<AlbumResponse> albumResponses = albumService.getAlbums();

        // Assert
        assertEquals(2, albumResponses.size());
        assertEquals("1", albumResponses.get(0).getAlbumId());
        assertEquals("Nevermind", albumResponses.get(0).getTitle());
        assertEquals(1991, albumResponses.get(0).getYear());
        assertEquals("NIRVANA", albumResponses.get(0).getBand());
        assertEquals(4.5, albumResponses.get(0).getRating());

        assertEquals("2", albumResponses.get(1).getAlbumId());
        assertEquals("The Distance to Here", albumResponses.get(1).getTitle());
        assertEquals(1999, albumResponses.get(1).getYear());
        assertEquals("LIVE", albumResponses.get(1).getBand());
        assertEquals(4.5, albumResponses.get(1).getRating());
    }

    @Test
    public void testGetSongs() {
        // Arrange
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song();
        song1.setTitle("Smells Like Teen Spirit");
        song1.setDuration(299);
        song1.setSpotifyId("spotify-link-1");
        songs.add(song1);

        Song song2 = new Song();
        song2.setTitle("In Bloom");
        song2.setDuration(251);
        song2.setSpotifyId("spotify-link-2");
        songs.add(song2);

        when(songRepository.findAll()).thenReturn(songs);

        // Act
        List<SongResponse> songResponses = albumService.getSongs();

        // Assert
        assertEquals(2, songResponses.size());
        assertEquals("Smells Like Teen Spirit", songResponses.get(0).getTitle());
        assertEquals(299, songResponses.get(0).getDuration());
        assertEquals("spotify-link-1", songResponses.get(0).getSpotifyId());

        assertEquals("In Bloom", songResponses.get(1).getTitle());
        assertEquals(251, songResponses.get(1).getDuration());
        assertEquals("spotify-link-2", songResponses.get(1).getSpotifyId());
    }
}
