package com.cyberclick.universityStudentSrsBackend.controller;

import com.cyberclick.universityStudentSrsBackend.entity.Department;
import com.cyberclick.universityStudentSrsBackend.entity.Schools;
import com.cyberclick.universityStudentSrsBackend.response.ResponseHandler;
import com.cyberclick.universityStudentSrsBackend.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{departmentId}")
    public ResponseEntity<Object> getDepartmentDetails(@PathVariable("departmentId") String departmentId){
        return ResponseHandler.responseBuilder("Department details", HttpStatus.OK, departmentService.getDepartment(departmentId));
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> getAllDepartments(){
        return ResponseHandler.responseBuilder("Departments list", HttpStatus.OK, departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<Object> createDepartment(@RequestBody Department department)
    {
        return ResponseHandler.responseBuilder("Department created", HttpStatus.OK, departmentService.createDepartment(department));
    }

    @PutMapping()
    public ResponseEntity<Object> updateDepartment(@RequestBody Department department)
    {
        return ResponseHandler.responseBuilder("Department updated", HttpStatus.OK, departmentService.updateDepartment(department));
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable("departmentId") String departmentId)
    {
        return ResponseHandler.responseBuilder("Department deleted", HttpStatus.OK, departmentService.deleteDepartment(departmentId));
    }
}
