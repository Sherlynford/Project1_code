package com.example.Project1.Repository;

import com.example.Project1.Entity.Job;
import com.example.Project1.Entity.JobApplication;
import com.example.Project1.Entity.StudentProfile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStudentProfileAndJob(StudentProfile studentProfile, Job job);
}
