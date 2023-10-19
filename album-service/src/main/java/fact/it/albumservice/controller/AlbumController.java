package fact.it.albumservice.controller;

import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.model.Album;
import fact.it.albumservice.service.AlbumService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping("/api")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping("/album/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumResponse getAlbum(@PathVariable("Id") Long albumId){
        return albumService.getAlbum(albumId);
    }
    @GetMapping("/albums")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }
}
