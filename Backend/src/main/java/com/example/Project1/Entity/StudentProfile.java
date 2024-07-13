package com.example.Project1.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    @JsonBackReference(value = "user-student")
    private User user;

    private String fullname;

    private String grade;

    private String email;

    private String faculty;

    private String major;

    private Number studentID;

    private Number phoneNumber;

    private String InternDate; 

    private String CV;

    @OneToMany(mappedBy = "studentProfile", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "student-apply")
    private List<JobApplication> jobApplications;

}
