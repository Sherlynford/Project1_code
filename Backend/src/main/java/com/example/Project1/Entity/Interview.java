package com.example.Project1.Entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jobApplication_id" , referencedColumnName = "id")
    @JsonBackReference(value = "apply-interview")
    private JobApplication jobApplication;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime; 

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false)
    private String type;

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false)  
    private String detail;

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false)  
    private String linkAddress;

}
