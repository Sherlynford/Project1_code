package com.example.Project1.Entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
public class Blog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id" , referencedColumnName = "id")
    @JsonBackReference(value = "person-blog")
    private Person person;

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false)  
    private String topic;

    @NotBlank(message = "cannot be null or empty")
    @Column(nullable = false)  
    private String detail;

    private String img;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String link;

    private String contract;

}
