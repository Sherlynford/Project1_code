package com.example.Project1.Repository;

import com.example.Project1.Entity.ManualJobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualJobApplicationRepository extends JpaRepository<ManualJobApplication, Long>{
    
}
