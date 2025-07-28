package com.praveen.jobapplication.service.impl;

import com.praveen.jobapplication.Entity.Company;
import com.praveen.jobapplication.Entity.Review;
import com.praveen.jobapplication.repository.ReviewRepository;
import com.praveen.jobapplication.service.CompanyService;
import com.praveen.jobapplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean addReviews(Long id, Review review) {
        Company company = companyService.findCompanyById(id);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if(optionalReview.isPresent()){
            Review existingReview = optionalReview.get();

            if(!existingReview.getCompany().getId().equals(companyId)){
                return false;
            }
            existingReview.setTitle(review.getTitle());
            existingReview.setDescription(review.getDescription());
            existingReview.setRatings(review.getRatings());

            reviewRepository.save(existingReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);

        if(optionalReview.isPresent()){
            Review review = optionalReview.get();
            if(!review.getCompany().getId().equals(companyId)){
                return false;
            }
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }
}
