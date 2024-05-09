package com.learnwithtiwari.jobsAndReviewsPortal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="REVIEWS_TBL")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String title;

    private String description;

    private String ratings;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Reviews() {
    }

    public Reviews(Long reviewId, String title, String description, String ratings, Company company) {
        this.reviewId = reviewId;
        this.title = title;
        this.description = description;
        this.ratings = ratings;
        this.company = company;
    }

    public Reviews(String title, String description, String ratings, Company company) {
        this.title = title;
        this.description = description;
        this.ratings = ratings;
        this.company = company;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
