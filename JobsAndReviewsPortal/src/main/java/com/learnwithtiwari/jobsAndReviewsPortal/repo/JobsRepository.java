package com.learnwithtiwari.jobsAndReviewsPortal.repo;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
    Optional<Jobs> findByJobId(Long id);
}
