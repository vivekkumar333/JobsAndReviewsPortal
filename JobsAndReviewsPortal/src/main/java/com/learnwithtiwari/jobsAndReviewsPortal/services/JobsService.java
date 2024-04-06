package com.learnwithtiwari.jobsAndReviewsPortal.services;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Company;
import com.learnwithtiwari.jobsAndReviewsPortal.entities.Jobs;
import com.learnwithtiwari.jobsAndReviewsPortal.repo.CompanyRepo;
import com.learnwithtiwari.jobsAndReviewsPortal.request.JobCreationRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateJobRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.repo.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    @Autowired
    JobsRepository jobsRepo;

    @Autowired
    CompanyRepo compRepo;

    public ResponseEntity<Object> getAllJobs(){
        List<Jobs> jobList = jobsRepo.findAll();

        if(jobList.size() > 0) {
            return new ResponseEntity<>(jobList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Resource Not found! Job list is empty", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> createJobs(JobCreationRequest jobInput){

        Optional<Company> savedComp= compRepo.findById(jobInput.getCompanyId());
        Jobs savedJob = null;
        if(savedComp.isPresent()){
            savedJob= jobsRepo.save(new Jobs(
                    jobInput.getJobName(),
                    jobInput.getJobTitle(),
                    jobInput.getJobSkillSet(),
                    jobInput.getJobSalary(),
                    jobInput.getJobLocation(),
                    savedComp.get()));
        }else{
            return new ResponseEntity<>("Job Creation failed! Company id not found in the database", HttpStatus.NOT_FOUND);
        }



        if(savedJob != null){
            return new ResponseEntity<>("Jobs created Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateJobs(Long jobId, UpdateJobRequest updateJob){
        Optional<Jobs> savedJob = jobsRepo.findById(jobId);
        Optional<Company> savedComp= compRepo.findById(updateJob.getCompanyId());

        if(savedComp.isPresent()){
            if(savedJob.isPresent()){
                jobsRepo.save(new Jobs(jobId,
                        updateJob.getJobName(),
                        updateJob.getJobTitle(),
                        updateJob.getJobSkillSet(),
                        updateJob.getJobSalary(),
                        updateJob.getJobLocation(),
                        savedComp.get()));

                return new ResponseEntity<>("Job has been updated successfully", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Failed! JobId not found", HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>("Job Creation failed! Company id not found in the database", HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Object> getJobById(Long id){
        Optional<Jobs> job = jobsRepo.findByJobId(id);

        if(job.isPresent()) {
            return new ResponseEntity<>(job.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Job not found in the database", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Object> deleteJob(Long id){
        Optional<Jobs> job = jobsRepo.findByJobId(id);

        if(job.isPresent()) {
            jobsRepo.delete(job.get());
            return new ResponseEntity<>("Successful: Job has been deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Job not found in the database", HttpStatus.NOT_FOUND);
        }
    }

}
