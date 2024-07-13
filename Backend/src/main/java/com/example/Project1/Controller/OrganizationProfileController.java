package com.example.Project1.Controller;

import com.example.Project1.Entity.OrganizationProfile;
import com.example.Project1.Service.OrganizationProfileService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizations")
@CrossOrigin("*")
@RequiredArgsConstructor
public class OrganizationProfileController {

    private final OrganizationProfileService organizationProfileService;

    @PostMapping("/")
    public ResponseEntity<OrganizationProfile> createOrganizationProfile(@RequestBody OrganizationProfile organizationProfile) {
        OrganizationProfile newOrganizationProfile = organizationProfileService.createOrganizationProfile(organizationProfile);
        return new ResponseEntity<>(newOrganizationProfile, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrganizationProfile>> getAllOrganizationProfiles() {
        List<OrganizationProfile> organizationProfiles = organizationProfileService.getAllOrganizationProfiles();
        return new ResponseEntity<>(organizationProfiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationProfile> getOrganizationProfileById(@PathVariable Long id) {
        Optional<OrganizationProfile> organizationProfile = organizationProfileService.getOrganizationProfileById(id);
        return organizationProfile.map(ResponseEntity::ok)
                                 .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationProfile> updateOrganizationProfile(@PathVariable Long id, @RequestBody OrganizationProfile newOrganizationProfile) {
        OrganizationProfile updatedOrganizationProfile = organizationProfileService.updateOrganizationProfile(newOrganizationProfile, id);
        return new ResponseEntity<>(updatedOrganizationProfile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizationProfile(@PathVariable Long id) {
        organizationProfileService.deleteOrganizationProfile(id);
        return ResponseEntity.noContent().build();
    }
}
