package com.cyberclick.universityStudentSrsBackend.repository;

import com.cyberclick.universityStudentSrsBackend.entity.Schools;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<Schools, String> {
    List<Schools> findBySchoolName(String schoolName);
}
