package com.example.Project1.Controller;

import com.example.Project1.Entity.ManualJobApplication;
import com.example.Project1.Service.ManualJobApplicationService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ManualJobApplications")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ManualJobApplicationController {

    private final ManualJobApplicationService manualJobApplicationService;

    @PostMapping("/")
    public ResponseEntity<ManualJobApplication> createManualJobApplication(@RequestBody ManualJobApplication manualJobApplication) {
        ManualJobApplication newManualJobApplication = manualJobApplicationService.createManualJobApplication(manualJobApplication);
        return new ResponseEntity<>(newManualJobApplication, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ManualJobApplication>> getAllManualJobApplications() {
        List<ManualJobApplication> manualJobApplications = manualJobApplicationService.getAllManualJobApplications();
        return new ResponseEntity<>(manualJobApplications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManualJobApplication> getManualJobApplicationById(@PathVariable Long id) {
        Optional<ManualJobApplication> manualJobApplication = manualJobApplicationService.getManualJobApplicationById(id);
        return manualJobApplication.map(ResponseEntity::ok)
                                   .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManualJobApplication> updateManualJobApplication(@PathVariable Long id, @RequestBody ManualJobApplication newManualJobApplication) {
        ManualJobApplication updatedManualJobApplication = manualJobApplicationService.updateManualJobApplication(newManualJobApplication, id);
        return new ResponseEntity<>(updatedManualJobApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManualJobApplication(@PathVariable Long id) {
        manualJobApplicationService.deleteManualJobApplication(id);
        return ResponseEntity.noContent().build();
    }
}
