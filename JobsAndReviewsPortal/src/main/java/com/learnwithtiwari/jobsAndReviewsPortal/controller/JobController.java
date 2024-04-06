package com.learnwithtiwari.jobsAndReviewsPortal.controller;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Jobs;
import com.learnwithtiwari.jobsAndReviewsPortal.request.JobCreationRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.services.JobsService;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateJobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobsService jobsService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllJobs(){
        return jobsService.getAllJobs();
    }


    @PostMapping("/")
    public ResponseEntity<String> createJobs(@RequestBody JobCreationRequest jobInput){
        System.out.println("reached here ----------------");
        return jobsService.createJobs(jobInput);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateJobs(@PathVariable Long jobId, @RequestBody UpdateJobRequest updateJob){
        return jobsService.updateJobs(jobId,updateJob);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Object> getJobById(@PathVariable Long jobId){
        return jobsService.getJobById(jobId);
    }


    @DeleteMapping("/{jobId}")
    public ResponseEntity<Object> deleteJob(@PathVariable Long jobId){
        return jobsService.deleteJob(jobId);
    }

}
