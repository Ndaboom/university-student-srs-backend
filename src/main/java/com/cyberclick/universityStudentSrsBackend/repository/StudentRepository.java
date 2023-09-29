package com.cyberclick.universityStudentSrsBackend.repository;

import com.cyberclick.universityStudentSrsBackend.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students, String> {
    // Return student by name
    List<Students> findByStudentFirstName(String studentFirstName);
}
