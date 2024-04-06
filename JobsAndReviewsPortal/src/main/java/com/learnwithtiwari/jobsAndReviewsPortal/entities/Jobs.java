package com.learnwithtiwari.jobsAndReviewsPortal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Job_tbl")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String jobName;

    private String jobTitle;

    private String jobSkillSet;

    private String jobSalary;

    private String jobLocation;

    @JsonIgnore
    @ManyToOne
    private Company company;



    public Jobs() {}
    public Jobs(Long jobId, String jobName, String jobTitle, String jobSkillSet, String jobSalary, String jobLocation, Company company) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobTitle = jobTitle;
        this.jobSkillSet = jobSkillSet;
        this.jobSalary = jobSalary;
        this.jobLocation = jobLocation;
        this.company = company;
    }
    public Jobs(String jobName, String jobTitle, String jobSkillSet, String jobSalary, String jobLocation, Company company) {
        this.jobName = jobName;
        this.jobTitle = jobTitle;
        this.jobSkillSet = jobSkillSet;
        this.jobSalary = jobSalary;
        this.jobLocation = jobLocation;
        this.company = company;
    }



    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobSkillSet() {
        return jobSkillSet;
    }

    public void setJobSkillSet(String jobSkillSet) {
        this.jobSkillSet = jobSkillSet;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobs that = (Jobs) o;
        return Objects.equals(jobName, that.jobName) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(jobSkillSet, that.jobSkillSet) && Objects.equals(jobSalary, that.jobSalary) && Objects.equals(jobLocation, that.jobLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobName, jobTitle, jobSkillSet, jobSalary, jobLocation);
    }
}
