package com.example.Project1.Repository;

import com.example.Project1.Entity.JobApplication;
import com.example.Project1.Entity.StudentProfile;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    Optional<JobApplication> findByStudentProfileIdAndJobId(Long studentId, Long jobId);

    List<JobApplication> findByStudentProfileAndStatus(StudentProfile studentProfile, String status);
}
