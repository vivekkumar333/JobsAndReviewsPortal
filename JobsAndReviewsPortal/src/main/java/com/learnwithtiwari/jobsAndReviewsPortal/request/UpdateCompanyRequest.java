package com.learnwithtiwari.jobsAndReviewsPortal.request;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Jobs;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class UpdateCompanyRequest {

    private String companyName;

    private String companyType;

    private String companyHeadquarter;

    public UpdateCompanyRequest(String companyName, String companyType, String companyHeadquarter) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyHeadquarter = companyHeadquarter;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyHeadquarter() {
        return companyHeadquarter;
    }

    public void setCompanyHeadquarter(String companyHeadquarter) {
        this.companyHeadquarter = companyHeadquarter;
    }
}
