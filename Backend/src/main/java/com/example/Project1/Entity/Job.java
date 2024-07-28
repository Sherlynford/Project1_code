package com.example.Project1.Entity;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    private Integer numberApplication;

    private String benefitSalary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate applicationTime; 

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "job-apply")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JobApplication> jobApplications;

}
