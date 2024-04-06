package com.learnwithtiwari.jobsAndReviewsPortal.repo;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewsRepo extends JpaRepository<Reviews, Long> {
    Optional<Reviews> findByReviewId(Long id);
}
