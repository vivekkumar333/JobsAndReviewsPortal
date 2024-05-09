package com.learnwithtiwari.jobsAndReviewsPortal.request;

public class ReviewRequest {

    private String title;

    private String description;

    private String ratings;

    private Long companyId;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRatings() {
        return ratings;
    }

    public Long getCompanyId() {
        return companyId;
    }
}
