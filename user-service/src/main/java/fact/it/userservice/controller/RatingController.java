package fact.it.userservice.controller;

import fact.it.userservice.dto.RatingResponse;
import fact.it.userservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RatingResponse getAverageRating (@RequestParam String albumId){
        return ratingService.getAverageRating(albumId);
    }
}
