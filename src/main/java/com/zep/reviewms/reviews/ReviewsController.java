package com.zep.reviewms.reviews;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud/")
public class ReviewsController {
    private  final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;

    }
    @GetMapping("/reviews")
    public  ResponseEntity<List<Reviews>>getAllReviews(@RequestParam Long companyId){
        return  new ResponseEntity<>(reviewsService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews/")
    public ResponseEntity<String> addReviews(@RequestParam Long companyId, @RequestBody Reviews reviews) {
      boolean isReviewSaved= reviewsService.addReviews(companyId,reviews);
      if(isReviewSaved) {

          return new ResponseEntity<>("Review Added Succesfully", HttpStatus.OK);
      } else{
              return new  ResponseEntity<>("Review not saved",HttpStatus.NOT_FOUND);
      }
    }
    @GetMapping("/reviews/{reviewsId}")
    public  ResponseEntity<Reviews>getReview(@PathVariable Long reviewsId){
     return new ResponseEntity<>(reviewsService.getReview(reviewsId), HttpStatus.OK);
    }
    @DeleteMapping("/review/{reviewsId}")
    public ResponseEntity<Boolean> deleteReview( @PathVariable Long reviewId) {
        boolean isDeleted = reviewsService.deleteReview(reviewId);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }
    @PutMapping("/reviews/{reviewsId}")
    public  ResponseEntity<String>updateReview(@PathVariable Long reviewsId, @RequestBody Reviews reviews){
 boolean isReviewUpdated=reviewsService.updateReview(reviewsId,reviews);
 if(isReviewUpdated)
        return  new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
else
     return  new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
    }
}
