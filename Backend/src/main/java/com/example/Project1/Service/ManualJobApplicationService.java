package com.example.Project1.Service;

import com.example.Project1.Entity.ManualJobApplication;
import com.example.Project1.Repository.ManualJobApplicationRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManualJobApplicationService {
    
    private final ManualJobApplicationRepository manualJobApplicationRepository;

    public ManualJobApplication createManualJobApplication(ManualJobApplication manualJobApplication) {
        return manualJobApplicationRepository.save(manualJobApplication);
    }

    public List<ManualJobApplication> getAllManualJobApplications() {
        return manualJobApplicationRepository.findAll();
    }

    public Optional<ManualJobApplication> getManualJobApplicationById(Long id) {
        return manualJobApplicationRepository.findById(id);
    }

    public ManualJobApplication updateManualJobApplication(ManualJobApplication newManualJobApplication, Long id) {
        return manualJobApplicationRepository.findById(id)
                .map(manualJobApplication -> {
                    manualJobApplication.setOrganizationName(newManualJobApplication.getOrganizationName());
                    manualJobApplication.setOrganizationAddress(newManualJobApplication.getOrganizationAddress());
                    manualJobApplication.setOrganizationContract(newManualJobApplication.getOrganizationContract());
                    manualJobApplication.setJobName(newManualJobApplication.getJobName());
                    manualJobApplication.setApplicationStatus(newManualJobApplication.getApplicationStatus());
                    manualJobApplication.setApplicationDateTime(newManualJobApplication.getApplicationDateTime());
                    manualJobApplication.setInterviewDate(newManualJobApplication.getInterviewDate());
                    return manualJobApplicationRepository.save(manualJobApplication);
                })
                .orElseGet(() -> {
                    newManualJobApplication.setId(id);
                    return manualJobApplicationRepository.save(newManualJobApplication);
                });
    }

    public void deleteManualJobApplication(Long id) {
        manualJobApplicationRepository.deleteById(id);
    }
}
