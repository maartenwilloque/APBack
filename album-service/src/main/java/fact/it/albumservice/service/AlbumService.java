package fact.it.albumservice.service;

import fact.it.albumservice.model.Album;
import fact.it.albumservice.repository.AlbumRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final WebClient webClient;

    public Album getAlbum(long Id){
        return albumRepository.getReferenceById(Id);
    }
}
