package com.learnwithtiwari.jobsAndReviews.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> createJobs(@RequestBody JobsEntity jobInput){
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
