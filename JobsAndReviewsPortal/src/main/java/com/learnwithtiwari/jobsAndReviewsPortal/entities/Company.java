package com.learnwithtiwari.jobsAndReviewsPortal.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company_tbl")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String companyType;

    private String companyHeadquarter;

    @OneToMany(mappedBy = "company")
    private List<Jobs> jobs;

    @OneToMany(mappedBy = "company")
    private List<Reviews> reviews;
    public Company() {}

    public Company(Long id, String companyName, String companyType, String companyHeadquarter) {
        this.id = id;
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyHeadquarter = companyHeadquarter;
    }

    public Company(String companyName, String companyType, String companyHeadquarter) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyHeadquarter = companyHeadquarter;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Jobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName) && Objects.equals(companyType, company.companyType) && Objects.equals(companyHeadquarter, company.companyHeadquarter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, companyType, companyHeadquarter);
    }
}
