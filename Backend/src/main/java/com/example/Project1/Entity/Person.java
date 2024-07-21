package com.example.Project1.Entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private StudentProfile studentProfile;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "person-teacher")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TeacherProfile teacherProfile;
    
    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "person-organization")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private OrganizationProfile organizationProfile;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "person-blog")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Blog> blogs;

}
