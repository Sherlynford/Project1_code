package com.example.Project1.Entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Organization_id" , referencedColumnName = "id")
    @JsonBackReference(value = "Organization-job")
    private OrganizationProfile organizationProfile;

    private String name;

    private String detail;

    private String category;

    private String qualification;

    private String timeWorkingDate;

    private Number numberApplication;

    private String benefitSalary;

    private String applicationTime; 

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "job-apply")
    private List<JobApplication> jobApplications;

}
