package com.praveen.jobapplication.service;

import com.praveen.jobapplication.Entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();

    Review findReviewById(Long companyId, Long reviewId);

    boolean addReviews(Long id, Review review);

    boolean updateReview(Long companyId, Long reviewId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
