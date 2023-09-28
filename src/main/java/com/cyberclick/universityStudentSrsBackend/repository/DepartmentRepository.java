package com.cyberclick.universityStudentSrsBackend.repository;

import com.cyberclick.universityStudentSrsBackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByDepartmentName(String departmentName);
}
