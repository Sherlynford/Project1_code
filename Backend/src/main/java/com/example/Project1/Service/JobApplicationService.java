package com.example.Project1.Service;

import com.example.Project1.Entity.Job;
import com.example.Project1.Entity.JobApplication;
import com.example.Project1.Repository.JobApplicationRepository;
import com.example.Project1.Repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobRepository jobRepository;

    @Transactional
    public JobApplication createJobApplication(JobApplication jobApplication) {
        Long jobId = jobApplication.getJob().getId();
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalStateException("Job not found"));

        if (job.getNumberApplication() == 0 || !job.getApplicationTime().isAfter(LocalDate.now())) {
            throw new IllegalStateException("Cannot apply for the job");
         }

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

    public JobApplication acceptJobApplication(Long id) {
        return updateJobApplicationStatus(id, "Accept");
    }

    public JobApplication declineJobApplication(Long id) {
        return updateJobApplicationStatus(id, "Decline");
    }

    @Transactional
    public JobApplication chooseJobApplication(Long id) {
        return jobApplicationRepository.findById(id)
                .map(jobApplication -> {
                    Job job = jobApplication.getJob();
                    if (job.getNumberApplication() > 0) {
                        job.setNumberApplication(job.getNumberApplication() - 1);
                        jobRepository.save(job);
                    } else {
                        throw new IllegalStateException("Cannot choose job application because the number of applications is zero.");
                    }
                    return updateJobApplicationStatus(id, "Choose");
                })
                .orElseThrow(() -> new IllegalStateException("Job application not found"));
    }

    public JobApplication cancelJobApplication(Long id) {
        return updateJobApplicationStatus(id, "Cancel");
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
