package fact.it.albumservice.controller;

import fact.it.albumservice.model.Album;
import fact.it.albumservice.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/album")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Album getAlbum(int Id){
        return albumService.getAlbum(Id);
    }
}
