package com.zep.reviewms.reviews.impl;
import com.zep.reviewms.reviews.Reviews;
import com.zep.reviewms.reviews.ReviewsRepository;
import com.zep.reviewms.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;


    public ReviewsServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;

    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
                return reviewsRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReviews(Long companyId, Reviews reviews) {

     if(companyId !=null){
            reviews.setCompanyId(companyId);
            reviewsRepository.save(reviews);
            return true;

        }else{return  false;}
    }

    @Override
    public Reviews getReview( Long reviewId) {
     return  reviewsRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Reviews updatedReview) {
        Reviews reviews=reviewsRepository.findById(reviewId).orElse(null);
        if(reviews !=null){
          reviews.setTitle(updatedReview.getTitle());
            reviews.setDescription(updatedReview.getDescription());
            reviews.setRating(updatedReview.getRating());
            reviews.setCompanyId(updatedReview.getCompanyId());
          reviewsRepository.save(reviews );
          return true;
        }else{return false;}
    }
    @Override
    public  boolean deleteReview(Long reviewId) {
        Reviews review=reviewsRepository.findById(reviewId).orElse(null);
        if(review != null)
        {reviewsRepository.delete(review);
            return  true;
        }else {
     return  false;
    }}

}
