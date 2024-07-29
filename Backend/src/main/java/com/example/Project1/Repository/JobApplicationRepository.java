package com.example.Project1.Repository;

import com.example.Project1.Entity.JobApplication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    Optional<JobApplication> findByStudentProfileIdAndJobId(Long studentId, Long jobId);
}
