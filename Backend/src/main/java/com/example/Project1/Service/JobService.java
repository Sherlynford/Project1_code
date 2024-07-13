package com.example.Project1.Service;

import com.example.Project1.Entity.Job;
import com.example.Project1.Repository.JobRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Job updateJob(Job newJob, Long id) {
        return jobRepository.findById(id)
                .map(job -> {
                    job.setName(newJob.getName());
                    job.setDetail(newJob.getDetail());
                    job.setCategory(newJob.getCategory());
                    job.setQualification(newJob.getQualification());
                    job.setTimeWorkingDate(newJob.getTimeWorkingDate());
                    job.setNumberApplication(newJob.getNumberApplication());
                    job.setBenefitSalary(newJob.getBenefitSalary());
                    job.setApplicationTime(newJob.getApplicationTime()); 
                    return jobRepository.save(job);
                })
                .orElseGet(() -> {
                    newJob.setId(id);
                    return jobRepository.save(newJob);
                });
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
