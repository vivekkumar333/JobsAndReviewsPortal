package com.learnwithtiwari.jobsAndReviewsPortal.repo;

import com.learnwithtiwari.jobsAndReviewsPortal.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
