package com.example.Project1.Entity;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    private String topic;

    private String detail;

    private String img;

    private Instant date;

    private String link;

    private String contract;

}
