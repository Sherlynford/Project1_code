package com.example.Project1.Controller;

import com.example.Project1.Entity.Job;
import com.example.Project1.Entity.JobApplication;
import com.example.Project1.Service.JobApplicationService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobApplications")
@CrossOrigin("*")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @PostMapping("/")
    public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication) {
        JobApplication newJobApplication = jobApplicationService.createJobApplication(jobApplication);
        return new ResponseEntity<>(newJobApplication, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<JobApplication>> getAllJobApplications() {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications();
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        Optional<JobApplication> jobApplication = jobApplicationService.getJobApplicationById(id);
        return jobApplication.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication newJobApplication) {
        JobApplication updatedJobApplication = jobApplicationService.updateJobApplication(newJobApplication, id);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @PutMapping("/{id}/interview")
    public ResponseEntity<JobApplication> interviewJobApplication(@PathVariable Long id) {
        JobApplication updatedJobApplication = jobApplicationService.interviewJobApplication(id);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<JobApplication> acceptJobApplication(@PathVariable Long id) {
        JobApplication updatedJobApplication = jobApplicationService.acceptJobApplication(id);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<JobApplication> confirmJobApplication(@PathVariable Long id) {
        JobApplication updatedJobApplication = jobApplicationService.confirmJobApplication(id);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteJobApplication(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAllJobApplications() {
        jobApplicationService.deleteAllJobApplications();
        return ResponseEntity.noContent().build();
    }
}
