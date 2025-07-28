package com.praveen.jobapplication.controller;

import com.praveen.jobapplication.Entity.Review;
import com.praveen.jobapplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/companies/{id}")
    public ResponseEntity<List<Review>> findAll(){
        return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/companies/{CompanyId}/reviews/{reviewId}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long CompanyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.findReviewById(CompanyId, reviewId), HttpStatus.OK);
    }

    @PostMapping("/companies/{id}/reviews")
    public ResponseEntity<String> addReviews(@PathVariable Long id, @RequestBody Review review){
        boolean bool = reviewService.addReviews(id, review);
        if(bool){
            return new ResponseEntity<>("Review added sucessfully..!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review not added...!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/companies/{CompanyId}/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long CompanyId, @PathVariable Long reviewId, @RequestBody Review review){
        boolean update = reviewService.updateReview(CompanyId, reviewId, review);
        if(update){
            return new ResponseEntity<>("Review updated sucessfully..!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/companies/{CompanyId}/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long CompanyId, @PathVariable Long reviewId){
        boolean deleted = reviewService.deleteReview(CompanyId, reviewId);
        if(deleted){
            return new ResponseEntity<>("Review deleted sucessfully...!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
