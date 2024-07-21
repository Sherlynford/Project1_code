package com.example.Project1.Service;

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

    public JobApplication updateJobApplication(JobApplication newJobApplication, Long id) {
        return jobApplicationRepository.findById(id)
                .map(jobApplication -> {
                    jobApplication.setStatus(newJobApplication.getStatus());
                    jobApplication.setDateTime(Instant.now());

                    return jobApplicationRepository.save(jobApplication);
                })
                .orElseGet(() -> {
                    newJobApplication.setId(id);
                    return jobApplicationRepository.save(newJobApplication);
                });
    }

    public void deleteJobApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }
}
