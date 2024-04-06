package com.learnwithtiwari.jobsAndReviewsPortal.controller;

import com.learnwithtiwari.jobsAndReviewsPortal.request.JobCreationRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.request.ReviewRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateJobRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.services.JobsService;
import com.learnwithtiwari.jobsAndReviewsPortal.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    ReviewsService reviewsService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllReviews(){
        return reviewsService.getAllJobs();
    }


    @PostMapping("/")
    public ResponseEntity<String> createReview(@RequestBody ReviewRequest input){
        System.out.println("reached here ----------------");
        return reviewsService.createReviews(input);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateReview(@PathVariable Long jobId, @RequestBody ReviewRequest upReq){
        return reviewsService.updateJobs(jobId,upReq);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Object> getReviewById(@PathVariable Long jobId){
        return reviewsService.getJobById(jobId);
    }


    @DeleteMapping("/{jobId}")
    public ResponseEntity<Object> deleteReview(@PathVariable Long jobId){
        return reviewsService.deleteJob(jobId);
    }


}
