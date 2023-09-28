package com.cyberclick.universityStudentSrsBackend.service.impl;

import com.cyberclick.universityStudentSrsBackend.entity.Department;
import com.cyberclick.universityStudentSrsBackend.exception.CustomNotFoundException;
import com.cyberclick.universityStudentSrsBackend.repository.DepartmentRepository;
import com.cyberclick.universityStudentSrsBackend.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String createDepartment(Department department) {
        departmentRepository.save(department);
        return "Created successfully";
    }

    @Override
    public String updateDepartment(Department department) {
        departmentRepository.save(department);
        return "Updated successfully";
    }

    @Override
    public String deleteDepartment(String departmentId) {
        if(departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
            return "Record deleted successfully";
        } else{
            throw new CustomNotFoundException("Requested department does not exist");
        }
    }

    @Override
    public Department getDepartment(String departmentId) {
        if(departmentRepository.findById(departmentId).isEmpty())
            throw new CustomNotFoundException("Requested department does not exist");
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
