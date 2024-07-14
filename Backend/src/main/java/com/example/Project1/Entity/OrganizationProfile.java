package com.example.Project1.Entity;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class OrganizationProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id" , referencedColumnName = "id")
    @JsonBackReference(value = "person-organization")
    private Person person;

    private String logo;

    private String name;

    private String detail;

    private String address;

    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "organizationProfile", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "Organization-job")
    private List<Job> jobs;

}
