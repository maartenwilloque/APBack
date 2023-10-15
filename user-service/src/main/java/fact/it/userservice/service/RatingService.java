package fact.it.userservice.service;

import fact.it.userservice.dto.RatingResponse;
import fact.it.userservice.model.Rating;
import fact.it.userservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    @Transactional(readOnly = true)
    public RatingResponse getAverageRating(String albumId){
        double averageScore =  ratingRepository.findAll().stream().filter(rating -> rating.getAlbumId().equals(albumId)).collect(Collectors.averagingInt(Rating::getScore));
        return RatingResponse.builder().albumId(albumId).score(averageScore).build();
        }
    }

