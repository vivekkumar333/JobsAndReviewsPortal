package com.learnwithtiwari.jobsAndReviews.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    @Autowired
    JobsRepository jobsRepo;

    public ResponseEntity<Object> getAllJobs(){
        List<JobsEntity> jobList = jobsRepo.findAll();

        if(jobList.size() > 0) {
            return new ResponseEntity<>(jobList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Resource Not found! Job list is empty", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> createJobs(JobsEntity jobInput){
        JobsEntity savedJob = null;
         savedJob= jobsRepo.save(new JobsEntity(
                 jobInput.getJobName(),
                 jobInput.getJobTitle(),
                 jobInput.getJobSkillSet(),
                 jobInput.getJobSalary(),
                 jobInput.getJobLocation()));

        if(savedJob != null){
            return new ResponseEntity<>("Jobs created Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateJobs(Long jobId, UpdateJobRequest updateJob){
        Optional<JobsEntity> savedJob = jobsRepo.findById(jobId);
        if(savedJob.isPresent()){
            jobsRepo.save(new JobsEntity(jobId,
                    updateJob.getJobName(),
                    updateJob.getJobTitle(),
                    updateJob.getJobSkillSet(),
                    updateJob.getJobSalary(),
                    updateJob.getJobLocation()));

            return new ResponseEntity<>("Job has been updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! JobId not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> getJobById(Long id){
        Optional<JobsEntity> job = jobsRepo.findByJobId(id);

        if(job.isPresent()) {
            return new ResponseEntity<>(job.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Job not found in the database", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Object> deleteJob(Long id){
        Optional<JobsEntity> job = jobsRepo.findByJobId(id);

        if(job.isPresent()) {
            jobsRepo.delete(job.get());
            return new ResponseEntity<>("Successful: Job has been deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Job not found in the database", HttpStatus.NOT_FOUND);
        }
    }

}
