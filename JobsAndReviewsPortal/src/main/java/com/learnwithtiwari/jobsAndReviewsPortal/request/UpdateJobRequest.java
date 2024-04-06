package com.learnwithtiwari.jobsAndReviewsPortal.request;

public class UpdateJobRequest {

    private String jobName;

    private String jobTitle;

    private String jobSkillSet;

    private String jobSalary;

    private String jobLocation;

    private Long companyId;


    public UpdateJobRequest(String jobName, String jobTitle, String jobSkillSet, String jobSalary, String jobLocation) {
        this.jobName = jobName;
        this.jobTitle = jobTitle;
        this.jobSkillSet = jobSkillSet;
        this.jobSalary = jobSalary;
        this.jobLocation = jobLocation;
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


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
