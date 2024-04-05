package com.learnwithtiwari.jobsAndReviews.jobs;

import jakarta.persistence.*;
import org.aspectj.weaver.AjcMemberMaker;

import java.util.Objects;

@Entity
@Table(name = "Jobs")
class JobsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String jobName;

    private String jobTitle;

    private String jobSkillSet;

    private String jobSalary;

    private String jobLocation;

    public Long getJobId() {
        return jobId;
    }

    public JobsEntity() {}

    public JobsEntity(String jobName, String jobTitle, String jobSkillSet, String jobSalary, String jobLocation) {
        this.jobName = jobName;
        this.jobTitle = jobTitle;
        this.jobSkillSet = jobSkillSet;
        this.jobSalary = jobSalary;
        this.jobLocation = jobLocation;
    }

    public JobsEntity(Long jobId, String jobName, String jobTitle, String jobSkillSet, String jobSalary, String jobLocation) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobTitle = jobTitle;
        this.jobSkillSet = jobSkillSet;
        this.jobSalary = jobSalary;
        this.jobLocation = jobLocation;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobsEntity that = (JobsEntity) o;
        return Objects.equals(jobName, that.jobName) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(jobSkillSet, that.jobSkillSet) && Objects.equals(jobSalary, that.jobSalary) && Objects.equals(jobLocation, that.jobLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobName, jobTitle, jobSkillSet, jobSalary, jobLocation);
    }
}
