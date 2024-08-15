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
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id" , referencedColumnName = "id")
    @JsonBackReference(value = "person-student")
    private Person person;

    private String fullname;

    private String grade;

    private String year;

    private String contract;

    private String faculty;

    private String major;

    @Column(unique = true) 
    private String studentID;

    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate internStartDate; 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate internEndDate;

    private String CV;

    @OneToMany(mappedBy = "studentProfile", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "student-ManualApply")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ManualJobApplication> manualJobApplications;

}
