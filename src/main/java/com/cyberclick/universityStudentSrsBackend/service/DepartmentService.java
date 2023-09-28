package com.cyberclick.universityStudentSrsBackend.service;

import com.cyberclick.universityStudentSrsBackend.entity.Department;

import java.util.List;

public interface DepartmentService {
    public String createDepartment(Department department);

    public String updateDepartment(Department department);

    public String deleteDepartment(String departmentId);

    Department getDepartment(String departmentId);

    public List<Department> getAllDepartments();

    List<Department> getByDepartmentName(String departmentName);
}
