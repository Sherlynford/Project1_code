package com.example.Project1.Service;

import com.example.Project1.Entity.OrganizationProfile;
import com.example.Project1.Repository.OrganizationProfileRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationProfileService {

    private final OrganizationProfileRepository organizationProfileRepository;

    public OrganizationProfile createOrganizationProfile(OrganizationProfile organizationProfile) {
        return organizationProfileRepository.save(organizationProfile);
    }

    public List<OrganizationProfile> getAllOrganizationProfiles() {
        return organizationProfileRepository.findAll();
    }

    public Optional<OrganizationProfile> getOrganizationProfileById(Long id) {
        return organizationProfileRepository.findById(id);
    }

    public OrganizationProfile updateOrganizationProfile(OrganizationProfile newOrganizationProfile, Long id) {
        return organizationProfileRepository.findById(id)
                .map(organizationProfile -> {
                    organizationProfile.setLogo(newOrganizationProfile.getLogo());
                    organizationProfile.setName(newOrganizationProfile.getName());
                    organizationProfile.setDetail(newOrganizationProfile.getDetail());
                    organizationProfile.setAddress(newOrganizationProfile.getAddress());
                    organizationProfile.setEmail(newOrganizationProfile.getEmail());
                    organizationProfile.setPhoneNumber(newOrganizationProfile.getPhoneNumber());
                    return organizationProfileRepository.save(organizationProfile);
                })
                .orElseGet(() -> {
                    newOrganizationProfile.setId(id);
                    return organizationProfileRepository.save(newOrganizationProfile);
                });
    }

    public void deleteOrganizationProfile(Long id) {
        organizationProfileRepository.deleteById(id);
    }
}
