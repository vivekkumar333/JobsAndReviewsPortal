package com.learnwithtiwari.jobsAndReviews.jobs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobsRepository extends JpaRepository<JobsEntity, Long>{
    Optional<JobsEntity> findByJobId(Long id);
}
