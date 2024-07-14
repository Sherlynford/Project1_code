package com.example.Project1.Entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role;

    private String email;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "person-student")
    private StudentProfile studentProfile;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "person-teacher")
    private TeacherProfile teacherProfile;
    
    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "person-organization")
    private OrganizationProfile organizationProfile;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "person-blog")
    private List<Blog> blogs;

}
