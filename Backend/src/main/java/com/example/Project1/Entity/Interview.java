package com.example.Project1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    private String dateTime; 

    private String type;

    private String detail;

    private String linkAddress;

}
