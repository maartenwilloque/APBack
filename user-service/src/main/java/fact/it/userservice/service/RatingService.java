package fact.it.userservice.service;

import fact.it.userservice.dto.AlbumDto;
import fact.it.userservice.dto.RatingRequest;
import fact.it.userservice.dto.RatingResponse;
import fact.it.userservice.dto.RatingWithAlbum;
import fact.it.userservice.model.Rating;
import fact.it.userservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final WebClient webClient;


    @Value("${albumService.baseurl}")
    private String albumServiceBaseURL;

    @Transactional(readOnly = true)
    public RatingResponse getAverageRating(String albumId) {
        double averageScore = ratingRepository.findAll().stream().filter(rating -> rating.getAlbumId().equals(albumId)).collect(Collectors.averagingInt(Rating::getScore));
        return RatingResponse.builder().albumId(albumId).score(averageScore).build();
    }

    public Rating saveRating(RatingRequest ratingRequest) {
        Rating rating = new Rating();
        rating.setName(ratingRequest.getName());
        rating.setAlbumId(ratingRequest.getAlbumId());
        rating.setScore(ratingRequest.getScore());
        ratingRepository.save(rating);
        return rating;
    }

    public List<RatingWithAlbum> getUserRatings(String userId) {
        List<Rating> ratings = ratingRepository.findAll().stream().filter(rating -> rating.getName().equals(userId)).toList();
        return ratings.stream().map(rating -> new RatingWithAlbum(rating.getScore(), rating.getName(), getAlbum(rating.getAlbumId()))).toList();

    }

    public Rating deleteRating(String albumId) {
        Optional<Rating> rating = ratingRepository.findAll().stream().filter(r -> r.getAlbumId().equals(albumId)).findFirst();

        if (rating.isPresent()) {
            Rating deletedRating = rating.get();
            ratingRepository.delete(deletedRating);
            return deletedRating;
        } else {
            return null;
        }
    }

    private AlbumDto getAlbum(String albumId) {
        return webClient.get().uri("http://" + albumServiceBaseURL + "/api/albumDto/{Id}", albumId).retrieve().bodyToMono(AlbumDto.class).block();
    }


}

