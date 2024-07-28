package com.example.Project1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class TeacherProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id" , referencedColumnName = "id")
    @JsonBackReference(value = "person-teacher")
    private Person person;

    private String fullname;

    private String email;

    private String phoneNumber;

    private String faculty;

    private String major;

    @Column(unique = true) 
    private String teacherID;


}
