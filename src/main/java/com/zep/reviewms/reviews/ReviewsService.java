package com.zep.reviewms.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews(Long companyId);
    boolean addReviews(Long companyId, Reviews reviews);
    Reviews getReview(Long reviewId);
    boolean updateReview(Long reviewId, Reviews reviews);

    boolean deleteReview( Long reviewId);
}
