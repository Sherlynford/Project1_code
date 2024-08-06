package com.example.Project1.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
public class ManualJobApplication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id" , referencedColumnName = "id")
    @JsonBackReference(value = "student-ManualApply")
    private StudentProfile studentProfile;

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false)  
    private String OrganizationName;

    private String OrganizationAddress;

    private String OrganizationContract;

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false)  
    private String JobName;

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false,name = "applicationStatus")  
    private String applicationStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate ApplicationDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime InterviewDate;
}
