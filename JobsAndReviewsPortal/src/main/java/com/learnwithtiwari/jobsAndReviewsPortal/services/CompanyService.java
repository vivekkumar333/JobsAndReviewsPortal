package com.learnwithtiwari.jobsAndReviewsPortal.services;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Company;
import com.learnwithtiwari.jobsAndReviewsPortal.entities.Jobs;
import com.learnwithtiwari.jobsAndReviewsPortal.repo.CompanyRepo;
import com.learnwithtiwari.jobsAndReviewsPortal.repo.JobsRepository;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateCompanyRequest;
import com.learnwithtiwari.jobsAndReviewsPortal.request.UpdateJobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    public ResponseEntity<Object> getAllJobs(){
        List<Company> compList = companyRepo.findAll();

        if(compList.size() > 0) {
            return new ResponseEntity<>(compList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Resource Not found! Company list is empty", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> createJobs(Company data){
        Company savedCompany = null;
        savedCompany= companyRepo.save(new Company(data.getCompanyName(),
                data.getCompanyType(),
                data.getCompanyHeadquarter()));

        if(savedCompany != null){
            return new ResponseEntity<>("Company details stored Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Storing Company info failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateJobs(Long id, UpdateCompanyRequest data){
        Optional<Company> savedData = companyRepo.findById(id);
        if(savedData.isPresent()){
            companyRepo.save(new Company(id,
                    data.getCompanyName(),
                    data.getCompanyType(),
                    data.getCompanyHeadquarter()));

            return new ResponseEntity<>("Company info has been updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Company id not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> getJobById(Long id){
        Optional<Company> savedData = companyRepo.findById(id);

        if(savedData.isPresent()) {
            return new ResponseEntity<>(savedData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Company info has not found in the database", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Object> deleteJob(Long id){
        Optional<Company> companyInfo = companyRepo.findById(id);

        if(companyInfo.isPresent()) {
            companyRepo.delete(companyInfo.get());
            return new ResponseEntity<>("Successful: Company details has been deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed! Company with ID not found in the database", HttpStatus.NOT_FOUND);
        }
    }
}
