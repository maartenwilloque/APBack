package fact.it.userservice.controller;

import fact.it.userservice.dto.RatingRequest;
import fact.it.userservice.dto.RatingResponse;
import fact.it.userservice.dto.RatingWithAlbum;
import fact.it.userservice.model.Rating;
import fact.it.userservice.service.RatingService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @GetMapping("/average/{albumId}")
    @ResponseStatus(HttpStatus.OK)
    public RatingResponse getAverageRating (@PathVariable String albumId){
        return ratingService.getAverageRating(albumId);
    }

    @GetMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Rating getRating (@PathVariable Long Id){
        return ratingService.getRating(Id);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RatingWithAlbum> getUserRatings(@PathVariable String userId){
        return ratingService.getUserRatings(userId);
    }




    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Rating saveRating(@RequestBody RatingRequest ratingRequest){
        return ratingService.saveRating(ratingRequest);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Rating deleteRating(@PathVariable Long Id){
        return ratingService.deleteRating(Id);
    }
}
