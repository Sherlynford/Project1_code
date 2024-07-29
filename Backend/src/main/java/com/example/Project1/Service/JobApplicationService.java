package com.example.Project1.Service;

import com.example.Project1.Entity.Job;
import com.example.Project1.Repository.JobRepository;
import com.example.Project1.Entity.JobApplication;
import com.example.Project1.Repository.JobApplicationRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    private final JobRepository jobRepository;

    public JobApplication createJobApplication(JobApplication jobApplication) { // -1 in numberApplication of job and cant add if numberApplication = 0 and cant add if job applicationTime end
        jobApplication.setDateTime(Instant.now());
        jobApplication.setStatus("Applied");
        return jobApplicationRepository.save(jobApplication);
    }

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public Optional<JobApplication> getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id);
    }

    public JobApplication updateJobApplicationStatus(Long id, String status) {
        return jobApplicationRepository.findById(id)
                .map(jobApplication -> {
                    jobApplication.setStatus(status);
                    jobApplication.setDateTime(Instant.now());
    
                    return jobApplicationRepository.save(jobApplication);
                })
                .orElseGet(() -> {
                    JobApplication newJobApplication = new JobApplication();
                    newJobApplication.setId(id);
                    newJobApplication.setStatus(status);
                    newJobApplication.setDateTime(Instant.now());
                    return jobApplicationRepository.save(newJobApplication);
                });
    }
    
    public JobApplication updateJobApplication(JobApplication newJobApplication, Long id) {
        return updateJobApplicationStatus(id, newJobApplication.getStatus());
    }
    
    public JobApplication interviewJobApplication(Long id) {
        return updateJobApplicationStatus(id, "interview");
    }
    
    public JobApplication acceptJobApplication(Long id ) {
        return updateJobApplicationStatus(id, "Accept");
    }
    
    public JobApplication confirmJobApplication(Long id) {
        return updateJobApplicationStatus(id, "Confirm");
    }
    
    public void deleteAllJobApplications() {
        jobApplicationRepository.deleteAll();
    }

    public void deleteJobApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }
}
