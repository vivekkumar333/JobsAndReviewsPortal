package com.learnwithtiwari.jobsAndReviewsPortal.services;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Company;
import com.learnwithtiwari.jobsAndReviewsPortal.entities.Jobs;
import com.learnwithtiwari.jobsAndReviewsPortal.entities.Reviews;
import com.learnwithtiwari.jobsAndReviewsPortal.repo.CompanyRepo;
import com.learnwithtiwari.jobsAndReviewsPortal.repo.JobsRepository;
import com.learnwithtiwari.jobsAndReviewsPortal.repo.ReviewsRepo;
import com.learnwithtiwari.jobsAndReviewsPortal.request.JobCreationRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.request.ReviewRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateJobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {
    @Autowired
    ReviewsRepo reviewsRepo;

    @Autowired
    CompanyRepo compRepo;

    public ResponseEntity<Object> getAllJobs(){
        List<Reviews> reviewList = reviewsRepo.findAll();

        if(reviewList.size() > 0) {
            return new ResponseEntity<>(reviewList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Resource Not found! Review list is empty", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> createReviews(ReviewRequest reviewReq){

        Optional<Company> savedComp= compRepo.findById(reviewReq.getCompanyId());
        Reviews savedReview = null;
        if(savedComp.isPresent()){
            savedReview= reviewsRepo.save(new Reviews(reviewReq.getReviewTitle(),reviewReq.getReviewDescription(),savedComp.get()));
        }else{
            return new ResponseEntity<>("Company review failed to update in the database due to Company id not found in the database", HttpStatus.NOT_FOUND);
        }



        if(savedReview != null){
            return new ResponseEntity<>("Company review provided Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Company review has been failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateJobs(Long reviewId, ReviewRequest updateReview){
        Optional<Reviews> savedReview = reviewsRepo.findById(reviewId);
        Optional<Company> savedComp= compRepo.findById(updateReview.getCompanyId());

        if(savedComp.isPresent()){
            if(savedReview.isPresent()){
                reviewsRepo.save(new Reviews(reviewId,
                        updateReview.getReviewTitle(),
                        updateReview.getReviewDescription(),
                        savedComp.get()));

                return new ResponseEntity<>("Job has been updated successfully", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Failed! Review ID not found", HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>("Review modification failed! Company id not found in the database", HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Object> getJobById(Long id){
        Optional<Reviews> review = reviewsRepo.findByReviewId(id);

        if(review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Review not found in the database", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Object> deleteJob(Long id){
        Optional<Reviews> review = reviewsRepo.findByReviewId(id);

        if(review.isPresent()) {
            reviewsRepo.delete(review.get());
            return new ResponseEntity<>("Successful: Review has been deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Review ID not found in the database", HttpStatus.NOT_FOUND);
        }
    }
}
