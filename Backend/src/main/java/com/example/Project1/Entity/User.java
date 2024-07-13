package com.example.Project1.Entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role;

    private String email;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-student")
    private StudentProfile studentProfile;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-teacher")
    private TeacherProfile teacherProfile;
    
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-organization")
    private OrganizationProfile organizationProfile;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-blog")
    private List<Blog> blogs;

}
