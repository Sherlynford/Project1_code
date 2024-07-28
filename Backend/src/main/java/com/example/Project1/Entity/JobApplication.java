package com.example.Project1.Entity;


import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class JobApplication {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id" , referencedColumnName = "id")
    @JsonBackReference(value = "student-apply")
    private StudentProfile studentProfile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id" , referencedColumnName = "id")
    @JsonBackReference(value = "job-apply")
    private Job job;

    private String status;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant dateTime;

    @OneToOne(mappedBy = "jobApplication", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "apply-interview")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Interview interviews;

}
