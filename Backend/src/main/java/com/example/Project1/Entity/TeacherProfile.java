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
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    @JsonBackReference(value = "user-teacher")
    private User user;

    private String fullname;

    private String email;

    private Number phoneNumber;

    private String faculty;

    private String major;

    private Number teacherID;


}
