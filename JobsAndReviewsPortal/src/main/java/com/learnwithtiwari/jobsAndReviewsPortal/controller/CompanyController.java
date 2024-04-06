package com.learnwithtiwari.jobsAndReviewsPortal.controller;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Company;
import com.learnwithtiwari.jobsAndReviewsPortal.entities.Jobs;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateCompanyRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateJobRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.services.CompanyService;
import com.learnwithtiwari.jobsAndReviewsPortal.services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllJobs(){
        return companyService.getAllJobs();
    }


    @PostMapping("/")
    public ResponseEntity<String> createJobs(@RequestBody Company input){
        return companyService.createJobs(input);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateJobs(@PathVariable Long jobId, @RequestBody UpdateCompanyRequest updateReq){
        return companyService.updateJobs(jobId,updateReq);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Object> getJobById(@PathVariable Long jobId){
        return companyService.getJobById(jobId);
    }


    @DeleteMapping("/{jobId}")
    public ResponseEntity<Object> deleteJob(@PathVariable Long jobId){
        return companyService.deleteJob(jobId);
    }

}
